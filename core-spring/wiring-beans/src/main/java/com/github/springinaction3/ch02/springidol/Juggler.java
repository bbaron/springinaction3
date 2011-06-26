package com.github.springinaction3.ch02.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Juggler implements Performer {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final int beanBags;
    
    public Juggler() {
        this(3);
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformanceException {
        logger.info("JUGGLING " + beanBags + " BEANBAGS");
    }

}
