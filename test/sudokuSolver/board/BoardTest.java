package sudokuSolver.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;

	@Before
	public void setUp() {
		this.board = new Board();
	}
	
	@Test
	public void testGetCells() {
		Block[] blocks = this.board.getBlocks();
		Cell[][] cells = this.board.getCells();
		assertNotNull(cells);
		
		Cell[] currentBlockCells = blocks[0].getCells();
		assertSame(currentBlockCells[0], cells[0][0]);
		assertSame(currentBlockCells[1], cells[0][1]);
		assertSame(currentBlockCells[2], cells[0][2]);
		assertSame(currentBlockCells[3], cells[1][0]);
		assertSame(currentBlockCells[4], cells[1][1]);
		assertSame(currentBlockCells[5], cells[1][2]);
		assertSame(currentBlockCells[6], cells[2][0]);
		assertSame(currentBlockCells[7], cells[2][1]);
		assertSame(currentBlockCells[8], cells[2][2]);
		
		currentBlockCells = blocks[1].getCells();
		assertSame(currentBlockCells[0], cells[0][3]);
		assertSame(currentBlockCells[1], cells[0][4]);
		assertSame(currentBlockCells[2], cells[0][5]);
		assertSame(currentBlockCells[3], cells[1][3]);
		assertSame(currentBlockCells[4], cells[1][4]);
		assertSame(currentBlockCells[5], cells[1][5]);
		assertSame(currentBlockCells[6], cells[2][3]);
		assertSame(currentBlockCells[7], cells[2][4]);
		assertSame(currentBlockCells[8], cells[2][5]);
		
		currentBlockCells = blocks[2].getCells();
		assertSame(currentBlockCells[0], cells[0][6]);
		assertSame(currentBlockCells[1], cells[0][7]);
		assertSame(currentBlockCells[2], cells[0][8]);
		assertSame(currentBlockCells[3], cells[1][6]);
		assertSame(currentBlockCells[4], cells[1][7]);
		assertSame(currentBlockCells[5], cells[1][8]);
		assertSame(currentBlockCells[6], cells[2][6]);
		assertSame(currentBlockCells[7], cells[2][7]);
		assertSame(currentBlockCells[8], cells[2][8]);
		
		currentBlockCells = blocks[3].getCells();
		assertSame(currentBlockCells[0], cells[3][0]);
		assertSame(currentBlockCells[1], cells[3][1]);
		assertSame(currentBlockCells[2], cells[3][2]);
		assertSame(currentBlockCells[3], cells[4][0]);
		assertSame(currentBlockCells[4], cells[4][1]);
		assertSame(currentBlockCells[5], cells[4][2]);
		assertSame(currentBlockCells[6], cells[5][0]);
		assertSame(currentBlockCells[7], cells[5][1]);
		assertSame(currentBlockCells[8], cells[5][2]);
		
		currentBlockCells = blocks[4].getCells();
		assertSame(currentBlockCells[0], cells[3][3]);
		assertSame(currentBlockCells[1], cells[3][4]);
		assertSame(currentBlockCells[2], cells[3][5]);
		assertSame(currentBlockCells[3], cells[4][3]);
		assertSame(currentBlockCells[4], cells[4][4]);
		assertSame(currentBlockCells[5], cells[4][5]);
		assertSame(currentBlockCells[6], cells[5][3]);
		assertSame(currentBlockCells[7], cells[5][4]);
		assertSame(currentBlockCells[8], cells[5][5]);
		
		currentBlockCells = blocks[5].getCells();
		assertSame(currentBlockCells[0], cells[3][6]);
		assertSame(currentBlockCells[1], cells[3][7]);
		assertSame(currentBlockCells[2], cells[3][8]);
		assertSame(currentBlockCells[3], cells[4][6]);
		assertSame(currentBlockCells[4], cells[4][7]);
		assertSame(currentBlockCells[5], cells[4][8]);
		assertSame(currentBlockCells[6], cells[5][6]);
		assertSame(currentBlockCells[7], cells[5][7]);
		assertSame(currentBlockCells[8], cells[5][8]);
		
		currentBlockCells = blocks[6].getCells();
		assertSame(currentBlockCells[0], cells[6][0]);
		assertSame(currentBlockCells[1], cells[6][1]);
		assertSame(currentBlockCells[2], cells[6][2]);
		assertSame(currentBlockCells[3], cells[7][0]);
		assertSame(currentBlockCells[4], cells[7][1]);
		assertSame(currentBlockCells[5], cells[7][2]);
		assertSame(currentBlockCells[6], cells[8][0]);
		assertSame(currentBlockCells[7], cells[8][1]);
		assertSame(currentBlockCells[8], cells[8][2]);
		
		currentBlockCells = blocks[7].getCells();
		assertSame(currentBlockCells[0], cells[6][3]);
		assertSame(currentBlockCells[1], cells[6][4]);
		assertSame(currentBlockCells[2], cells[6][5]);
		assertSame(currentBlockCells[3], cells[7][3]);
		assertSame(currentBlockCells[4], cells[7][4]);
		assertSame(currentBlockCells[5], cells[7][5]);
		assertSame(currentBlockCells[6], cells[8][3]);
		assertSame(currentBlockCells[7], cells[8][4]);
		assertSame(currentBlockCells[8], cells[8][5]);
		
		currentBlockCells = blocks[8].getCells();
		assertSame(currentBlockCells[0], cells[6][6]);
		assertSame(currentBlockCells[1], cells[6][7]);
		assertSame(currentBlockCells[2], cells[6][8]);
		assertSame(currentBlockCells[3], cells[7][6]);
		assertSame(currentBlockCells[4], cells[7][7]);
		assertSame(currentBlockCells[5], cells[7][8]);
		assertSame(currentBlockCells[6], cells[8][6]);
		assertSame(currentBlockCells[7], cells[8][7]);
		assertSame(currentBlockCells[8], cells[8][8]);
	}

	@Test
	public void testGetBlocks() {
		Block[] blocks = this.board.getBlocks();
		assertNotNull(blocks);
		assertEquals(9, blocks.length);
	}

	@Test
	public void testUpdateCellPosibilities() {
		fail("Not yet implemented");
	}
}
