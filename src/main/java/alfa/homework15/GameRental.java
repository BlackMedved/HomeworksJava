package alfa.homework15;

import java.util.ArrayList;
import java.util.List;

public class GameRental {
    private List<BoardGame> boardGameList = new ArrayList<>();

    public void addBoardGame(BoardGame boardGame) {
        if (boardGame == null || boardGameList.stream().map(BoardGame::getName).toList()
                .contains(boardGame.getName())) throw new IllegalArgumentException();
        boardGameList.add(boardGame);
    }

    public BoardGame getBoardGame(String name) {
        return boardGameList.stream().filter(boardGame -> boardGame.getName().equals(name))
                .findFirst().orElse(null);
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame boardGame = getBoardGame(name);
        if (boardGame == null) throw new IllegalArgumentException();
        if (boardGame.canBeRentedBy(customerAge) && !boardGame.isRented()) {
            boardGameList.get(boardGameList.indexOf(boardGame)).setRented(true);
            return true;
        }
        else return false;
    }

    public boolean returnGame(String name) {
        BoardGame boardGame = getBoardGame(name);
        if (boardGame != null && boardGame.isRented()) {
            boardGameList.get(boardGameList.indexOf(boardGame)).setRented(false);
            return true;
        }
        else return false;
    }

    public double calculateCost(String name, int days) {
        BoardGame boardGame = getBoardGame(name);
        if (boardGame == null || days <= 0) throw new IllegalArgumentException();
        return boardGame.getDayRentCost() * days;
    }

    public void reset() {
        boardGameList.forEach(boardGame -> boardGame.setRented(false));
    }

    public int size() {
        return boardGameList.size();
    }

    public List<BoardGame> getBoardGameList() {
        return boardGameList;
    }
}
