package com.fs3;


import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppTest {

    @Test
    public void testMain() {
        ApplicationContext context = SpringApplication.run(App.class, new String[]{});
        assertNotNull(context);
    }
}