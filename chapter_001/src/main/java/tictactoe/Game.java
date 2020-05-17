package tictactoe;

/**
 * многовато для 1го
 */

public class Game {
    public static boolean mark = false;

    public static void main(String[] args) {
        boolean turn = false;
        Represent represent = new Represent();
        ArtificialIntelligence ai = new ArtificialIntelligence();
        Dialog dialog = new Dialog();

        dialog.writeMessage("если хотите играть крестиком input 1");
        if (dialog.readInt() == 1) {
            mark = true;
        }
        dialog.writeMessage("Input size game field:");
        Logic logic = new Logic(dialog.readInt());
        dialog.writeMessage("если хотите начинать играть 2 input 2");
        int r = dialog.readInt();
        if (r == 2) {
            turn = true;
        }
        while ((!logic.isWin())) {
            if (!turn) {
                dialog.writeMessage("input coordinates point");
                int x = dialog.readInt();
                int y = dialog.readInt();
                if (!logic.addPoint(x, y, mark)) {
                    dialog.writeMessage("error input");
                    continue;
                } else {
                    if (logic.isWin() || logic.deadHeat()) {
                        break;
                    }
                }
                represent.view(logic.getField(), logic.getSize());
            }
            Point aiPoint = ai.moveAI(logic.getField(), mark, logic.getSize());
            logic.addPoint(aiPoint.getX(), aiPoint.getY(), !mark);
            represent.view(logic.getField(), logic.getSize());
            turn = false;
            if (logic.deadHeat()) {
                break;
            }
        }
    }
}
