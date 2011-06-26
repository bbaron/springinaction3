package com.github.springinaction3.ch02.springidol;

public class Stage {
    private Stage() {
    }

    private static enum StageSingletonHolder {
        INSTANCE(new Stage());
        
        private StageSingletonHolder(Stage stage) {
            this.stage = stage;
        }

        Stage stage = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.INSTANCE.stage;
    }

}
