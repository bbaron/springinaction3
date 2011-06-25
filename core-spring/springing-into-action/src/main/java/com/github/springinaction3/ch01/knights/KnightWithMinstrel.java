package com.github.springinaction3.ch01.knights;

public class KnightWithMinstrel implements Knight {
    private final Quest quest;
    private final Minstrel minstrel;

    public KnightWithMinstrel(Quest quest, Minstrel minstrel) {
        this.quest = quest;
        this.minstrel = minstrel;
    }

    @Override
    public void embarkOnQuest() throws QuestException {
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }

}
