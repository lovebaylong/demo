package demo;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator() {
        /*设置validator模式为快速失败返回*/
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                //.failFast(true)
                //.addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory().getValidator();
    }
}