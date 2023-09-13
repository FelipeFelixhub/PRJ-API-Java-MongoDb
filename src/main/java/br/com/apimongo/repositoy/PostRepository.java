package br.com.apimongo.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apimongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
