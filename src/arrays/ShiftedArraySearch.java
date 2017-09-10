package arrays;

public class ShiftedArraySearch {


	  static int shiftedArrSearch(int[] shiftArr, int num) {
	    // your code goes here
	    int result = -1;
	    if(shiftArr == null || shiftArr.length==0) {
	      return result;
	    }
	    int l = 0;
	    int r = shiftArr.length - 1;
	    while(l<=r) {
	      int m = (l+r)/2;
	      if(num == shiftArr[m]) {
	        return m;
	      } else if(num==shiftArr[l]) {
	    	  return l;
	      } else if(num==shiftArr[r]) {
	    	  return r;
	      } else if(shiftArr[l] < shiftArr[m]) { // ascending order
	        if(num < shiftArr[m] && num >= shiftArr[l]) {
	          r = m-1;
	        } else {
	          l = m+1;
	        }
	      } else {
	        if(num < shiftArr[m] || num>=shiftArr[l]) {
	          r = m-1;
	        } else {
	          l = m+1;
	        }
	      }
	    }
	    return -1;
	  }
	  
	  public static void main(String[] args) {
		  int[] arr = {1,2};
		  System.out.println(ShiftedArraySearch.shiftedArrSearch(arr, 2));
	  }	
}
