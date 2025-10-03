package ca.mss.springboot.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Configuration
@ConfigurationProperties("spring.datasource-acct")
public class AcctDatasourceConfiguration extends HikariConfig {

    @Bean
    public HikariDataSource acctDataSource() {
        return new HikariDataSource(this);
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource-acct")
//    public DataSourceProperties acctDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource acctDataSource() {
//        return acctDataSourceProperties()
//                .initializeDataSourceBuilder()
//                .build();
//    }

    @Bean
    public JdbcTemplate acctJdbcTemplate(@Qualifier("acctDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
