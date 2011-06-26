package com.github.springinaction3.ch02.springidol;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {

    @Test
    public void tedAndAliceHaveDistincTickets() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("life-cycle.xml");
        Map<String, Auditorium> beans = context.getBeansOfType(Auditorium.class);
        for (Entry<String, Auditorium> entry : beans.entrySet()) {
            assertTrue(entry.getKey(), entry.getValue().areOn());
        }
        context.close();
        for (Entry<String, Auditorium> entry : beans.entrySet()) {
            assertFalse(entry.getKey(), entry.getValue().areOn());
        }
    }
}
