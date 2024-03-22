package io.spring.producer;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionConfiguration {

    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private ProducerProperties producerProperties;

  @Bean
  public Function<Person, Person> toUpper() {
        return new Function<Person, Person>() {
            @Override
            public Person apply(Person s) {
                s.setFirstName(s.getFirstName().toUpperCase());
                s.setLastName(s.getLastName().toUpperCase());
                streamBridge.send(producerProperties.getBindingName(), s);
                return s;
            }
        };
    }
}
