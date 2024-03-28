package io.spring.producer;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PersonTests {

	@Test
	void personTest() {
		Person person = new Person("Jane", "Doe");
		assertThat(person.getFirstName()).isEqualTo("Jane");
		assertThat(person.getLastName()).isEqualTo("Doe");
	}

}
