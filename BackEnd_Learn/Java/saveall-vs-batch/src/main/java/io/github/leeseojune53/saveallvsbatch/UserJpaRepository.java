package io.github.leeseojune53.saveallvsbatch;

import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, String> {
}
