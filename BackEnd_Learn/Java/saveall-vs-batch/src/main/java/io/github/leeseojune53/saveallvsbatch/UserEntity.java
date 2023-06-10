package io.github.leeseojune53.saveallvsbatch;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "user")
@Entity
public class UserEntity {

    @Id
    private String uuid;

    private String name;

    public UserEntity(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UserEntity() {

    }
}
