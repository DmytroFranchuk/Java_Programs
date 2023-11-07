package de.telran.bankapp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "de.telran.bankapp.repository.auth",
        entityManagerFactoryRef = "securityDbEntityManagerFactory",
        transactionManagerRef = "getSecurityDbPTM")
public class ConfigSecurityDb {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.security")
    DataSourceProperties getSecurityDbDatasourceProperties() {
        System.out.println("Run getSecurityDbDatasourceProperties");
        return new DataSourceProperties();
    }

    @Bean
    DataSource getSecurityDbDatasource() {
        System.out.println("Run getSecurityDbDatasource");
        return getSecurityDbDatasourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name="securityDbEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean getSecurityLocalEMF(EntityManagerFactoryBuilder builder) {
        System.out.println("Run getSecurityLocalEMF");
        return builder.dataSource(getSecurityDbDatasource()).packages("de.telran.bankapp.entity.auth").build();
    }

    @Bean
    PlatformTransactionManager getSecurityDbPTM(
            final @Qualifier("securityDbEntityManagerFactory") LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean) {
        System.out.println("Run getSecurityDbPTM");
        return new JpaTransactionManager(containerEntityManagerFactoryBean.getObject());
    }
}
