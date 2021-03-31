package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.Cell;
import model.Stone;

public class DisplayPanel extends JPanel  {
	private CellButton[][] cellButtons = new CellButton[Board.ROOT][Board.ROOT];
	
	protected DisplayPanel(Board board, JLabel lblGuideGame) {
		Cell[][] cells= board.getCells();
		this.setLayout(new GridLayout(Board.ROOT,Board.ROOT));
		for(int row=0; row < Board.ROOT; row++) {
		for(int col=0; col< Board.ROOT; col++) {
			cellButtons[row][col] = new CellButton(row, col, cells[row][col]);  //칸에서 줄에게 요청 .
			cellButtons[row][col].addActionListener(e->
			{	//사용자가 선택한 Cell에 userStone 두기.
				CellButton btnCell = (CellButton) e.getSource();
				Cell cell = btnCell.getCell();
			if (!cell.isEmpty()) {
				return;
			}
			cell.setStone(Stone.userStone);
			btnCell.setText(""+Stone.userStone.getDisplayChar());
			if (cell.isSomeoneWin()) {
				lblGuideGame.setText("사용자가 이겼습니다");
				return;
			}
			Cell comecell = board.play();   //컴퓨터 돌 두기
			cellButtons[comecell.getRow()][comecell.getCol()].setText(""+Stone.comStone.getDisplayChar());
			if (comecell.isSomeoneWin()) {
				lblGuideGame.setText("컴퓨터가 이겼습니다");
				return;
			}
			if (board.isEnded()) {
				lblGuideGame.setText("다시 게임할까요?");
			}
			});
						
			this.add(cellButtons[row][col]);
		}
	}

  }
}