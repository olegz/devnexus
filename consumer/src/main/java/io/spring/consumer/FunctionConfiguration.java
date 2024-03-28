package io.spring.consumer;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionConfiguration {

    @Bean
    public Consumer<Person> logIt() {
        return s -> System.out.println(s);
    }
}
