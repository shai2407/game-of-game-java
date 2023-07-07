import java.util.Random;

public class Matrix {
	
	// according to game of life roles
	final int WILL_LIVE = 3;
	final int MAY_LIVE = 2;
	
	private boolean [][] _board;

	// Constructor
	public Matrix(int x) {
		 _board = new boolean [x][x];
	}
	
	//return the matrix's board
	public boolean [][] getMatrix() {
		return _board;
	}
	
	//return the next generation
	public Matrix next(Matrix matrix){
		return nextGeneration(matrix);
	}
	
	// initialize random matrix
	public void randomBoard(Matrix matrix) {
		Random rand = new Random();
		for (int i=0;i<matrix._board.length;i++) {
			for (int j=0;j<matrix._board.length;j++) {
				matrix._board[i][j] = rand.nextBoolean();
			}
		}
	}
	
	// check if a cell will live in the next generation
	private boolean amIAlive(Matrix matrix,int i,int j) {
		
		int countNeighbers = 0;
		
		// check each neighbor
		for (int a = i-1;a<i+2;a++) {
			for (int b = j-1;b<j+2;b++) {
				// don't count yourself
				if(a==i && b==j){
					continue;
				}
				if(inBounds(matrix,a,b) && matrix._board[a][b] == true)
					countNeighbers++;				
			}		
		}
		if(countNeighbers == WILL_LIVE) 
			return true;
		if(countNeighbers == MAY_LIVE && matrix._board[i][j])
			return true;
		return false;
	}
	
	// check if i,j inside the bounds of matrix
	private boolean inBounds(Matrix matrix,int i,int j) {
		return i>0 && i<matrix._board.length && j>0 && j<matrix._board.length;
	}
	
	// calc how the matrix looks in the next generation
	private Matrix nextGeneration(Matrix matrix){
		Matrix newMatrix = new Matrix(matrix._board.length);
		for (int i=0;i<matrix._board.length;i++) {
			for (int j=0;j<matrix._board.length;j++) {
				newMatrix._board[i][j] = amIAlive(matrix,i,j);			
			}
		}
		return newMatrix;
	}

}