package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Part;
import com.example.demo.entities.Sale;
import com.example.demo.entities.dto.CustomerInputDto;
import com.example.demo.entities.dto.q5.CustomerCarCountDto;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMER_FILE_PATH = "src/main/resources/files/customers.json";

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;

    public CustomerServiceImpl(Gson gson, ModelMapper modelMapper, CustomerRepository customerRepository, ValidationUtil validationUtil) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedDate() throws IOException {
        if (customerRepository.count() > 0) {
            return;
        }

        CustomerInputDto[] customerInputDtos = gson.fromJson(Files.readString(Path.of(CUSTOMER_FILE_PATH)), CustomerInputDto[].class);

        Arrays.stream(customerInputDtos)
                .filter(validationUtil::isValid)
                .map(c -> {
                    Customer customer = modelMapper.map(c, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(c.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                    return customer;
                })
                .forEach(customerRepository::save);
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
    public List<CustomerCarCountDto> getCustomerCars() {
        return customerRepository
                .getAllBySaleListBiggerThanOne()
                .stream()
                .map(c -> {
                    CustomerCarCountDto customerCarCountDto = new CustomerCarCountDto();
                    customerCarCountDto.setName(c.getName());
                    customerCarCountDto.setBoughtCars(c.getSales().size());
                    List<Car> cars = c.getSales().stream().map(Sale::getCar).collect(Collectors.toList());
                    List<BigDecimal> discounts = c.getSales().stream().map(Sale::getDiscountPercentage).collect(Collectors.toList());

                    BigDecimal spentMoney = BigDecimal.valueOf(0);
                    for (Car car : cars) {
                        List<Part> parts = car.getParts();
                        for (Part part : parts) {
                            spentMoney = spentMoney.add(part.getPrice());
                        }
                    }
                    spentMoney = spentMoney.multiply(BigDecimal.valueOf(1L).subtract(discounts.get(0).divide(BigDecimal.valueOf(100L))));
                    customerCarCountDto.setSpentMoney(spentMoney);
                    return customerCarCountDto;
                }).collect(Collectors.toList());
    }
}
