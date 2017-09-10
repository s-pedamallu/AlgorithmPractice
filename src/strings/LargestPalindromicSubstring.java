package strings;

public class LargestPalindromicSubstring {
	private final char SENTINAL_CHARACTER = '$';

	// Manacher's algorithm
	public String largestPalindromicSubstring(String str) {
		if(str == null || str.length()<2) {
			return str;
		}

		// 1. Add a sentinal character
		StringBuilder sb = new StringBuilder();
		sb.append(SENTINAL_CHARACTER);
		for(int i=0; i<str.length(); i++) {
			sb.append(str.charAt(i));
			sb.append(SENTINAL_CHARACTER);
		}
		String mstr = sb.toString();

		// 2. find the maximum palindrome centered at every position in the String
		int maxLength = 0;
		int maxCenter = -1;
		int[] lca = new int[mstr.length()];
		int pos = 0;
		while(pos<mstr.length()) {
			// 2.1 get maxLength palindrome centered at position i
			int len = getPalindomeLengthAt(mstr, pos);
			lca[pos] = len;
			if(len > maxLength) {
				maxLength = len;
				maxCenter = pos;
			}
			// 2.2 Choose next position
				// The idea is we know the length of palindrome at position pos and
				// positions before pos. So, to some extent we can predict the
				// palindromes upto the length of palidrome at pos to the right
				// for every position k from 1 to len
					// * if len+pos == mstr.length -> we cannot find any bigger substring break
					// * if (pos+k+(lca[pos-k]/2)) < len -> ignore
					// * if palindrome at right expands until pos+len and its mirror in left is upto its left edge -> nextPos
					// * if palindrome at right expands until pos+len and its mirror in left expands beyond the left edge -> ignore.
			if(pos+(len/2) == mstr.length()) {
				break;
			}
			int leftEnd = pos-(len/2);
			int rightEnd = pos+(len/2);
			boolean posChanged = false;
			for(int i=1; i<len/2; i++) {
				int left = lca[pos-i]/2;
				if(pos+i+left >= rightEnd && pos-i-left>=leftEnd) {
					pos = pos+i;
					posChanged = true;
					break;
				}
				lca[pos+i]=lca[pos-i];
			}
			if(!posChanged) {
				pos++;
			}
		}
		String palindrome = mstr.substring(maxCenter-(maxLength/2), maxCenter+(maxLength/2));
		// 3. Strip off sentinal characters
		sb = new StringBuilder();
		for(int i=0; i<palindrome.length(); i++) {
			if(palindrome.charAt(i) != SENTINAL_CHARACTER) {
				sb.append(palindrome.charAt(i));
			}
		}
		return sb.toString();
	}

	private int getPalindomeLengthAt(String s, int i) {
		int j=i-1;
		int k=i+1;
		int ans = 1;
		while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)) {
			j--;
			k++;
			ans+=2;
		}
		return ans;
	}
}
