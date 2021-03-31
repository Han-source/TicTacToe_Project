package view;

import javax.swing.JButton;

import model.Cell;
import model.Stone;

public class CellButton extends JButton {
	private int row, col;
	private Cell cell;

	public CellButton(int row, int col,Cell cell) {
		super(""+cell.getStone().getDisplayChar());
		this.cell = cell;
		this.row = row;
		this.col = col;
	}

	public Cell getCell() {
		return cell;
	}
	
	
}
