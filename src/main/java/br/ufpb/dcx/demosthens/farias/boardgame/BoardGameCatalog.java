package br.ufpb.dcx.demosthens.farias.boardgame;

import java.io.IOException;
import java.util.Collection;

public interface BoardGameCatalog {
    boolean addGame(String name, String category, int players);
    Collection<BoardGame> searchByCategory(String category);
    boolean removeGame(String name) throws GameNotFoundException;
    void saveData() throws IOException;
    void loadData() throws IOException;
}