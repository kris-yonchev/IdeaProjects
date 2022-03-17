package com.example.demo.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

}
