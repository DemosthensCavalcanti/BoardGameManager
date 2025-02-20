package br.ufpb.dcx.demosthens.farias.boardgame;

import java.io.Serializable;
import java.util.Objects;

public class BoardGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String category;
    private int numberOfPlayers;

    public BoardGame(String name, String category, int numberOfPlayers) {
        this.name = name;
        this.category = category;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BoardGame boardGame = (BoardGame) obj;
        return Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                '}';
    }
}