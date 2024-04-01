package org.devnexus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DayOneApplicationTest {

	@Autowired
	Function<String, String> uppercase;
	
	@Test
	void testApplication() {
		assertThat(uppercase.apply("hello")).isEqualTo("HELLO");
	}

}

