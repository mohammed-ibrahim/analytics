package org.tools.csv.utils;

import lombok.Getter;

public class Timeunit {
    private static final int NUM_MILI_SEC_IN_A_SEC = 1000;

    private static final int NUM_SEC_IN_A_MIN = 60;

    private static final int NUM_MILI_SEC_IN_A_MIN = 60000;

    @Getter
    private long duration;

    public Timeunit(long durationMs) {
        this.duration = durationMs;
    }

    @Override
    public String toString() {
        long miliseconds = this.duration % NUM_MILI_SEC_IN_A_SEC;
        long seconds = (this.duration / NUM_MILI_SEC_IN_A_SEC) % (NUM_SEC_IN_A_MIN);
        long minutes = this.duration / (NUM_MILI_SEC_IN_A_MIN);

        return String.format("%02d:%02d:%03d", minutes, seconds, miliseconds);
    }
}
