package com.mx.consul.med.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mx.consul.med.exam.web.interceptor.AuditInterceptor;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan({ "com.mx.consul.med.exam" })
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    @Qualifier("citasmedDB")
    private DataSource citasmedDS;
    
    @Bean
    @Qualifier("citasmedDB_Named")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate_citasmed(@Qualifier("citasmedDB") DataSource citasmedDB) {
        return new NamedParameterJdbcTemplate(citasmedDB);
    }

    @Bean(name = "citasmedJdbcTemplate")
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("citasmedDB") DataSource citasmedDB) {
        return new JdbcTemplate(citasmedDB);
    }

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
				"classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public AuditInterceptor auditInterceptor() {
		return new AuditInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auditInterceptor());
	}



	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON , new MediaType("text")));
        converters.add(converter);
	}

	
	


}