package com.cegeka.nocturne.godgame;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class CreatorTest {

    private Creator creator = new Creator();

    @Test
    public void testPause() {
        creator.pause();
        Assertions.assertThat(creator.isPaused()).isTrue();
    }

    @Test
    public void testResume() {
        creator.resume();
        Assertions.assertThat(creator.isPaused()).isFalse();
    }

}
