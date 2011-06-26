package com.github.springinaction3.ch01.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BraveKnightTest {
    
    @Mock
    Quest mockQuest;

    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
