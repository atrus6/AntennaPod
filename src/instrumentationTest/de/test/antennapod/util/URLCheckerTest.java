package instrumentationTest.de.test.antennapod.util;

import android.test.AndroidTestCase;
import de.danoeh.antennapod.util.URLChecker;

/**
 * Test class for URLChecker
 */
public class URLCheckerTest extends AndroidTestCase {

    public void testCorrectURLHttp() {
        final String in = "http://example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals(in, out);
    }

    public void testCorrectURLHttps() {
        final String in = "https://example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals(in, out);
    }

    public void testMissingProtocol() {
        final String in = "example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }

    public void testFeedProtocol() {
        final String in = "feed://example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }

    public void testPcastProtocol() {
        final String in = "pcast://example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }

    public void testItpcProtocol() {
        final String in = "itpc://example.com";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }

    public void testWhiteSpaceUrlShouldNotAppend() {
        final String in = "\n http://example.com \t";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }

    public void testWhiteSpaceShouldAppend() {
        final String in = "\n example.com \t";
        final String out = URLChecker.prepareURL(in);
        assertEquals("http://example.com", out);
    }
}
