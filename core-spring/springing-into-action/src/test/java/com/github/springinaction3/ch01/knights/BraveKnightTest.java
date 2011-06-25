package com.github.springinaction3.ch01.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;


public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
