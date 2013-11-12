package sudokuSolver.board;

import java.util.ArrayList;;

/**
 * A single cell in the Sudoku board.
 */
public class Cell {
	public static final int Empty = 0;
	private int value;
	private ArrayList<Integer> valuePossibilities;

	private Block block;

	public Cell() {
		this.value = Cell.Empty;
		this.valuePossibilities = new ArrayList<>();
		this.initializeValuePossibilities();
	}
	
	/**
	 * @return the value of this cell.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Gets the value of this cell.
	 * Valid range 1-9.
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
		this.onValueChanged();
	}
	
	/**
	 * Gets the block in which this {@link Cell} resides.
	 * @return the block in which this {@link Cell} resides.
	 */
	public Block getBlock() {
		return block;
	}
	
	/**
	 * Gets the possible values for this cell.
	 * @return the possible values for this cell.
	 */
	public ArrayList<Integer> getValuePossibilities() {
		return valuePossibilities;
	}
	
	/**
	 * Adds a value possibility for this cell.
	 * @param valuePossibility The value possibility to add.
	 */
	public void addValuePossibility(int valuePossibility) {
		this.valuePossibilities.add(valuePossibility);
	}
	
	/**
	 * Removes a value possibility for this cell.
	 * @param valuePossibility The value possibility to remove.
	 */
	public void removeValuePossibility(int valuePossibility) {
		this.valuePossibilities.remove((Object)valuePossibility);
	}
	
	protected void onValueChanged() {
		this.valuePossibilities.clear();
		if (this.value == Cell.Empty) {
			this.initializeValuePossibilities();
		}
	}
	
	private void initializeValuePossibilities() {
		for (int i = 1; i < 10; i++) {
			this.valuePossibilities.add(i);
		}
	}
}
