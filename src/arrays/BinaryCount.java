package arrays;

public class BinaryCount {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length()==0) {
            return 0;
        }
        int zCount = 0;
        int oCount = 0;
        int ans = 0;
        boolean curIsOne = s.charAt(0) == '0' ? false : true; 
        for(int i=0; i<s.length(); i++) {
            if(i>0 && s.charAt(i) != s.charAt(i-1)) {
                ans+=Math.min(oCount, zCount);
                if(curIsOne) {
                        zCount = 0;
                } else {
                        oCount = 0;
                }
                curIsOne = !curIsOne;
            }
            if (s.charAt(i) == '0') {
                zCount++;
            } else {
                oCount++;
            }
        }
        ans+=Math.min(oCount, zCount);
        return ans;
    }
}
