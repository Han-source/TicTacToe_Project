package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {
	private List<Cell> cells = new ArrayList<>();
	
	public void addCell(Cell cell) {
		
		cells.add(cell);
		cell.addLine(this); // 넘어온 cell(칸)이 자신에게 담긴것을 의미.
}

	private static  Map<Integer, Integer> EVALTABLE = new HashMap<>();
	static {
		//빈칸 개수, 플레이어 둘 개수, 컴퓨터 돌 개수  X 유저 0컴퓨터
		EVALTABLE.put(300, 1); 		// _ _ _1 모든 칸이 비어있는 상태면 1점.
		EVALTABLE.put(201, 3); 		// _ _ O 	3   나만 한개 있으면 3점
		EVALTABLE.put(210, 2); 		// _ _ X 	2 
		EVALTABLE.put(111, 0); 		// X _ O 	0 
		EVALTABLE.put(12, 0);		// X O O    0  
		EVALTABLE.put(102, 20);		// O O _ 	20
		EVALTABLE.put(120, 15);	 	// _ X X 	15
		EVALTABLE.put(3, 100);		// O O O 	100
		EVALTABLE.put(30, -100); 	// X X X 	-100
	}
	public int eval() {
		int[] countOfStone = new int[Stone.values().length];  //values는 Stone의 enum 값들  즉 총 3개
		for(Cell cell : cells) {
			countOfStone[cell.getStone().ordinal()]++;	//ordinal는 순서를 뜻함. 스톤은 0 1 2 순서로 지정.
			   
			
		}
		 
		int key = 0;
		for (Stone stone : Stone.values()) {
			key = key * 10 + countOfStone[stone.ordinal()];
		}

	
		
		return EVALTABLE.get(key);
	}
	/**
	 * 줄에 들어있는 Cell들에게 본 줄은 필요없다고 통보하는 것.
	 */
	void notifyUseless(Cell dontCareCell) {
		for(Cell cell : cells) {
			if(cell != dontCareCell)
			cell.removeLine(this);
		}
	}
}
