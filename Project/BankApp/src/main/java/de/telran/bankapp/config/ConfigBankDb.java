package de.telran.bankapp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "de.telran.bankapp.repository.bank",
        entityManagerFactoryRef = "bankDbEntityManagerFactory",
        transactionManagerRef = "getBankDbPTM")
public class ConfigBankDb {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.bankdb")
    DataSourceProperties getBankDbDatasourceProperties() {
        System.out.println("Run getBankDbDatasourceProperties");
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    DataSource getBankDbDatasource() {
        System.out.println("Run getBankDbDatasource");
        return getBankDbDatasourceProperties().initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name="bankDbEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean getBankDbLocalEMF(EntityManagerFactoryBuilder builder) {
        System.out.println("Run getBankDbLocalEMF");
        return builder.dataSource(getBankDbDatasource()).packages("de.telran.bankapp.entity.bank").build();
    }

    @Primary
    @Bean
    PlatformTransactionManager getBankDbPTM(
            final @Qualifier("bankDbEntityManagerFactory") LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean) {
        System.out.println("Run getBankDbPTM");
        return new JpaTransactionManager(containerEntityManagerFactoryBean.getObject());
    }

}
