package com.example.demo.services;

import com.example.demo.entities.product.Product;
import com.example.demo.entities.product.ProductImportRootDto;
import com.example.demo.entities.product.ProductInRangeDto;
import com.example.demo.entities.product.ProductsRootInRangeDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_PATH = "src/main/resources/products.xml";

    private final ProductRepository productRepository;

    private final UserService userService;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedData() throws IOException, JAXBException {
        if (productRepository.count() > 0) {
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductImportRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ProductImportRootDto productImportRootDto = (ProductImportRootDto) unmarshaller.unmarshal(new FileReader(PRODUCTS_FILE_PATH));
        List<Product> products = productImportRootDto
                .getProductImportDto()
                .stream()
                .filter(validationUtil::isValid)
                .map(p -> {
                    Product product = modelMapper.map(p, Product.class);
                    product.setSeller(userService.findRandom());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(750)) > 0) {
                        product.setBuyer(userService.findRandom());
                    }

                    product.setCategories(categoryService.findRandomCategories());
                    return product;
                }).collect(Collectors.toList());

        productRepository.saveAll(products);
    }

    @Override
    public ProductsRootInRangeDto findAllProductInRangeOrderByPrice(BigDecimal lower, BigDecimal higher) {
        ProductsRootInRangeDto products = new ProductsRootInRangeDto();

        products.setProducts(productRepository
                .findAllByPriceBetweenAndBuyerIdIsNullOrderByPriceDesc(lower, higher)
                .stream()
                .map(p -> {
                    ProductInRangeDto productInRangeDto = modelMapper.map(p, ProductInRangeDto.class);
                    productInRangeDto.setSeller(String.format("%s %s", p.getSeller().getFirstName(),
                            p.getSeller().getLastName()));
                    return productInRangeDto;
                }).collect(Collectors.toList()));
        return products;
    }

}
