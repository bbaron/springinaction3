package com.github.springinaction3.ch02.springidol;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeScopeTest {

    @Test
    public void tedAndAliceHaveDistincTickets() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml", "patrons.xml");
        Patron ted = context.getBean("ted", Patron.class);
        Patron alice = context.getBean("alice", Patron.class);
        assertNotSame(ted.getTicket(), alice.getTicket());
    }
}
