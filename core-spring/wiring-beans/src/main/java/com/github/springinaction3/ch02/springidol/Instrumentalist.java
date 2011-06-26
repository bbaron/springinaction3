package com.github.springinaction3.ch02.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Instrumentalist implements Performer {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private Instrument instrument;
    private String song;

    @Override
    public void perform() throws PerformanceException {
        logger.info("Playing " + song + " : ");
        instrument.play();
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setSong(String song) {
        this.song = song;
    }

}
