package com.example.demo;

import com.example.demo.entities.q1.CustomerRootInfoDto;
import com.example.demo.entities.q2.CarRootToyotaDto;
import com.example.demo.entities.q3.SupplierRootInfoDto;
import com.example.demo.entities.q4.CarRootInfoDto;
import com.example.demo.entities.q5.CustomerRootWithCarDto;
import com.example.demo.entities.q6.SaleRootWithCarCustomerPriceDto;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;

@Component
public class LineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public LineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }


    @Override
    public void run(String... args) throws Exception {

        seedData();
//        queryOne();
//        queryTwo();
//        queryThree();
//        queryFour();
//        queryFive();
        querySix();
    }

    private void querySix() throws JAXBException {
        SaleRootWithCarCustomerPriceDto saleRootWithCarCustomerPrice = saleService.getSales();
        JAXBContext jaxbContext = JAXBContext.newInstance(SaleRootWithCarCustomerPriceDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(saleRootWithCarCustomerPrice, System.out);
    }

    private void queryFive() throws JAXBException {
        CustomerRootWithCarDto customerRootWithCarDto = customerService.getCustomerWithAtLeastOneBoughtCar();
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerRootWithCarDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customerRootWithCarDto, System.out);
    }

    private void queryFour() throws JAXBException {
        CarRootInfoDto carRootInfoDto = carService.getAllCarsWithParts();
        JAXBContext jaxbContext = JAXBContext.newInstance(CarRootInfoDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(carRootInfoDto, System.out);
    }

    private void queryThree() throws JAXBException {
        SupplierRootInfoDto supplierRootInfoDto = supplierService.findAllSuppliersNotImporting();
        JAXBContext jaxbContext = JAXBContext.newInstance(SupplierRootInfoDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(supplierRootInfoDto, System.out);
    }

    private void queryTwo() throws JAXBException {
        CarRootToyotaDto carRootToyotaDto = carService.getAllByMaker();
        JAXBContext jaxbContext = JAXBContext.newInstance(CarRootToyotaDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(carRootToyotaDto, System.out);
    }

    private void queryOne() throws JAXBException {
        CustomerRootInfoDto customerRootInfoDto = customerService.getAllCustomers();
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerRootInfoDto.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customerRootInfoDto, System.out);
    }

    private void seedData() throws JAXBException, IOException {
        supplierService.seedData();
        partService.seedData();
        carService.seedData();
        customerService.seedDate();
        saleService.seedDate();
    }
}
