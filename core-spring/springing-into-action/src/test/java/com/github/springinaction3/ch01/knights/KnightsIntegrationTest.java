package com.github.springinaction3.ch01.knights;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

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
        Logger minstrelLogger = (Logger) LoggerFactory.getLogger("MINSTREL");

        ListAppender<ILoggingEvent> minstrelAppender = new ListAppender<ILoggingEvent>();
        minstrelAppender.start();
        minstrelLogger.addAppender(minstrelAppender);
        ApplicationContext context = new ClassPathXmlApplicationContext("knights-with-minstrel.xml");
        Knight knight = context.getBean(Knight.class);
        assertNotNull(knight);
        knight.embarkOnQuest();
        assertEquals(2, minstrelAppender.list.size());
    }

    @Test
    public void loggerTest() throws Exception {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

        ListAppender<ILoggingEvent> listAppender = new ListAppender<ILoggingEvent>();
        listAppender.start();
        root.addAppender(listAppender);
        Logger logger = (Logger) LoggerFactory.getLogger("LOGGER_TEST");
        assertEquals(0, listAppender.list.size());
        logger.info("hello");
        assertEquals(1, listAppender.list.size());
        ILoggingEvent event = listAppender.list.get(0);
        event.getMessage();
    }
}
