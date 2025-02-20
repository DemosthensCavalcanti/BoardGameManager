package br.ufpb.dcx.demosthens.farias.boardgame;

import java.io.IOException;
import java.util.*;

public class BoardGameManager implements BoardGameCatalog {
    private Map<String, BoardGame> games = new HashMap<>();
    private DataManager dataManager = new DataManager("games.dat");

    @Override
    public boolean addGame(String name, String category, int players) {
        if (!games.containsKey(name)) {
            games.put(name, new BoardGame(name, category, players));
            return true;
        }
        return false;
    }

    @Override
    public Collection<BoardGame> searchByCategory(String category) {
        List<BoardGame> result = new ArrayList<>();
        for (BoardGame game : games.values()) {
            if (game.getCategory().equalsIgnoreCase(category)) {
                result.add(game);
            }
        }
        return result;
    }

    @Override
    public boolean removeGame(String name) throws GameNotFoundException {
        if (games.containsKey(name)) {
            games.remove(name);
            return true;
        }
        throw new GameNotFoundException("Jogo não encontrado: " + name);
    }

    @Override
    public void saveData() throws IOException {
        dataManager.save(games);
    }

    @Override
    public void loadData() throws IOException {
        Map<String, BoardGame> loadedGames = dataManager.load();
        if (loadedGames != null) {
            games = loadedGames;
        }
    }
}-