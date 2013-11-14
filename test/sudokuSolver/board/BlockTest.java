package sudokuSolver.board;

import static org.junit.Assert.*;

import org.junit.*;

public class BlockTest {
	private Block block;
	
	@Before
	public void setUp() {
		this.block = new Block();
	}

	@Test
	public void testGetCells() {
		Cell[] cells = this.block.getCells();
		assertNotNull(cells);
		assertEquals(9, cells.length);
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			assertNotNull(cell);
		}
	}
}
