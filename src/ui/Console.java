package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Console {

	public static void main(String[] args) {
		JFrame window = new JFrame("SudokuSolver");
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		final JSudokuBoard board = new JSudokuBoard();
		p.add(board);
		
		JButton button = new JButton("Calculate posibilities");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board.getBoard().updateCellPosibilities();
			}
		});
		p.add(button);
		
		JButton button2 = new JButton("Print posibilities");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(board.getBoard().printCellPosibilities());
			}
		});
		p.add(button2);
		
		window.add(p);
		
		window.setVisible(true);
	}

}
