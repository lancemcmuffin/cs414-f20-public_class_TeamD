package cs414f20.teamd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cs414f20.teamd.OngoingMatches.OngoingMatches;

class OngoingMatchesTest {
    @Test
    void testMatches() {
        OngoingMatches test = new OngoingMatches("Nick");
        assertEquals("Nick", test.getUserID());
        assertEquals(null, test.getMatches());
    }
}