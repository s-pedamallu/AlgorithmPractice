package arrays;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0) {
            return;
        }
        Integer special = null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] row0 = matrix[0];
        int[] col0 = new int[cols];
        for(int i=0; i<cols; i++) {
        	col0[i]=matrix[i][0];
        }
        // check if there are zeros in row 1 and col1
        if(matrix[0][0] != 0) {
            for(int i=0; i<cols; i++) {
            	if(matrix[0][i] == 0) {
            		special = 1;
            	}
            }        	
            for(int i=0; i<rows; i++) {
            	if(matrix[i][0] == 0) {
            		special = special==null ? 2 : 0;
            	}
            }        	
        } else {
        	special = 0;
        }
        // use first row and first column to store
        // use first row and first column to store
        for(int i=1; i<rows; i++) {
        	for(int j=1; j<cols; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        }

        for(int i=1; i<cols; i++) {
        	if(matrix[0][i] == 0) {
        		for(int j=1; j<rows; j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        for(int i=1; i<rows; i++) {
        	if(matrix[i][0] == 0) {
        		for(int j=1; j<cols; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }

    	for(int i=1; i<cols; i++) {
    		if(special == null || special == 2) {
    			matrix[0][i] = row0[i];
    		} else {
    			matrix[0][i] = 0;
    		}
    	}
    	for(int i=1; i<rows; i++) {
    		if(special == null || special == 2) {
    			matrix[i][0]=col0[i];
    		} else {
    			matrix[i][0] = 0;
    		}
    	}
    	matrix[0][0] = special == null ? row0[0] : 0;
    } 
}
