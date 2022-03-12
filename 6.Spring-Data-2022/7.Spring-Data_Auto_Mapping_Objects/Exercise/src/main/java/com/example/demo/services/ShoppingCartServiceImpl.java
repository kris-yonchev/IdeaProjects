package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.User;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final GameRepository gameRepository;
    private final UserService userService;


    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, GameRepository gameRepository, UserService userService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.gameRepository = gameRepository;
        this.userService = userService;
    }


    @Override
    public String AddItem(String gameTitle) {
        Game game = gameRepository.findByTitle(gameTitle);
        if (game == null) {
            return "Game not found.";
        }

        if (getUser().getGames().contains(game)) {
            return "You already own this game.";
        }
        getUser().getShoppingCart().addGame(game);
        shoppingCartRepository.save(getUser().getShoppingCart());

        return gameTitle + " added to Cart.";
    }

    @Override
    public String removeItem(String gameTitle) {
        Game game = gameRepository.findByTitle(gameTitle);
        if (game == null) {
            return "Game not found.";
        }
        boolean isItInCart = getUser().getShoppingCart().getGames().contains(game);
        if (!isItInCart) {
            return "Game is not currently in shopping cart.";
        }

        getUser().getShoppingCart().getGames().remove(game);
        shoppingCartRepository.save(getUser().getShoppingCart());


        return gameTitle + " removed from cart.";
    }

    @Override
    public String BuyItem() {
        Set<Game> cartGames = getUser().getShoppingCart().getGames();
        StringBuilder sb = new StringBuilder();
        sb.append("Games bought successfully:").append(System.lineSeparator());
        for (Game game : cartGames) {
            getUser().getGames().add(game);
            sb.append(" -").append(game.getTitle()).append(System.lineSeparator());
        }
        getUser().getShoppingCart().getGames().clear();

        return sb.toString();

    }

    public User getUser() {
        return this.userService.getLoggedUser();
    }

}
