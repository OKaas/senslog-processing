package cz.senslog.db.repository;

import cz.senslog.processing.ApplicationContext;
import cz.senslog.processing.rest.controller.EventController;
import cz.senslog.processing.security.UserToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by OK on 11/19/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationContext.class)
public class EventControllerTest {

    @Autowired
    EventController eventControllerTest;

    UserToken userTokenValid;
    UserToken usetTokenInvalid;


    @Before
    public void setUp(){
        userTokenValid = new UserToken();
        userTokenValid.setAuthorities(Arrays.asList());
    }

    @After
    public void tearDown(){

    }

    /* --- Method test --- */
    @Test
    public void putOne() {
    }

    @Test
    public void putList(){

    }

    @Test
    public void putInvalidToken(){

    }

    @Test
    public void putListInvalidToken(){

    }
}


