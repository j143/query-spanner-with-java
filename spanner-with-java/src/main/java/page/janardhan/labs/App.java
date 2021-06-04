package page.janardhan.labs;

import com.google.cloud.spanner.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/UUID.html
import java.util.UUID;

/**
 * Hello world!
 */
public class App {

    static class Song {
        final String songId;
        final String title;
        final int year;
        final int peak;

        Song(String songId, String title, int year, int peak) {
            this.songId = songId;
            this.title = title;
            this.year = year;
            this.peak = peak;
        }
    }


    /* https://en.wikipedia.org/wiki/List_of_K-pop_songs_on_the_Billboard_charts */
    /* https://docs.google.com/spreadsheets/d/1LibIJIUeZ9Fr2nA31uwk_8j7GvMIKWYVY_1nihYu2Iw/edit?usp=sharing */
    static final List<Song> SONGS =
            Arrays.asList(
                    new Song(getUUID(), "Dynamite", 2020, 1),
                    new Song(getUUID(), "Savage Love ", 2020, 1),
                    new Song(getUUID(), "Ice Cream", 2020, 8),
                    new Song(getUUID(), "How You Like That", 2020, 24),
                    new Song(getUUID(), "Baby Shark", 2020, 38),
                    new Song(getUUID(), "Not Shy", 2020, 124),
                    new Song(getUUID(), "Boy with Luv", 2020, 151),
                    new Song(getUUID(), "Back Door", 2020, 169),
                    new Song(getUUID(), "I Love You", 2020, 170),
                    new Song(getUUID(), "Lovesick Girls", 2020, 2),
                    new Song(getUUID(), "Bet You Wanna", 2020, 25),
                    new Song(getUUID(), "Pretty Savage", 2020, 32),
                    new Song(getUUID(), "Crazy Over You", 2020, 49),
                    new Song(getUUID(), "Love to Hate Me", 2020, 54),
                    new Song(getUUID(), "You Never Know", 2020, 64),
                    new Song(getUUID(), "Make A Wish ", 2020, 128),
                    new Song(getUUID(), "Ddu", 2020, 158),
                    new Song(getUUID(), "Kill This Love", 2020, 181),
                    new Song(getUUID(), "I Can", 2020, 31),
                    new Song(getUUID(), "More", 2020, 125),
                    new Song(getUUID(), "Black Mamba", 2020, 138),
                    new Song(getUUID(), "Life Goes On", 2020, 1),
                    new Song(getUUID(), "Blue ", 2020, 9),
                    new Song(getUUID(), "Stay", 2020, 16),
                    new Song(getUUID(), "Fly to My Room", 2020, 22),
                    new Song(getUUID(), "Telepathy", 2020, 28),
                    new Song(getUUID(), "Dis", 2020, 30),
                    new Song(getUUID(), "Celebrity", 2021, 78),
                    new Song(getUUID(), "On the Ground", 2021, 1),
                    new Song(getUUID(), "Gone", 2021, 29),
                    new Song(getUUID(), "Film Out", 2021, 5),
                    new Song(getUUID(), "In the Morning", 2021, 34),
                    new Song(getUUID(), "Hot Sauce", 2021, 96),
                    new Song(getUUID(), "Next Level", 2021, 97)
            );

    // https://cloud.google.com/spanner/docs/samples/spanner-update-data
    // https://cloud.google.com/spanner/docs/samples/spanner-insert-data
    static void writeSongData(DatabaseClient dbClient) {
        List<Mutation> mutations = new ArrayList<>();

        for (Song song : SONGS) {
            mutations.add(
                    Mutation.newInsertBuilder("Songs")
                            .set("SongId")
                            .to(song.songId)
                            .set("Title")
                            .to(song.title)
                            .set("Year")
                            .to(song.year)
                            .set("Peak")
                            .to(song.peak)
                            .build());
        }
        dbClient.write(mutations);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // https://cloud.google.com/spanner/docs/samples/spanner-create-client-with-query-options
        SpannerOptions options = SpannerOptions.newBuilder()
                .build();
        Spanner spanner = options.getService();
        String instanceId = "cloudspanner-lab";
        String databaseId = "demo";

        try {
            DatabaseClient dbClient = spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));
            writeSongData(dbClient);
            try (ResultSet resultSet = dbClient
                    .singleUse()
                    .executeQuery(Statement.of("SELECT SongId, Title, Year FROM Songs"))) {
                while (resultSet.next()) {
                    System.out.printf(
                            "%s %s %d\n", resultSet.getString(0), resultSet.getString(1), resultSet.getLong(2));
                }
            }
        } finally {
            spanner.close();
        }

    }


    public static String getUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
