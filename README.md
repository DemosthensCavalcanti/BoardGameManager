📖 Board Game Manager 🎲

O Board Game Manager é um sistema simples para gerenciar uma coleção de jogos de tabuleiro. Ele permite cadastrar, pesquisar e remover jogos, além de salvar e carregar os dados automaticamente para persistência.

🚀 Funcionalidades

✅ Cadastrar jogos de tabuleiro<br>
✅ Pesquisar jogos por categoria<br>
✅ Remover jogos do catálogo<br>
✅ Salvar e carregar dados automaticamente<br>

🛠️ Tecnologias Utilizadas<br>
	•	Java 17+<br>
	•	JUnit 5 para testes automatizados<br>
	•	Serialização de Objetos para persistência de dados<br>
	•	Coleções Java (Map) para armazenar os jogos<br>

📂 Estrutura do Projeto

BoardGameManager/<br>
│── src/<br>
│   ├── model/<br>
│   │   ├── BoardGame.java<br>
│   │   ├── GameNotFoundException.java<br>
│   ├── persistence/<br>
│   │   ├── DataManager.java<br>
│   ├── service/<br>
│   │   ├── BoardGameManager.java<br>
│   │   ├── BoardGameManagerTest.java<br>
│── README.md<br>
│── .gitignore<br>
│── pom.xml<br>

📌 Como Executar o Projeto

1️⃣ Clonar o Repositório

git clone https://github.com/DemosthensCavalcanti/BoardGameManager.git <br>
cd BoardGameManager

2️⃣ Compilar o Projeto

Se estiver usando Maven, rode:

mvn compile

Ou compile manualmente com o javac:

javac -d bin src/model/.java src/persistence/.java src/service/*.java

3️⃣ Executar o Programa

java -cp bin service.BoardGameManager

🧪 Rodando os Testes

Para rodar os testes com JUnit:

mvn test

Ou, sem Maven, execute manualmente:

java -cp bin:lib/junit-5.8.1.jar org.junit.runner.JUnitCore service.BoardGameManagerTest

📝 Exemplo de Uso

BoardGameManager manager = new BoardGameManager();
manager.addGame("Catan", "Strategy", 4);
manager.addGame("Uno", "Party", 10);

System.out.println(manager.searchByCategory("Strategy")); 
// Saída esperada: [BoardGame{name='Catan', category='Strategy', numberOfPlayers=4}]

manager.removeGame("Uno");

📌 Tratamento de Erros

Se um jogo não for encontrado ao tentar removê-lo, o sistema lançará uma exceção:

Exception in thread "main" GameNotFoundException: Jogo não encontrado: Uno

### Licença

Este projeto está licenciado sob a MIT License.

### Autor

Demosthens Cavalcanti<br>
https://www.linkedin.com/in/demosthens-cavalcanti-4a0b9627b/ | demosthenscf@gmail.com
