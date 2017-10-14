package arrays;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (isPresent(board, word, 0, i, j, new HashSet<Point>())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isPresent(char[][] board, String word, int pos, int r, int c, Set<Point> points) {
		if (pos == word.length()) {
			return true;
		}

		Point p = new Point(r, c);
		int rows = board.length;
		int cols = board[0].length;
		if (r < 0 || r >= rows || c < 0 || c >= cols || points.contains(p)) {
			return false;
		}

		if (board[r][c] == word.charAt(pos)) {
			points.add(p);
			if(isPresent(board, word, pos + 1, r + 1, c, points)
					|| isPresent(board, word, pos + 1, r - 1, c, points)
					|| isPresent(board, word, pos + 1, r, c + 1, points)
					|| isPresent(board, word, pos + 1, r, c - 1, points)) {
				return true;
			}
		}
		points.remove(p);
		return false;
	}

	private static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int hashCode() {
			return 73 + 31 * r + 31 * c;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")";
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point other = (Point) o;
				return this.r == other.r && this.c == other.c;
			}
			return false;
		}
	}
}
