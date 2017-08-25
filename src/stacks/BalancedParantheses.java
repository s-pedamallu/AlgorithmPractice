package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParantheses {

    public List<String> generateParenthesis(int n) {
        int k = 2*n;
        List<String> valid = new ArrayList<>();
        for (double d=Math.pow(2,k-1); d<Math.pow(2, k)-1; d++) {
            int i = (int) d;
            StringBuilder sb = new StringBuilder();
            for(int j=k-1; j>=0; j--) {
                int mask = 1 << j;
                if((i & mask) > 0) {
                    sb.append("(");
                } else {
                    sb.append(")");
                }
            }
            String str = sb.toString();
            if(isValid(str)) {
                valid.add(str);
            }
        }
        return valid;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c==')') {
                if(stack.isEmpty() || stack.peek()!='(') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push('(');
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BalancedParantheses bp = new BalancedParantheses();
		System.out.println(bp.generateParenthesis2(n));
	}

}
