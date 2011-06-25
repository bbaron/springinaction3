package com.github.springinaction3.ch01.knights;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightsIntegrationTest {

    @Test
    public void embarkOnQuest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = context.getBean(Knight.class);
        assertNotNull(knight);
        knight.embarkOnQuest();
    }

    @Test
    public void embarkOnQuestWithMinstrel() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("knights-with-minstrel.xml");
        Knight knight = context.getBean(Knight.class);
        assertNotNull(knight);
        knight.embarkOnQuest();
    }
}
