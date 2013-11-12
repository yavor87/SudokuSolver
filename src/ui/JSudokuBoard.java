package ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sudokuSolver.board.*;

public class JSudokuBoard extends JComponent {
	private static final long serialVersionUID = 1L;
	private Board board;

	public JSudokuBoard() {
		this.board = new Board();
		this.initBoard();
	}

	public Board getBoard() {
		return this.board;
	}

	private void initBoard() {
		this.setLayout(new GridLayout(3, 3));

		LineBorder blockBorder = new LineBorder(Color.black, 2);
		LineBorder cellBorder = new LineBorder(Color.black, 1);

		for (Block block : this.board.getBlocks()) {
			JPanel blockPanel = new JPanel();
			blockPanel.setLayout(new GridLayout(3, 3));
			blockPanel.setBorder(blockBorder);

			for (final Cell cell : block.getCells()) {
				final JTextField cellTextField = new JTextField();
				int cellValue = cell.getValue();
				if (cellValue != 0) {
					cellTextField.setText(String.format("{0}", cellValue));
				}
				cellTextField.setBorder(cellBorder);
				cellTextField.getDocument().addDocumentListener(
						new DocumentListener() {

							@Override
							public void removeUpdate(DocumentEvent e) {
								this.updateCell();
							}

							@Override
							public void insertUpdate(DocumentEvent e) {
								this.updateCell();
							}

							@Override
							public void changedUpdate(DocumentEvent e) {
								this.updateCell();
							}

							private void updateCell() {
								String cellText = cellTextField.getText();
								int cellValue = Cell.Empty;
								if (!cellText.isEmpty()) {
									cellValue = Integer.parseInt(cellText);
								}
								cell.setValue(cellValue);
							}
						});
				blockPanel.add(cellTextField);
			}

			this.add(blockPanel);
		}
	}
}
