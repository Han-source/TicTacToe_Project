package control;

import model.Board;
import view.TicTactToeWin;

public class TicTacToeController {
	private TicTactToeWin win;
	private Board board;
	
	public TicTacToeController() {
		board = new Board();
		board.play();
		win = new TicTactToeWin(board);
		
	}
	public static void main(String[] args) {
		new TicTacToeController();
		
	
	}

}
