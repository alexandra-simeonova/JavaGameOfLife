package foundation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GOLBoard {

	public static int CELLSHORIZONTAL = 120;
	public static int CELLSVERTICAL   = 120;
	public static char REPRESENTATIONLIVECELL = '+';
	public static char REPRESENTATIONDEADCELL = '.';

	private CellState[][] board = new CellState[CELLSHORIZONTAL][CELLSVERTICAL];

	public GOLBoard() {
		for (int i = 0; i < board.length; ++i)
			for (int j = 0; j < board[i].length; ++j)
				board[i][j] = CellState.DEAD;
	}


	// loads the initial configuration from a GOL file and centers it on
	// the board
	// GOLFileException is thrown if
	// - the file cannot be opened or read
	// - the file contains illegal characters (different from
	//   REPRESENTATIONLIVECELL, REPRESENTATIONDEADCELL)
	// - the width of text lines varies
	// - the text lines have a length of 0 or > CELLSHORIZONTAL
	// - there are more lines than CELLSVERTICAL
	
	public GOLBoard(String filename) {
		this();

	}

	public CellState getCellState(int col, int row) {

		return board[col][row];
	}

	public void setCellState(int col, int row, CellState value) {

		board[col][row] = value;
	}

}
