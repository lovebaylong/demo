package demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Zoo {
    @Bean
    public Tiger tiger() {
        return new Tiger();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
