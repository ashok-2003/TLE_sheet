import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_7 {
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
                int n = in.nextInt();
                int m = in.nextInt();
                int[][] arr = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = in.nextInt();
                    }
                }

                int[] ans = new int[n];
                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            ans[i] += Math.abs(arr[i][k] - arr[j][k]);
                        }
                    }
                }

                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += ans[i];
                }

                out.println(sum);

                 */

                // so now the complexity of this approach is n^2 * k

                // better way to sort the column as we are subtracting the column so like the thing is
                // this (bi-b1)+(bi-b2)+...+(bi-bi-1) can be written as
                // i*bi - (b1+b2+b3...bi-1) which is the prefix sum

                int n = in.nextInt();
                int m = in.nextInt();
                int[][] arr = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = in.nextInt();
                    }
                }

                long ans = 0;
                for (int j = 0; j < m; j++) {
                    // sort the array column wise
                    int[] col = new int[n];
                    for (int i = 0; i < n; i++) {
                        col[i] = arr[i][j]; // stored the column wise here
                    }
                    Arrays.sort(col);
                    long prefixSum = 0;
                    for (int i = 0; i < n; i++) {
                        ans += ((long) i * col[i]) - prefixSum;
                        prefixSum += col[i];
                    }
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
