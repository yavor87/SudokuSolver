package sudokuSolver.board;

import java.util.ArrayList;

/**
 * Represents one 9x9 sudoku board.
 */
public class Board {
	private Block[] blocks;
	private Cell[][] cells;
	
	public Board() {
		// Initialize blocks and cells
		this.blocks = new Block[9];
		for (int index = 0; index < this.blocks.length; index++) {
			this.blocks[index] = new Block();
		}
		
		// Create cell map
		this.cells = new Cell[9][9];
		for (int blockIndex = 0; blockIndex < 9; blockIndex++) {
			Block block = this.blocks[blockIndex];
			for (int cellIndex = 0; cellIndex < 9; cellIndex++) {
				Cell cell = block.getCells()[cellIndex];
				
				int row = this.getCellRow(blockIndex, cellIndex);
				int column = this.getCellColumn(blockIndex, cellIndex);
				
				this.cells[row][column] = cell;
			}
		}
	}
	
	/**
	 * Gets the blocks of this {@link Board}.
	 * @return the blocks.
	 */
	public Block[] getBlocks() {
		return this.blocks;
	}
	
	/**
	 * Gets the cell map of this {@link Board}.
	 * @return the cells.
	 */
	public Cell[][] getCells() {
		return this.cells;
	}
	
	public void updateCellPosibilities() {
		int blockIndex = 0;
		for (Block block : this.getBlocks()) {
			int cellIndex = 0;
			
			for (Cell cell : block.getCells()) {
				if (cell.getValue() != Cell.Empty) {
					continue;
				}
				
				for (int value : this.getValuesInBlock(block)) {
					cell.removeValuePossibility(value);
				}
				for (int value : this.getValuesInHorizontal(blockIndex, cellIndex)) {
					cell.removeValuePossibility(value);
				}
				for (int value : this.getValuesInVertical(blockIndex, cellIndex)) {
					cell.removeValuePossibility(value);
				}
				
				cellIndex++;
			}
			blockIndex++;
		}
	}
	
	public String printBoard() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Cell cell = this.cells[i][j];
				builder.append(cell.getValue());
				builder.append(" ");
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}
	
	public String printCellPosibilities() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Cell cell = this.cells[i][j];
				builder.append(cell.getValuePossibilities().toString());
				builder.append("\t");
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}
	
	private ArrayList<Integer> getValuesInBlock(Block block) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (Cell cell : block.getCells()) {
			int cellValue = cell.getValue();
			if (cellValue != Cell.Empty) {
				values.add(cellValue);
			}
		}
		return values;
	}
	
	private ArrayList<Integer> getValuesInHorizontal(int blockIndex, int cellIndex) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		int row = this.getCellRow(blockIndex, cellIndex);
		for (int column = 0; column < 9; column++) {
			Cell cell = this.cells[row][column];
			int cellValue = cell.getValue();
			if (cellValue != Cell.Empty) {
				values.add(cellValue);
			}
		}
		
		return values;
	}
	
	private ArrayList<Integer> getValuesInVertical(int blockIndex, int cellIndex) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		int column = this.getCellColumn(blockIndex, cellIndex);
		for (int row = 0; row < 9; row++) {
			Cell cell = this.cells[row][column];
			int cellValue = cell.getValue();
			if (cellValue != Cell.Empty) {
				values.add(cellValue);
			}
		}
		
		return values;
	}
	
	private int getCellRow(int blockIndex, int cellIndex) {
		int row = (blockIndex / 3) * 3;
		row += (cellIndex / 3);
		return row;
	}
	
	private int getCellColumn(int blockIndex, int cellIndex) {
		int column = (blockIndex % 3) * 3;
		column += (cellIndex % 3);
		return column;
	}
}
