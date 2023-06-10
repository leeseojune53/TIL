package io.github.leeseojune53.saveallvsbatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaveallVsBatchApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void saveAll() {
        userDao.saveAll();
    }

    @Test
    void batchSave() {
        userDao.batchSave();
    }

}
