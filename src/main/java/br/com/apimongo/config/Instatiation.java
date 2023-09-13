package br.com.apimongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.apimongo.domain.Post;
import br.com.apimongo.domain.User;
import br.com.apimongo.dto.AuthorDTO;
import br.com.apimongo.repositoy.PostRepository;
import br.com.apimongo.repositoy.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User felipe = new User(null, "Felipe Felix", "felipe@gmail.com");
		User carol = new User(null, "Caroline Felix", "carol@gmail.com");
		User henrique = new User(null, "Henrique Felix", "henrique@gmail.com");
		
		userRepository.saveAll(Arrays.asList(felipe,carol,henrique));
		
		Post post1 = new Post(null, sdf.parse("13/09/2023"), "Partiu viagem", "Vou viajar para Londres. Abraços!", new AuthorDTO(felipe));
		Post post2 = new Post(null, sdf.parse("12/09/2023"), "Felicidade", "Coisas boas aconteceram", new AuthorDTO(carol));
		Post post3 = new Post(null, sdf.parse("10/09/2023"), "Vaiii Corinthians", "Bi Campeão Mundial", new AuthorDTO(henrique));
		Post post4 = new Post(null, sdf.parse("12/09/2023"), "Vaiii Corinthians", "Vamos, Vamos Corinthians, esse jogo, teremos que ganhar!", new AuthorDTO(henrique));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2, post3, post4));
		
		felipe.getPosts().addAll(Arrays.asList(post1));
		carol.getPosts().addAll(Arrays.asList(post2));
		henrique.getPosts().addAll(Arrays.asList(post3, post4));
				
		userRepository.saveAll(Arrays.asList(felipe,carol,henrique));
		
//		userRepository.save(felipe);
//		userRepository.save(carol);
//		userRepository.save(henrique);
		
	}

}
