package com.imc.rockpapaerscissors.playeractions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class PlayerActionsTest
{

    /**
     * Test Rock
     */
    @Test
    public void testPlayerActionRock() {
        IPlayerAction rock = PlayerActionFactory.getRock();
        IPlayerAction paper = PlayerActionFactory.getPaper();
        IPlayerAction scissors = PlayerActionFactory.getScissors();

        assertEquals("Rock", rock.getName());
        assertEquals("R", rock.getActionCharacter());
        assertEquals("blunts", rock.getWinningVerb());
        assertTrue(rock.beats(scissors));
        assertFalse(rock.beats(paper));
        assertFalse(rock.beats(rock));
    }

    /**
     * Test Paper
     */
    @Test
    public void testPlayerActionPaper() {
        IPlayerAction rock = PlayerActionFactory.getRock();
        IPlayerAction paper = PlayerActionFactory.getPaper();
        IPlayerAction scissors = PlayerActionFactory.getScissors();

        assertEquals("Paper", paper.getName());
        assertEquals("P", paper.getActionCharacter());
        assertEquals("wraps", paper.getWinningVerb());
        assertTrue(paper.beats(rock));
        assertFalse(paper.beats(paper));
        assertFalse(paper.beats(scissors));
    }

    /**
     * Test Scissors
     */
    @Test
    public void testPlayerActionScissors() {
        IPlayerAction rock = PlayerActionFactory.getRock();
        IPlayerAction paper = PlayerActionFactory.getPaper();
        IPlayerAction scissors = PlayerActionFactory.getScissors();

        assertEquals("Scissors", scissors.getName());
        assertEquals("S", scissors.getActionCharacter());
        assertEquals("cuts", scissors.getWinningVerb());
        assertTrue(scissors.beats(paper));
        assertFalse(scissors.beats(scissors));
        assertFalse(scissors.beats(rock));
    }

    /**
     * Test Scissors
     */
    @Test
    public void testPlayerActionFactory() {

        IPlayerAction rock = PlayerActionFactory.getRock();
        IPlayerAction paper = PlayerActionFactory.getPaper();
        IPlayerAction scissors = PlayerActionFactory.getScissors();

        assertEquals(rock, PlayerActionFactory.getIPlayerAction("R"));
        assertEquals(rock, PlayerActionFactory.getIPlayerAction("r"));
        assertEquals(paper, PlayerActionFactory.getIPlayerAction("P"));
        assertEquals(paper, PlayerActionFactory.getIPlayerAction("p"));
        assertEquals(scissors, PlayerActionFactory.getIPlayerAction("S"));
        assertEquals(scissors, PlayerActionFactory.getIPlayerAction("s"));
        assertNull(PlayerActionFactory.getIPlayerAction("x"));

    }
}
