package labs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the music app
 */
public class MusicAppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MusicAppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MusicAppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    // public void testApp()
    // {
    //     assertTrue( true );
    // }
}
