package main.board;

import main.board.Board;
import main.level.Easy;
import main.level.Expert;
import main.level.Intermediate;

public final class BoardFactory {
    private BoardFactory(){
    }

    /**
     * Creates an easy(1), intermediate(2) or expert(3) board.
     * @param version
     * @return
     */
    public static Board generate(int version) {
        return switch (version) {
            case 1 -> new Board(Easy.HEIGHT, Easy.WIDTH, Easy.MINE_COUNT);
            case 2 -> new Board(Intermediate.HEIGHT, Intermediate.WIDTH,
                    Intermediate.MINE_COUNT);
            case 3 -> new Board(Expert.HEIGHT, Expert.WIDTH,
                    Expert.MINE_COUNT);
            //todo change exception to more custom one
            default -> throw new IllegalArgumentException();
        };
    }
}
