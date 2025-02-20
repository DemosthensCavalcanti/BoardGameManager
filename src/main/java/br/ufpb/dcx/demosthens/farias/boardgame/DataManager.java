package br.ufpb.dcx.demosthens.farias.boardgame;

import java.io.*;
import java.util.Map;

public class DataManager {
    private String filePath;

    public DataManager(String filePath) {
        this.filePath = filePath;
    }

    public void save(Map<String, BoardGame> games) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(games);
        }
    }

    public Map<String, BoardGame> load() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Map<String, BoardGame>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao carregar os dados.", e);
        }
    }
}