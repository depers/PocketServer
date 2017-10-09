package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 冯晓 on 2017/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1(){
        /*logger.info("info....");
        logger.debug("debug....");
        logger.error("error....");*/

        String name = "fulin";
        String password = "121212";
        log.info("info....");
        log.debug("debug....");
        log.error("error....");

        log.info("name: {}, password: {}", name, password);
    }
}
