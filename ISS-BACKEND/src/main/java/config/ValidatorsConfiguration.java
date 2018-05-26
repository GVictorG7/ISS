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
    public DiseaseValidator beforeCreateDiseaseValidator() {
        return new DiseaseValidator();
    }

    @Bean
    public DonationValidator beforeCreateDonationValidator() {
        return new DonationValidator();
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
    public PersonValidator beforeCreatePersonValidator() {
        return new PersonValidator();
    }

    @Bean
    public RequestValidator beforeCreateRequestValidator() {
        return new RequestValidator();
    }

    @Bean
    public TreatmentValidator beforeCreateTreatmentValidator() {
        return new TreatmentValidator();
    }

    @Bean
    public UserValidator beforeCreateUserValidator() {
        return new UserValidator();
    }
}
