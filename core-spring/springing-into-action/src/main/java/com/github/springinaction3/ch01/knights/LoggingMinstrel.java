package com.github.springinaction3.ch01.knights;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMinstrel implements Minstrel {

    private Logger logger = LoggerFactory.getLogger("MINSTREL");

    @Override
    public void singBeforeQuest() {
        logger.info("Fa la la; The knight is so brave!");
    }

    @Override
    public void singAfterQuest() {
        logger.info("Tee hee he; The brave knight did embark on a quest!");
    }

}
