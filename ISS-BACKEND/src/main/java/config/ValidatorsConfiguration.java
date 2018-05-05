package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import validators.PersonValidator;

@Configuration
@EnableSpringDataWebSupport
public class ValidatorsConfiguration {
    @Bean
    public PersonValidator beforeCreatePersonValidator(){
        return new PersonValidator();
    }
}
