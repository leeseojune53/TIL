package io.github.leeseojune53.saveallvsbatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Repository
public class UserDao {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDao(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    public void saveAll() {
        for (int i = 0; i < 10000; i++) {
            userJpaRepository.save(new UserEntity(UUID.randomUUID().toString(), "name" + i));
        }
    }

    public void batchSave() {
            jdbcTemplate.batchUpdate("insert into user(uuid, name) values (?, ?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, UUID.randomUUID().toString());
                    ps.setString(2, "name" + i);
                }

                @Override
                public int getBatchSize() {
                    return 10000;
                }
            });
    }

}
