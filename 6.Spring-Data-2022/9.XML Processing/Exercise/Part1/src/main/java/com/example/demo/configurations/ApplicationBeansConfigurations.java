package com.example.demo.configurations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeansConfigurations {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
