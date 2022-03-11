package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.User;

public interface GameService {

    String addGame(String title, String priceInput, String sizeInput, String trailer,
                   String thumbnailURL, String description, String releaseDate);

    String editGame(int id, String priceToken, String sizeToken);

    String deleteGame(int id);

    String printAllGames();

    String printDetailGame(String title);

    Game findByTitle(String title);

    String printOwnedGames(User loggedUser);
}
