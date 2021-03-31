package model;

public enum Stone {
	empty(' '), userStone('X'), comStone('O');

	private char displayChar;
	
	
	private Stone(char c) {
		displayChar =c;
	}

	
	public char getDisplayChar() {
		return displayChar;
	}

}

