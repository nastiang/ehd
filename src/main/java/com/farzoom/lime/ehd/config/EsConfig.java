package com.farzoom.lime.ehd.config;

import com.farzoom.common.persistence.es.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {

    @Bean
    public OrderRepository esOrderRepository(AppConfig config){ return new OrderRepository(config.elasticsearchBaseUrl); }

    @Bean
    public CompanyRepository esCompanyRepository(AppConfig config){ return new CompanyRepository(config.elasticsearchBaseUrl); }

    @Bean
    public PersonRepository esPersonRepository(AppConfig config) {
        return new PersonRepository(config.elasticsearchBaseUrl);
    }

    @Bean
    public AddressRepository addressRepository(AppConfig config) {
        return new AddressRepository(config.elasticsearchBaseUrl);
    }

    @Bean
    public AttributeRepository attributeRepository(AppConfig config){
        return new AttributeRepository(config.elasticsearchBaseUrl);
    }

    @Bean
    public GroupRepository groupRepository(AppConfig config){
        return new GroupRepository(config.elasticsearchBaseUrl);
    }

    @Bean
    public ParamRepository paramRepository(AppConfig config){
        return new ParamRepository(config.elasticsearchBaseUrl);
    }


}
