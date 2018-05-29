package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import validators.*;

@Configuration
@EnableSpringDataWebSupport
public class ValidatorsConfiguration {
    @Bean
    public BloodValidator beforeCreateBloodValidator() {
        return new BloodValidator();
    }


    @Bean
    public DonorValidator beforeCreateDonorValidator() {
        return new DonorValidator();
    }

    @Bean
    public HospitalValidator beforeCreateHospitalValidator() {
        return new HospitalValidator();
    }

    @Bean
    public MedicValidator beforeCreateMedicValidator() {
        return new MedicValidator();
    }

    @Bean
    public RequestValidator beforeCreateRequestValidator() {
        return new RequestValidator();
    }


    @Bean
    public UserValidator beforeCreateUserValidator() {
        return new UserValidator();
    }
}
