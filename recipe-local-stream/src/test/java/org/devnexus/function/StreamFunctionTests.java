package org.devnexus.function;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.test.annotation.DirtiesContext;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@DirtiesContext
@Import(TestChannelBinderConfiguration.class)
class StreamFunctionTests {

    @Autowired
    private Function<String, String> producer;

    @Autowired
    private OutputDestination outputDestination;
    
    @Test
    void validateFunctionWithStreamOutput() {
        producer.apply("hello-test");

        Message<byte[]> messageReceived = outputDestination.receive(1000, "test-topic");
        assertThat(new String(messageReceived.getPayload())).isEqualTo("HELLO-TEST");
    }

}
