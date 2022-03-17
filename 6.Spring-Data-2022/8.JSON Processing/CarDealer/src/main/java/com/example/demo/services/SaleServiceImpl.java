package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Part;
import com.example.demo.entities.Sale;
import com.example.demo.entities.dto.q1.CarSaleDto;
import com.example.demo.entities.dto.q1.SaleCustomerDto;
import com.example.demo.entities.dto.q4.CarInfoDto;
import com.example.demo.entities.dto.q6.SaleDiscountDto;
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
            Sale sale = new Sale();
            Customer customer = customerRepository.findById(i).orElse(null);
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
            if (customer.isYoungDriver()) {
                discount = discount.add(BigDecimal.valueOf(5L));
            }
            sale.setDiscountPercentage(discount);
            saleRepository.save(sale);
        }

    }

    @Override
    public List<SaleCustomerDto> getSaleByUser(Long id) {
        List<Sale> sales = saleRepository.findAllByCustomerId(id);
        return sales.stream().map(s -> {
            Car car = s.getCar();
            SaleCustomerDto saleCustomerDto = modelMapper.map(s, SaleCustomerDto.class);
            saleCustomerDto.setCarSaleDto(modelMapper.map(car, CarSaleDto.class));
            return saleCustomerDto;
        })
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleDiscountDto> getAllSales() {
        return saleRepository
                .findAll()
                .stream()
                .map(s -> {
                    SaleDiscountDto saleDiscountDto = modelMapper.map(s, SaleDiscountDto.class);
                    Car car = s.getCar();
                    saleDiscountDto.setCar(modelMapper.map(car, CarInfoDto.class));
                    List<Part> parts = car.getParts();
                    BigDecimal price = BigDecimal.valueOf(0);
                    for (Part part : parts) {
                        price = price.add(part.getPrice());
                    }
                    saleDiscountDto.setPrice(price);
                    BigDecimal discountPrice = price.multiply(BigDecimal.valueOf(1L).subtract(s.getDiscountPercentage().divide(BigDecimal.valueOf(100L))));
                    saleDiscountDto.setPriceWithDiscount(discountPrice);
                    return saleDiscountDto;
                })
                .collect(Collectors.toList());
    }
}
