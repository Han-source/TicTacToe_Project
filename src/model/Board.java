package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	/** 판의 크기 */
	public static final int ROOT = 3;
	private Cell[][] cells = new Cell[ROOT][ROOT];  //자료형 없으면 default 자료형으로 넘어감.
	private List<Line> lines = new ArrayList<>();
	
	
	//생성자 
	public Board() {
		// 이중반복문으로 전체 9개의 칸 만들기
		for(int row=0; row< ROOT; row++) {
			for(int col=0; col< ROOT; col++) {
				cells[row][col]	= new Cell(row,col);     // 셀 생성하기.
		 }
			
		}
		makeHorizontalLines();
		makeVerticalLines();
			
		//00 11 22 대각선
		Line diogonalLine = new Line();
		for(int j=0; j< ROOT; j++) {
			diogonalLine.addCell(cells[j][j]);
		}
		lines.add(diogonalLine);
		
		
		
		//02 11 20 기울어진 대각선
		diogonalLine = new Line();
		for(int j=0; j< ROOT; j++) {
			diogonalLine.addCell(cells[j][ROOT-j -1]);
	
		}
		lines.add(diogonalLine);
	}
	
	//가로줄 만들기 0  (0,1,2)
	private void makeHorizontalLines() {
		for(int row=0; row < ROOT; row++) {
				Line horizLine = new Line();
			for(int col=0; col< ROOT; col++) {
				horizLine.addCell(cells[row][col]);    //칸에서 줄에게 요청 .
			}
			lines.add(horizLine);  //
		 }
		}
		//세로줄 만들기  00 10 20
	private void makeVerticalLines() {
		for(int row=0; row < ROOT; row++) {
			Line verticalLine = new Line();
		for(int col=0; col< ROOT; col++) {
			verticalLine.addCell(cells[col][row]);   //줄아 칸담아라
		}
		lines.add(verticalLine);
	  }
	}	
	
	public Cell[][] getCells() {
		return cells;
	}

	/**
	 * bestCell 변수는 NullPointerRefException은 발생하지 않는다.
	 * 이는 Controller에서 빈칸이 있을 때만 play()를 요청
	 */
	public Cell play() {
		// 모든 빈칸을 대상으로 가장 높은 점수를 가진 칸을 찾아서  comStone을 놓자
		int max = Integer.MIN_VALUE;
		Cell bestCell = null;
		for(int row=0; row< ROOT; row++) {
			for(int col=0; col< ROOT; col++) {
				if(cells[row][col].getStone() == Stone.empty) {
					int val = cells[row][col].eval();  //가장 높은 점수를 가진 칸을 찾는 함수
					if(max < val) {
						max = val;
						bestCell = cells[row][col];
					}
				}
				
			}
		}		
		bestCell.setStone(Stone.comStone);
		return bestCell;
	}


	/**
	 *  There is no empty cell. 빈칸 없을 때
	 * 
	 */
	public boolean isEnded() {
		for(int row=0; row< ROOT; row++) {
			for(int col=0; col< ROOT; col++) {
				if(cells[row][col].isEmpty()) {
					return false;
				}
			}
		}
		
		return true;
	}
}
