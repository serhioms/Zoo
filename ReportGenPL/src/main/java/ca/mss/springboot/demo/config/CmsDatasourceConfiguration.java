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
@ConfigurationProperties("spring.datasource-cms")
public class CmsDatasourceConfiguration extends HikariConfig {

    @Bean
    public HikariDataSource cmsDataSource() {
        return new HikariDataSource(this);
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource-cms")
//    public DataSourceProperties cmsDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource cmsDataSource() {
//        return cmsDataSourceProperties()
//                .initializeDataSourceBuilder()
//                .build();
//    }

    @Bean
    public JdbcTemplate cmsJdbcTemplate(@Qualifier("cmsDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
