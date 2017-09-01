package arrays;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length==0 || matrix[0].length==0) {
			return;
		}
		// In-place possible only for a square matrix
		int rows = matrix.length;

		// Flip rows
		for(int i=0, j=rows-1; i<j; i++, j--) {
			int[] trow = matrix[i];
			matrix[i] = matrix[j];
			matrix[j] = trow;
		}

		// Transpose
		for(int i=0; i<rows; i++) {
			for(int j=i+1; j<rows; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
