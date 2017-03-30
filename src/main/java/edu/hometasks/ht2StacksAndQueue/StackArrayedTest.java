package edu.hometasks.ht2StacksAndQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maksym Pavlov on 3/17/17.
 */
public class StackArrayedTest {
    @org.junit.Test
    public void check() throws Exception {
        StackArrayed s = new StackArrayed(3);

        s.push("some0");
        s.push("some1");
        s.push("some2");

        assertEquals(s.poll(), "some2");
        assertEquals(s.poll(), "some1");
        assertEquals(s.poll(), "some0");
    }

    @org.junit.Test
    public void checkInnerArrayExtention() throws Exception {
        StackArrayed s = new StackArrayed(2);

        s.push("some0");
        s.push("some1");
        s.push("some2");

        assertEquals(s.poll(), "some2");
        assertEquals(s.poll(), "some1");
        assertEquals(s.poll(), "some0");
    }


    @Test
    public void checkNull() {
        StackArrayed s = new StackArrayed(2);
        assertNull(s.poll());
    }

    @Test
    public void checkPollOptimization() {
        StackArrayed s = new StackArrayed(2);
        s.push("1");
        s.push("1");
        s.push("1");

        s.poll();
        s.poll();

        assertEquals(s.getInnerSize(), 2);
    }

    @Test
    public void pushAfterPoll() {
        StackArrayed s = new StackArrayed(2);
        s.push("1");
        s.push("2");
        s.push("3");
        s.poll();
        s.push("4");

        assertEquals(s.poll(), "4");
    }
}