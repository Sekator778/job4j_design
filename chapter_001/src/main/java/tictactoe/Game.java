package tictactoe;

/**
 * многовато для 1го
 */

public class Game {
    public static boolean mark = false;

    public static void main(String[] args) {
        boolean turn = false;
        View represent = new Represent();
        ArtificialIntelligence ai = new ArtificialIntelligence();
        Dialog dialog = new Dialog();
        Engine engine = new Engine();

        dialog.writeMessage("если хотите играть крестиком введите 1");
        if (dialog.readInt() == 1) {
            mark = true;
        }
        dialog.writeMessage("Input size game field:");
        Logic logic = new Logic(dialog.readInt());
        dialog.writeMessage("если хотите делать ход вторым введите 2");
        int r = dialog.readInt();
        if (r == 2) {
            turn = true;
        }
        engine.run(dialog, logic, represent, ai, turn, mark);
    }
}
