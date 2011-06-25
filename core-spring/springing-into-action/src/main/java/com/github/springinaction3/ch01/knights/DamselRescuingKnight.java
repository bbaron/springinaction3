package com.github.springinaction3.ch01.knights;

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        quest = new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
