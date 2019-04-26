package cz.senslog.db.controller.impl;

import cz.senslog.db.controller.ControllerTestConfiguration;
import cz.senslog.processing.db.repository.PositionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by OK on 03-Dec-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerTestConfiguration.class)
public class PositionControllerTest {

    @Autowired
    private PositionRepository positionRepository;

    /* --- Collaborates --- */
    @Before
    public void setUp(){
//        userTokenValid = new UserToken();
//        userTokenValid.setAuthorities(Arrays.asList());
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


