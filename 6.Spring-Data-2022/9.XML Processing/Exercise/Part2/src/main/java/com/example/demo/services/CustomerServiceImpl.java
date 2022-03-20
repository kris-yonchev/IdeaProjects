package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Part;
import com.example.demo.entities.Sale;
import com.example.demo.entities.q1.CustomerInfoDto;
import com.example.demo.entities.q1.CustomerRootInfoDto;
import com.example.demo.entities.q5.CustomerRootWithCarDto;
import com.example.demo.entities.q5.CustomerWithCarDto;
import com.example.demo.entities.seedDto.customer.CustomerRootSeedDto;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMER_FILE_PATH = "src/main/resources/files/customers.xml";

    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedDate() throws IOException, JAXBException {
        if (customerRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerRootSeedDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CustomerRootSeedDto customerRootSeedDto = (CustomerRootSeedDto) unmarshaller.unmarshal(new FileReader(CUSTOMER_FILE_PATH));
        List<Customer> customers = customerRootSeedDto.getCustomers()
                .stream()
                .filter(validationUtil::validate)
                .map(c -> {
                    Customer customer = modelMapper.map(c, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(c.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                    return customer;
                })
                .collect(Collectors.toList());

        customerRepository.saveAll(customers);
    }

    @Override
    public Customer getRandomCustomer() {
        long repoSize = customerRepository.count();
        long id = ThreadLocalRandom.current().nextLong(1, repoSize + 1);
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .sorted(Comparator.comparing(Customer::getBirthDate)
                        .thenComparing(Customer::isYoungDriver))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerRootInfoDto getAllCustomers() {
        CustomerRootInfoDto customerRootInfoDto = new CustomerRootInfoDto();
        customerRootInfoDto.setCustomers(customerRepository.getCustomerInfo()
                .stream()
                .map(c -> modelMapper.map(c, CustomerInfoDto.class)).collect(Collectors.toList()));

        return customerRootInfoDto;
    }

    @Override
    public CustomerRootWithCarDto getCustomerWithAtLeastOneBoughtCar() {
        List<String> customers = customerRepository.getAllBySaleListBiggerThanOne();
        CustomerRootWithCarDto customerRootWithCarDto = new CustomerRootWithCarDto();
        customerRootWithCarDto.setCustomers(customers.stream().map(c -> c.split(","))
        .map(c -> new CustomerWithCarDto(c[0], Integer.parseInt(c[1]), Double.parseDouble(c[2])))
                .collect(Collectors.toList()));

        return customerRootWithCarDto;
    }

}
