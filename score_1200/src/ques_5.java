import java.io.*;
import java.util.StringTokenizer;

public class ques_5 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            Main.FastReader in=new Main.FastReader();
            Main.FastWriter out = new Main.FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){

                /*

                // so now for each of test case find the largest two values in which we can re-paint the first
                // difference between them
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n+1];
                int[] freq = new int[k+1];

                for (int i = 1; i <= n; i++) {
                    arr[i] = in.nextInt();
                    freq[arr[i]]++;
                }

                int ans = Integer.MAX_VALUE;

                for(int j = 1; j <= k; j++){
                    if(freq[j] == 0){
                        continue;
                    }
                    int diff1 = Integer.MIN_VALUE;
                    int diff2 = Integer.MIN_VALUE;
                    int prev_index = 0;
                    int target = j;
                    for(int i = 1; i <= n; i++){
                        if(arr[i] == target){
                            int diff = i - prev_index - 1;
                            if(diff > diff2){
                                if(diff > diff1){
                                   diff2 = diff1;
                                   diff1 = diff;
                                }else{
                                    diff2 = diff;
                                }
                            }
                            prev_index = i;
                        }
                    }
                    // after the loop
                    if (prev_index != 0) { // only if this color appeared at least once
                        int lastGap = n - prev_index;
                        if (lastGap > diff2) {
                            if (lastGap > diff1) {
                                diff2 = diff1;
                                diff1 = lastGap;
                            } else {
                                diff2 = lastGap;
                            }
                        }
                    }
                    // so now here we will check for the max value in the both
                    ans = Math.min(ans , Math.max(diff2 , (diff1)/2));
                }

                out.println(ans);


                 */

                // so now this is the second better approach here
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n+1];
                int[] lastOccurrence = new int[k+1];
                int[] maxGap = new int[k+1];
                int[] secondMaxGap = new int[k+1];

                // so now here in the first pass we will get the
                for (int i = 1; i <= n; i++) {
                    arr[i] = in.nextInt();
                }

                for (int i = 1; i <= n; i++) {
                    int val = arr[i];
                    int diff = i - lastOccurrence[val] - 1;
                    // so now here we will store the diff here
                    if(diff > secondMaxGap[val]){
                        if(diff > maxGap[val]){
                            secondMaxGap[val] = maxGap[val];
                            maxGap[val] = diff;
                        }else{
                            secondMaxGap[val] = diff;
                        }
                    }
                    lastOccurrence[val] = i;
                    // updated the last index
                }

                int ans = Integer.MAX_VALUE;
                for(int i = 1; i <= k; i++){
                    if(lastOccurrence[i] == 0){
                        continue; // this never occurs
                    }
                    int diff = n - lastOccurrence[i];
                    if(diff > secondMaxGap[i]){
                        if(diff > maxGap[i]){
                            secondMaxGap[i] = maxGap[i];
                            maxGap[i] = diff;
                        }else{
                            secondMaxGap[i] = diff;
                        }
                    }

                    ans = Math.min(ans , Math.max(secondMaxGap[i], maxGap[i]/2 ));
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
