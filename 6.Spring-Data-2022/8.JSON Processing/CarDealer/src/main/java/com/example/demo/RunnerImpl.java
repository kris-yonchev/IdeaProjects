package com.example.demo;

import com.example.demo.entities.Car;
import com.example.demo.entities.dto.q1.OrderedCustomerDto;
import com.example.demo.entities.dto.q2.CarFromMakeDto;
import com.example.demo.entities.dto.q3.LocalSupplierDto;
import com.example.demo.entities.dto.q4.CarModelMakeDto;
import com.example.demo.entities.dto.q5.CustomerCarCountDto;
import com.example.demo.entities.dto.q6.SaleDiscountDto;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.*;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CarRepository carRepository;

    public RunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, ModelMapper modelMapper, Gson gson, CarRepository carRepository) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.carRepository = carRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

//        queryOne();
//        queryTwo();
//        queryThree();
//        queryFour();
//        queryFive();
//        querySix();


    }

    private void querySix() {
        List<SaleDiscountDto> saleDiscountDtos = saleService.getAllSales();
        String s = gson.toJson(saleDiscountDtos);
        System.out.println(s);
    }

    private void queryFive() {
        List<CustomerCarCountDto> customerCarCountDtos = customerService.getCustomerCars();
        String s = gson.toJson(customerCarCountDtos);
        System.out.println(s);
    }

    private void queryFour() {
        List<CarModelMakeDto> carModelMakeDtos = carService.getCarModelMakeParts();
        String s = gson.toJson(carModelMakeDtos);
        System.out.println(s);
    }

    private void queryThree() {
        List<LocalSupplierDto> localSupplierDtos = supplierService.getSupplierByImport();
        String s = gson.toJson(localSupplierDtos);
        System.out.println(s);
    }

    private void queryTwo() {
        List<CarFromMakeDto> carFromMakeDtos = carService.getCarsFromMake();
        String s = gson.toJson(carFromMakeDtos);
        System.out.println(s);
    }

    private void queryOne() {
        List<OrderedCustomerDto> orderedCustomerDtos = customerService.findAll().stream().map(c -> {
            OrderedCustomerDto orderedCustomerDto = modelMapper.map(c, OrderedCustomerDto.class);
            orderedCustomerDto.setSales(saleService.getSaleByUser(c.getId()));
            return orderedCustomerDto;
        })
                .collect(Collectors.toList());

        String s = gson.toJson(orderedCustomerDtos);
        System.out.println(s);


    }

    private void seedData() throws IOException {
        supplierService.seedData();
        partService.seedData();
        carService.seedData();
        customerService.seedDate();
        saleService.seedDate();

    }
}
