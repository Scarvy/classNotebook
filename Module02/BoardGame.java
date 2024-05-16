package Module02;

public class BoardGame {
    String name;
    int players;
    int duration;

    public BoardGame(String name) {
        this(name, 2, 60);
    }

    public BoardGame(String name, int players, int duration) {
        this.name = name;
        this.players = players;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%s has %d players.", name, players);
    }

    public static void main(String[] args) {
        BoardGame game1 = new BoardGame("Chess");
        BoardGame game2 = new BoardGame("Monopoly", 4, 120);

        System.out.println(game1);
        System.out.println(game2);

    }
}
