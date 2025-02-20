import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameManagerTest {
    private BoardGameManager manager;

    @BeforeEach
    void setUp() {
        manager = new BoardGameManager();
    }

    @Test
    void testAddGame() {
        assertTrue(manager.addGame("Catan", "Strategy", 4), "O jogo deveria ser adicionado com sucesso.");
        assertFalse(manager.addGame("Catan", "Strategy", 4), "O jogo já existe e não deveria ser adicionado novamente.");
    }

    @Test
    void testSearchByCategory() {
        manager.addGame("Catan", "Strategy", 4);
        manager.addGame("Risk", "Strategy", 6);
        Collection<BoardGame> result = manager.searchByCategory("Strategy");
        assertEquals(2, result.size(), "A busca por jogos de estratégia deveria retornar 2 jogos.");
    }

    @Test
    void testRemoveGame() {
        manager.addGame("Catan", "Strategy", 4);
        assertDoesNotThrow(() -> assertTrue(manager.removeGame("Catan"), "O jogo deveria ser removido com sucesso."));

        GameNotFoundException exception = assertThrows(GameNotFoundException.class,
                () -> manager.removeGame("Catan"),
                "A remoção de um jogo inexistente deveria lançar uma exceção."
        );
        assertEquals("Jogo não encontrado: Catan", exception.getMessage(), "A mensagem da exceção não está correta.");
    }

    @Test
    void testSaveAndLoadData() throws IOException {
        manager.addGame("Catan", "Strategy", 4);
        manager.saveData();
        manager.loadData();
        assertEquals(1, manager.searchByCategory("Strategy").size(), "Os dados salvos e carregados não correspondem ao esperado.");
    }
}