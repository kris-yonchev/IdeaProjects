package core;

import models.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieDatabaseImpl implements MovieDatabase {

    private Map<String, Movie> moviesById;
    private Map<String, Map<String, Movie>> moviesByActor;
    private Map<Movie, List<String>> moviesWithActors;

    public MovieDatabaseImpl() {
        this.moviesById = new LinkedHashMap<>();
        this.moviesByActor = new LinkedHashMap<>();
        this.moviesWithActors = new LinkedHashMap<>();
    }

    @Override
    public void addMovie(Movie movie) {

        this.moviesById.putIfAbsent(movie.getId(), movie);
        List<String> actors = movie.getActors();
        for (String actor : actors) {
            this.moviesByActor.putIfAbsent(actor, new LinkedHashMap<>());
            this.moviesByActor.get(actor).putIfAbsent(movie.getId(), movie);
        }
        this.moviesWithActors.putIfAbsent(movie, actors);
    }

    @Override
    public void removeMovie(String movieId) {
        Movie movie = moviesById.remove(movieId);
        if (movie == null) {
            throw new IllegalArgumentException();
        }
        moviesWithActors.remove(movie);
        List<String> actors = movie.getActors();
        for (String actor : actors) {
            moviesByActor.get(actor).remove(movieId);
        }
    }

    @Override
    public int size() {
        return this.moviesById.size();
    }

    @Override
    public boolean contains(Movie movie) {
        return this.moviesById.containsKey(movie.getId());
    }

    @Override
    public Iterable<Movie> getMoviesByActor(String actorName) {
        if (!moviesByActor.containsKey(actorName)) {
            throw new IllegalArgumentException();
        }
        return this.moviesByActor.get(actorName)
                .values()
                .stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).thenComparingInt(Movie::getReleaseYear).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesByActors(List<String> actors) {
        List<Movie> movies = this.moviesById.values().stream().filter(movie -> movie.getActors().containsAll(actors)).sorted((first, second) -> {
            int result = Double.compare(second.getRating(), first.getRating());


            if (result == 0) {
                result = Integer.compare(second.getReleaseYear(), first.getReleaseYear());
            }

            return result;
        })
                .collect(Collectors.toList());
        if (movies.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return movies;
    }

    @Override
    public Iterable<Movie> getMoviesByYear(Integer releaseYear) {
        return moviesById.values().stream().filter(m -> m.getReleaseYear() == releaseYear)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()).collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesInRatingRange(double lowerBound, double upperBound) {
        return moviesById.values().stream()
                .filter(m -> m.getRating() >= lowerBound && m.getRating() <= upperBound)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()).collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getAllMoviesOrderedByActorPopularityThenByRatingThenByYear() {
        Map<String, Integer> countForRoles = new HashMap<>();
        moviesByActor.forEach((actor, value) -> {
            countForRoles.putIfAbsent(actor, 0);
            int count = value.size() + countForRoles.get(actor);
            countForRoles.put(actor, count);
        });

        return moviesById.values().stream().sorted((m1, m2) -> {
            int m2Count = 0;
            for (String actor : m2.getActors()) {
                m2Count += countForRoles.get(actor);
            }
            int m1Count = 0;
            for (String actor : m1.getActors()) {
                m1Count += countForRoles.get(actor);
            }
            int compare = Integer.compare(m2Count, m1Count);

            if (compare == 0) {
                compare = Double.compare(m2.getRating(), m1.getRating());
            }

            if (compare == 0) {
                compare = Integer.compare(m2.getReleaseYear(), m1.getReleaseYear());
            }
            return compare;
        }).collect(Collectors.toList());

    }
}
