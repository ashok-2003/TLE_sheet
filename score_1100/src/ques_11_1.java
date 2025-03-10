import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_11_1 {
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
                // you can see that the greedy logic that we are thinking about to choose the min 2 or max 1 based on
                // the sum we can not do so now we can do the logic like each of the time we have option to explore the
                // both parts so now trying that path

                // that also is not working so if we observe that problem in good sense then we can think of
                // approach like checking the all possible cases

                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                Arrays.sort(arr);  // sorted the array

                // so now at  each step we can do two thing either
                // we can take 2.m element from the start and k - m  element from the back  and get the max value
                // at each step and can see what suits the most


                // can calculate the sum through the prefix sum in 0 (1)

                long[] prefix = new long[n+1];  // for the case zero as when all the element chosen from the right
                // then the left sum should be zero at the index 0 so that's why
                prefix[0] = arr[0];
                for(int i = 0; i < n; i++){
                    prefix[i+1] = prefix[i] + arr[i];
                }

                long ans = 0;

                for(int m = 0; m <= k; m++){
                    long val = prefix[ n - ( k-m ) ] - prefix[ 2*m ];  // calculated the sum at each of level
                    ans = Math.max(ans , val);
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
