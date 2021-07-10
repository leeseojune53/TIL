package io.github.leeseojune53.postservice.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllByUserId(Integer userId);
}
