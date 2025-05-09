package com.mx.consul.med.exam.web;

import com.mx.consul.med.exam.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class ProfileDatabaseConfig implements TransactionManagementConfigurer {

	@Value("${jndi.consulmed}")
	private String jndiCITAS;
 
	@Bean(name = "consulmedDB")
	public DataSource oracleDataSource() throws NamingException {
		JndiObjectFactoryBean jndiFactoryBean = new JndiObjectFactoryBean();
		jndiFactoryBean.setJndiName(jndiCITAS);
		jndiFactoryBean.setExpectedType(DataSource.class);
		jndiFactoryBean.setLookupOnStartup(true);
		jndiFactoryBean.setResourceRef(true);
		jndiFactoryBean.afterPropertiesSet();
		return (DataSource)jndiFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		try {
			return new DataSourceTransactionManager(oracleDataSource());
		} catch(NamingException ex) {
			throw new ServiceException("No fue posible iniciar transaccionalidad ", ex);
		}
	}

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

}
