package page.janardhan.labs;

/**
 * Hello world!
 *
 */
public class App 
{
    
    static class Song {
        final int songId;
        final String title;
        final int year;
        final int peak;

        Song(int songId, String title, int year, int peak) {
            this.songId = songId;
            this.title = title;
            this.year = year;
            this.peak = peak;
        }
    }

    static class Singer {
        
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
