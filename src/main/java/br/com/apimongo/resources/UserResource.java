package br.com.apimongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apimongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User carol = new User("1", "Caroline Felix", "caroline@gmail.com");
		User henrique = new User("2", "Henrique Felix", "henrique@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(carol,henrique));
		return ResponseEntity.ok().body(list);
	}

}
