/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lex
 */
public class StatisticsTest {

    private Statistics stats;
    private Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        String name = "Semenko";
        Player expResult = new Player("Semenko", "EDM", 4, 12);
        Player result = stats.search(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        String teamName = "DET";
        List<Player> expResult = new ArrayList<Player>();
        expResult.add(new Player("Yzerman", "DET", 42, 56));
        List<Player> result = stats.team(teamName);
        assertEquals(expResult, result);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        int howMany = 1;
        List<Player> expResult = new ArrayList<Player>();
        expResult.add(new Player("Gretzky", "EDM", 35, 89));
        expResult.add(new Player("Lemieux", "PIT", 45, 54));
        List<Player> result = stats.topScorers(howMany);
        assertEquals(expResult, result);
    }

}
