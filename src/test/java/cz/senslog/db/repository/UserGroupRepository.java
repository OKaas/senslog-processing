package cz.senslog.db.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by OK on 11/19/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGroupRepository {

    @Autowired
    UserGroupRepository userGroupRepository;

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    /* --- Collaborates --- */
    @Test
    public void findAllUserGroupByIdInTest() {

        // userGroupRepository.save();
    }
}


