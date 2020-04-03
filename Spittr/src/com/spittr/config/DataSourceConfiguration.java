package com.spittr.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
	
	@Profile("development")
	@Bean
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScript("classpath:schema.sql")
					.addScript("classpath:sample-data.sql")
					.build();
		
	}
	@Profile("qa")
	@Bean
	public DataSource basicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		return dataSource;
	}
	
	@Profile("production")
	@Bean
	public DataSource jndiDataSource() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
		
		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_authentication");
		dataSource.setUsername("root");
		dataSource.setPassword("pass");
		return dataSource;
	}
	
//	@Bean
//	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
	
//	@Bean
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
//		return new NamedParameterJdbcTemplate(dataSource);
//	}
	
//	@Bean
//	public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
//		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//		sfb.setDataSource(dataSource);
//		sfb.setPackagesToScan(new String[] {"com.spittr"});
//		Properties props = new Properties();
//		props.setProperty("dialect", "	org.hibernate.dialect.MySQLDialect");
//		sfb.setHibernateProperties(props);
//		return sfb;
//	}
//	

	
//	@Bean
//	public BeanPostProcessor persistenceTranslator() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(false);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
		
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.spittr");
		return emfb;
	}
//	
//	@Bean
//	public JpaTransactionManager transactionManager(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFacory(dataSource,jpaVendorAdapter));
//		return transactionManager;
//	}
	
	@Bean
	public PlatformTransactionManager  transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}
	
	@Bean
	public PersistenceAnnotationBeanPostProcessor paBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

}
