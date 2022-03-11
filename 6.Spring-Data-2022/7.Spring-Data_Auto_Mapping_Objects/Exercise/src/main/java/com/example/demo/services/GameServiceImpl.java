package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.User;
import com.example.demo.entities.dto.GameDetailsDTO;
import com.example.demo.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.dto.GamePriceAndTitleDTO;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public String addGame(String title, String priceInput, String sizeInput, String trailer, String thumbnailURL, String description, String releaseDate) {

        if (Character.isLowerCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) {
            return "Invalid title";
        }

        BigDecimal price = new BigDecimal(priceInput);
        if (price.compareTo(new BigDecimal(0)) <= 0) {
            return "Price cannot be negative!";
        }

        BigDecimal size = new BigDecimal(sizeInput);
        if (size.compareTo(new BigDecimal(0)) <= 0) {
            return "Size cannot be negative!";
        }

        String trailerCheck = trailer.substring(33);
        if (trailerCheck.length() != 11) {
            return "Invalid youtube link!";
        }

        if (!thumbnailURL.startsWith("http://") || !thumbnailURL.startsWith("https://")) {
            return "Invalid thumbnailURl";
        }

        if (description.length() < 20) {
            return "Invalid description";
        }

        String[] dateInfo = releaseDate.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(dateInfo[2]),
                Integer.parseInt(dateInfo[1]),
                Integer.parseInt(dateInfo[0]));

        Game game = new Game(title, trailer, thumbnailURL, size, price, description, date);
        gameRepository.save(game);

        return "Added " + title;
    }

    @Override
    public String editGame(int id, String priceToken, String sizeToken) {
        Game game = gameRepository.findById(id).orElse(null);
        if (game == null) {
            return "Invalid id!";
        }

        BigDecimal price = new BigDecimal(priceToken.split("=")[1]);
        BigDecimal size = new BigDecimal(sizeToken.split("=")[1]);

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);

        return "Edited " + game.getTitle();
    }

    @Override
    public String deleteGame(int id) {
        Game game = gameRepository.findById(id).orElse(null);

        if (game == null) {
            return "Invalid Id!";
        }

        gameRepository.delete(game);

        return "Deleted " + game.getTitle();
    }

    @Override
    public String printAllGames() {
        StringBuilder sb = new StringBuilder();
        List<Game> all = gameRepository.findAll();

        ModelMapper mapper = new ModelMapper();

        List<GamePriceAndTitleDTO> dtos =
                all.stream().map(game -> mapper.map(game, GamePriceAndTitleDTO.class)).collect(Collectors.toList());

        for (GamePriceAndTitleDTO dto : dtos) {
            sb.append(dto).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String printDetailGame(String title) {
        Game gameByTitle = gameRepository.findByTitle(title);
        ModelMapper mapper = new ModelMapper();
        TypeMap<Game, GameDetailsDTO> gameToDTO = mapper.typeMap(Game.class, GameDetailsDTO.class);
        GameDetailsDTO game = gameToDTO.map(gameByTitle);
        return game.toString();
    }

    @Override
    public Game findByTitle(String title) {
        return gameRepository.findByTitle(title);
    }

    @Override
    public String printOwnedGames(User loggedUser) {
        if (loggedUser == null) {
            return "No logged user!";
        }
        StringBuilder sb = new StringBuilder();
        for (Game game : loggedUser.getGames()) {
            sb.append(game.getTitle()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
