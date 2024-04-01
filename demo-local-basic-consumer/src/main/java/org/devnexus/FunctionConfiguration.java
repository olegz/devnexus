package org.devnexus;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionConfiguration {

    @Bean
    public Consumer<String> logIt() {
        return s -> System.out.println(s);
    }
}
