package strings;

public class MaxAbsolutePathLength {
    private static final String DELIMITER="\n";
    private static final String SEPARATOR="/";
    private static final String DEPTH_INDICATOR = "\t";
    public int lengthLongestPath(String input) {
        if(input==null || input.length()==0) {
            return 0;
        }
        int maxLength = 0;
        StringBuilder dirBuilder = new StringBuilder();
        int pos = 0;
        int curDepth = 0;
        while(pos<input.length()) {
            int end = input.indexOf(DELIMITER, pos);
            if(end<0) {
                end = input.length();
            }
            int depth = getDepth(input, pos);
            System.out.println("pos: "+pos+"; end: "+end+"; depth: "+depth);
            String file = input.substring(pos+depth*DEPTH_INDICATOR.length(), end);
            while(depth<curDepth) {
                int start = dirBuilder.lastIndexOf(SEPARATOR, dirBuilder.length()-2)+1;
                dirBuilder.delete(start, dirBuilder.length());
                curDepth--;
            }

            if(isDir(file)) {
                dirBuilder.append(file+SEPARATOR);
                curDepth++;
            } else {
                String fileName = dirBuilder.toString()+file;
                System.out.println("file: "+fileName);
                maxLength = Math.max(maxLength, fileName.length());
            }
            pos = end+DELIMITER.length();
        }
        return maxLength;
    }

    private boolean isDir(String s) {
        return s.indexOf('.') == -1;
    }

    private int getDepth(String s, int pos) {
        int ans = 0;
        int l = DEPTH_INDICATOR.length();
        while(s.substring(pos, pos+l).equals(DEPTH_INDICATOR)) {
            pos+=l;
            ans++;
        }
        return ans;
    }
}
