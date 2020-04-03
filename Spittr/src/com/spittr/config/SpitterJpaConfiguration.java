package com.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.spittr", repositoryImplementationPostfix = "Impl")
@Configuration
public class SpitterJpaConfiguration {

}
