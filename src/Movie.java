/**
 * Created by landonkail on 10/14/15.
 */
public class Movie {
    public String favoriteMovie;
    public String actor;
    public String genre;
    public int starRating;
    public boolean recommend;

    /*public Movie(String favoriteMovie, String actor, String genre, int starRating, boolean recommend) {
        this.favoriteMovie = favoriteMovie;
        this.actor = actor;
        this.genre = genre;
        this.starRating = starRating;
        this.recommend = recommend;
    }*/


    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public String getActor() {
        return actor;
    }

    public String getGenre() {
        return genre;
    }

    public int getStarRating() {
        return starRating;
    }

    public boolean getRecommend() {
        return recommend;
    }
}

