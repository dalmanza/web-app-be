package com.zemoga.tech.test.webapp.infrastructure.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JPAConfiguration {

	@Profile("local")
	@Bean(name = "datasource-portfolio")
	@ConfigurationProperties(prefix = "spring.datasource.portfolio")
	public DataSource datasourcePortfolio() {
		return DataSourceBuilder.create().build();
	}
}
