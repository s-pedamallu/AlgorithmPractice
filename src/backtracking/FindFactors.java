package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        factors(n, new ArrayList<>(), result);
        return result;
    }

    private void factors(int n, List<Integer> cur, List<List<Integer>> result) {
        if(n == 1 && cur.size()>1) {        	
            result.add(cur);
            return;
        }
//        int till = (int) Math.ceil(n*1.0/2);
        for(int i=2; i <= n; i++) {
            if(n%i == 0 && (cur.isEmpty() || i>=cur.get(cur.size()-1))) {
                List<Integer> l = new ArrayList<>(cur);
                l.add(i);
                factors(n/i, l, result);                
            }
        }
    }
}
