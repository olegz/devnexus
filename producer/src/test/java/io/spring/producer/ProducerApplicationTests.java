package io.spring.producer;

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
class ProducerApplicationTests {

	@Autowired
	private Function<Person, Person> producer;

	@Autowired
	private OutputDestination outputDestination;

	@Test
	void contextLoads() {
		Person test = new Person();
		test.setFirstName("Jane");
		test.setLastName("Smith");
		producer.apply(test);

		Message<byte[]> messageReceived = outputDestination.receive(1000, "pTest");
		assertThat(new String(messageReceived.getPayload())).isEqualTo("{\"firstName\":\"JANE\",\"lastName\":\"SMITH\"}");
	}

}
