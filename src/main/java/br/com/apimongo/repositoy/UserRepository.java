package br.com.apimongo.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apimongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
