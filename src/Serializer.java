import java.util.Scanner;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by landonkail on 10/14/15.
 */
public class Serializer {
    static Movie movie;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        movie = loadMovie();

        if (movie == null) {
            movie = new Movie();

            // FAVORITE MOVIE
            System.out.println("What is your favorite movie?");
            String choice1 = scanner.nextLine();
            movie.favoriteMovie = choice1;

            // ACTOR
            System.out.println("Who was the main actor?");
            String choice2 = scanner.nextLine();
            movie.actor = choice2;

            // GENRE
            System.out.println("What was this movie's genre?");
            String choice3 = scanner.nextLine();
            movie.genre = choice3;

            // STAR-RATING
            int choice4 = 0;
            while (choice4 < 1 || choice4 > 5) {
                System.out.println("How many stars would you give this movie?  1-5 Stars.....");
                choice4 = Integer.valueOf(scanner.nextLine());
            }
            movie.starRating = choice4;


            // RECOMMENDED
            String choice5 = "";
            while (!choice5.equals("Y") && !choice5.equals("N")) {
                System.out.println("Would you recommend this movie to a friend??? Y or N");
                choice5 = scanner.nextLine();
            }
            movie.recommend = choice5.equals("Y");

            saveMovie();
        } else {
            System.out.println(String.format("name: %s, actor: %s, genre: %s, stars: %d, recommended: %s", movie.favoriteMovie, movie.actor, movie.genre, movie.starRating, movie.recommend));
        }
    }

    static void saveMovie() {
        File f = new File("save.json");
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(movie);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception e) {

        }
    }

    static Movie loadMovie() {
        try {
            File f = new File("save.json");
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            // Parsing
            JsonParser parser = new JsonParser();
            return parser.parse(fileContents, Movie.class);
        } catch (Exception e) {
            return null;
        }

    }
}
