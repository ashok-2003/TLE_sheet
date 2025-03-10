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
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                if(n == 1){
                    out.println(0);
                    continue;
                }

                long[] prefix = new long[n];

                prefix[0] = arr[0]; // updated the first element

                for(int i = 1; i < n; i++){
                    prefix[i] = prefix[i-1] + arr[i];
                }


                long maxDifference = getMaxDifference(n, prefix);

                out.println(maxDifference);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

    private static long getMaxDifference(int n, long[] prefix) {

        long maxDifference = Long.MIN_VALUE; // store the final answer

        for(int k = 1; k < n; k++){
            if(n % k != 0){
                continue;  // as can not be divided into the equal box
            }

            long min_sum = prefix[k-1]; // sum of first k elements due to zero based indexing
            long max_sum = prefix[k-1];

            for(int i = 2*k-1; i < n; i += k){ // as the value for the first k is already calculated

                long val = prefix[i] - prefix[i-k];
                min_sum = Math.min(min_sum , val);
                max_sum = Math.max(max_sum , val);
            }

            // getting the max difference

            maxDifference = Math.max(maxDifference , max_sum - min_sum);
        }
        return maxDifference;
    }
}
