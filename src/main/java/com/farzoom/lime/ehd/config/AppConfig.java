package com.farzoom.lime.ehd.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
public class AppConfig {

    @Value("${elasticsearch.baseurl}")
    String elasticsearchBaseUrl;

}
