package airbnb.practice;

public class StringSimilarity {

    static int[] stringSimilarity2(String[] inputs) {        
        int[] ans = new int[inputs.length];
        for(int i=0; i<inputs.length; i++) {
            String str = inputs[i];
            int total = str.length();
            for(int j=1; j<str.length(); j++) {
                String sub = str.substring(j);
                int count = 0;
                while(count<sub.length() && str.charAt(count) == sub.charAt(count)) {
                    count++;
                }
                total += count;
            }
            ans[i] = total;
        }
        return ans;
    }
}
