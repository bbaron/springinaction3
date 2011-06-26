package com.github.springinaction3.ch02.springidol;

public class Patron {

    private final Ticket ticket;

    private Patron(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
    
    
}
