package io.spring.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
@Import(TestChannelBinderConfiguration.class)
class ConsumerApplicationTests {

	@Autowired
	private InputDestination inputDestination;
	@Test
	void contextLoads(CapturedOutput output) {
		Message<String> message = new GenericMessage<>("{\"firstName\":\"JANE\",\"lastName\":\"SMITH\"}");
		inputDestination.send(message, "pTest");
		assertThat(output.getOut()).contains("Person{firstName='JANE', lastName='SMITH'}");
	}

}
