package org.sathya;

import net.bytebuddy.asm.Advice;
import org.sathya.user.api.UserRepository;
import org.sathya.user.bom.User;
import org.sathya.user.messaging.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<User> users = Arrays.asList(
				new User("Sathya", "a", "sathya.a@gmail.com"),
				new User("Raja", "a", "raja.a@gmail.com"),
				new User("Ragav", "a", "ragav.a@gmail.com")
		);
		userRepository.deleteAll();
		userRepository.saveAll(users);
	}
}
