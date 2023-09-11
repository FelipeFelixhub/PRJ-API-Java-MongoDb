package br.com.apimongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.apimongo.domain.User;
import br.com.apimongo.repositoy.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User felipe = new User(null, "Felipe Felix", "felipe@gmail.com");
		User carol = new User(null, "Caroline Felix", "carol@gmail.com");
		User henrique = new User(null, "Henrique Felix", "henrique@gmail.com");
		
		userRepository.saveAll(Arrays.asList(felipe,carol,henrique));
		
	}

}
