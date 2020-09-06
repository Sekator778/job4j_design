package tictactoe;

/**
 * объект, в котором игровой цикл.
 * загружаем нужные объекты для инициализации игры.
 */
public class Engine {

    public void run(Dialog dialog, Logic logic, View represent, ArtificialIntelligence ai, boolean turn, boolean mark) {
        int x, y;
        while ((!logic.isWin())) {
            if (!turn) {
                dialog.writeMessage("input coordinates point");
                x = dialog.readInt();
                y = dialog.readInt();
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
