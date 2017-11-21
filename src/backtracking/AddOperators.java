package backtracking;

import java.util.LinkedList;
import java.util.List;

public class AddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> result = new LinkedList<>();
		if (num == null || num.isEmpty()) {
			return result;
		}
		int val = num.charAt(0) - '0';
		backTrack(num, target, 1, new Integer(val).toString(), result);
		return result;
	}

	private void backTrack(String str, int target, int pos, String cur, List<String> result) {
		if (pos == str.length()) {
			if (compute(cur) == target) {
				result.add(cur);
			}
			return;
		}
		int digit = str.charAt(pos) - '0';
		backTrack(str, target, pos + 1, cur + "+" + digit, result);
		backTrack(str, target, pos + 1, cur + "*" + digit, result);
		backTrack(str, target, pos + 1, cur + "-" + digit, result);
	}

	private int compute(String s) {
		System.out.println("Before mul: " + s);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				int j = i - 1;
				while (j >= 0 && !(s.charAt(j) == '+' || s.charAt(j) == '-')) {
					j--;
				}
				int d1 = Integer.valueOf(s.substring(j + 1, i));
				int d2 = s.charAt(i + 1)-'0';
				int v = d1 * d2;
				if (i + 2 < s.length()) {
					s = s.substring(0, i - 1) + v + s.substring(i + 2);
				} else {
					s = s.substring(0, i - 1) + v;
				}
				i--;
			}
		}
		System.out.println("After mul: " + s);		
		int[] opNext = getOperand(s, 0);
		int operand1 = opNext[0];
		int pos = opNext[1];
		
		while(pos<s.length()) {
			opNext = getOperand(s, pos+1);
			if(s.charAt(pos) == '+') {
				operand1 = operand1 + opNext[0];
			} else {
				operand1 = operand1 - opNext[0];
			}
			pos = opNext[1];
		}
		return operand1;
	}

	private int[] getOperand(String s, int from) {
		int i=from;
		while(i<s.length()) {
			if(s.charAt(i)=='+' || s.charAt(i)=='-') {
				break;
			}
			i++;
		}
		return new int[]{Integer.valueOf(s.substring(from, i)), i};
	}
}
