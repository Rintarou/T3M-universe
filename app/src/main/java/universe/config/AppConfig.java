package universe.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = {"universe.service"})
@PropertySource("classpath:infos.properties")
@EnableJpaRepositories("projetCommande.repositories")
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));
		basicDataSource.setUrl(env.getProperty("dataSource.url"));
		basicDataSource.setUsername(env.getProperty("dataSource.username"));
		basicDataSource.setPassword(env.getProperty("dataSource.password"));
		return basicDataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setPackagesToScan("universe.model");
		emf.setJpaProperties(this.hibernateProperties());
		return emf;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}
