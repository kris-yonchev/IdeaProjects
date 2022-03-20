package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Part;
import com.example.demo.entities.Sale;
import com.example.demo.entities.q6.SaleRootWithCarCustomerPriceDto;
import com.example.demo.entities.q6.SaleWithCarCustomerPriceDto;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService, ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedDate() {
        if (saleRepository.count() > 0) {
            return;
        }

        long cCount = customerRepository.count();
        for (long i = 1; i <= cCount; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1, customerRepository.count() + 1);
            Sale sale = new Sale();
            Customer customer = customerRepository.findById(randomId).orElse(null);
            Car car = carService.getRandomCar();
            sale.setCustomer(customer);
            sale.setCar(car);

            BigDecimal[] discounts = new BigDecimal[]{
                    BigDecimal.valueOf(0),
                    BigDecimal.valueOf(5),
                    BigDecimal.valueOf(10),
                    BigDecimal.valueOf(15),
                    BigDecimal.valueOf(20),
                    BigDecimal.valueOf(30),
                    BigDecimal.valueOf(40),
                    BigDecimal.valueOf(50)
            };
            int randomDiscount = ThreadLocalRandom.current().nextInt(0, discounts.length);
            BigDecimal discount = discounts[randomDiscount];
            assert customer != null;
            if (customer.isYoungDriver()) {
                discount = discount.add(BigDecimal.valueOf(5L));
            }
            sale.setDiscountPercentage(discount);
            saleRepository.save(sale);
        }

    }

    @Override
    public SaleRootWithCarCustomerPriceDto getSales() {
        List<Sale> sales = saleRepository.findAll();
        SaleRootWithCarCustomerPriceDto saleRoot = new SaleRootWithCarCustomerPriceDto();
        saleRoot.setCarCustomerPriceDto(sales.stream()
                .map(s -> {

                    SaleWithCarCustomerPriceDto saleWith = modelMapper.map(s, SaleWithCarCustomerPriceDto.class);
                    saleWith.setDiscount(s.getDiscountPercentage());
                    BigDecimal price = s.getCar().getParts().stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                    saleWith.setPrice(price);
                    BigDecimal withDiscount = price.multiply(BigDecimal.valueOf(1L).subtract(s.getDiscountPercentage().divide(BigDecimal.valueOf(100L))));
                    saleWith.setPriceWithDiscount(withDiscount);

                    return saleWith;
                }).collect(Collectors.toList()));
        return saleRoot;
    }

}
