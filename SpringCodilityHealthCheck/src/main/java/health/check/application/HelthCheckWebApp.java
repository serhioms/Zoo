package health.check.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages= {""}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value=Configuration.class)})
@ComponentScan({"health.check"})
public class HelthCheckWebApp implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HelthCheckWebApp.class, args);
    }

}