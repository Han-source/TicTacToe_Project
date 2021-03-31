package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.TicTacToeController;
import model.Board;
import model.Stone;

public class TicTactToeWin extends JFrame {
	// 게임 상황에 따라 사용자에게 가이드 진행.
	private JLabel lblGuideGame = new JLabel("TicTactoe 게임에 오신걸 환영합니다!");
	//사용자의 클릭에 따른 Cell 선택 및 전체 상황 출력 용도
	private DisplayPanel pnlDisplay;
	
	
	/**
	 * GUI Window 설정
	 */
	public TicTactToeWin(Board board){
		
		this.setTitle("GUI를 이용한 TicTactoe");
		this.setSize(300, (int)(300/ 1.6)); // 폭, 높이 설정.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 사용자가 우상단의 닫기를 누르면 프로그램 종료 설정
		
		//사용자에게 가이드 관련 처리
		this.add(lblGuideGame,BorderLayout.NORTH);
		
		// 진행 상황 관련 처리
		pnlDisplay = new DisplayPanel(board,lblGuideGame);
		pnlDisplay.setBounds(25, 10, 250, (int)(250/ 1.6)); //x,y좌표와 폭과 높이 설정.
		this.add(pnlDisplay,BorderLayout.CENTER);
		
		//Reset button 관련 처리
		JButton reset = new JButton("다시 게임하기"); //다시하기 만들기
		reset.addActionListener(e->{repaint();});
		this.add(reset,BorderLayout.SOUTH);
		this.setVisible(true); // 윈도우 출력
		
		
		
	}
}
