package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MaxRectangleHistogram {

	public static void main (String[] args) throws IOException {
		System.out.println("Print array");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		int[] arr = new int[tokens.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.valueOf(tokens[i]);
		}
		MaxRectangleHistogram obj = new MaxRectangleHistogram(arr);
		System.out.println(obj.maxAreaRectangle());
	}

	private int arr[];

	public MaxRectangleHistogram(int[] arr) {
		this.arr = arr;
	}

	public int maxAreaRectangle() {
		LinkedList<Integer> stack = new LinkedList<>();
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
				maxArea = Math.max(maxArea, getArea(i, stack));
			}
			stack.addLast(i);
		}
		int i = arr.length;
		while(!stack.isEmpty()) {
			maxArea = Math.max(maxArea, getArea(i, stack));
		}
		return maxArea;
	}
	
	private int getArea(int curIdx, LinkedList<Integer> stack) {
		int idx = stack.removeLast();
		int val = arr[idx];
		int area = 0;
		if(stack.isEmpty()) {
			area = val*curIdx;
		} else {
			area = val * (curIdx - stack.getLast() - 1);
		}
		return area;
	}
}
