package sudokuSolver.board;

/**
 * A block of 9 {@link Cell}s.
 */
public class Block {
	private Cell[] cells;
	
	public Block() {
		this.cells = new Cell[9];
		for (int index = 0; index < this.cells.length; index++) {
			this.cells[index] = new Cell();
		}
	}

	/**
	 * @return the cells.
	 */
	public Cell[] getCells() {
		return cells;
	}
	
	/**
	 * Sets the {@link Cell} at the specified index with the specified value.
	 * @param index The index of the cell.
	 * @param value The value of the cell.
	 */
	public void setCell(int index, int value) {
		this.cells[index].setValue(value);
	}
}
