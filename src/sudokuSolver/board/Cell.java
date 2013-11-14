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
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException("the value of the Cell should be between 0 and 9");
		}
		
		this.value = value;
		this.onValueChanged();
	}
	
	/**
	 * Sets the value of this cell to {@link Cell.Empty}.
	 */
	public void clearValue() {
		this.value = Cell.Empty;
		this.valuePossibilities.clear();
		this.initializeValuePossibilities();
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
	 * @throws IllegalArgumentException
	 */
	public void addValuePossibility(int valuePossibility) {
		if (valuePossibility < 1 || valuePossibility > 9) {
			throw new IllegalArgumentException("the value posibility should be between 1 and 9");
		}
			
		if (!this.valuePossibilities.contains(valuePossibility)) {
			this.valuePossibilities.add(valuePossibility);
		}
	}
	
	/**
	 * Removes a value possibility for this cell.
	 * @param valuePossibility The value possibility to remove.
	 * @throws IllegalArgumentException
	 */
	public void removeValuePossibility(int valuePossibility) {
		if (valuePossibility < 1 || valuePossibility > 9) {
			throw new IllegalArgumentException("the value posibility should be between 1 and 9");
		}
		
		this.valuePossibilities.remove((Object)valuePossibility);
	}
	
	protected void onValueChanged() {
		this.valuePossibilities.clear();
		if (this.value == Cell.Empty) {
			this.clearValue();
		}
	}
	
	private void initializeValuePossibilities() {
		for (int i = 1; i < 10; i++) {
			this.valuePossibilities.add(i);
		}
	}
}
