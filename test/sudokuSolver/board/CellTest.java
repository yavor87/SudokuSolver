package sudokuSolver.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell cell;
	
	@Before
	public void setUp() {
		this.cell = new Cell();
	}
	
	@Test
	public void testCellCreatedEmpty() {
		assertEquals(Cell.Empty, this.cell.getValue());
	}
	
	@Test
	public void testGetValue() {
		int cellValue = this.cell.getValue();
		assertEquals(Cell.Empty, cellValue);
	}

	@Test
	public void testSetValue() {
		for (int i = 1; i < 10; i++) {
			int target = i;
			this.cell.setValue(target);
			assertEquals(target, this.cell.getValue());
			assertEquals(0, this.cell.getValuePossibilities().size());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidValue() {
		this.cell.setValue(10);
	}
	
	@Test
	public void testSetEmptyValue() {
		this.cell.setValue(3);
		this.cell.setValue(Cell.Empty);
		assertEquals(Cell.Empty, this.cell.getValue());
		assertEquals(9, this.cell.getValuePossibilities().size());
	}
	
	@Test
	public void testClearValue() {
		this.cell.setValue(3);
		this.cell.clearValue();
		assertEquals(Cell.Empty, this.cell.getValue());
		assertEquals(9, this.cell.getValuePossibilities().size());
	}

	@Test
	public void testGetBlock() {
		assertNull(this.cell.getBlock());
	}

	@Test
	public void testGetValuePossibilities() {
		ArrayList<Integer> valuePossibilites = this.cell.getValuePossibilities();
		assertNotNull(valuePossibilites);
		assertEquals(9, valuePossibilites.size());
		for (int i = 0; i < valuePossibilites.size(); i++) {
			int valuePossibility = valuePossibilites.get(i);
			assertEquals(i + 1, valuePossibility);
		}
	}

	@Test
	public void testAddValuePossibility() {
		for (int i = 1; i < 10; i++) {
			this.cell.addValuePossibility(i);
			assertEquals(9, this.cell.getValuePossibilities().size());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddEmptyValuePossibility() {
		this.cell.addValuePossibility(Cell.Empty);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddInvalidValuePossibility() {
		this.cell.addValuePossibility(10);
	}

	@Test
	public void testRemoveValuePossibility() {
		for (int i = 1; i < 10; i++) {
			this.cell.removeValuePossibility(i);
			assertEquals(9 - i, this.cell.getValuePossibilities().size());
		}
	}

	@Test
	public void testRemoveValuePossibilityTwice() {
		this.cell.removeValuePossibility(3);
		this.cell.removeValuePossibility(3);
	}
}
