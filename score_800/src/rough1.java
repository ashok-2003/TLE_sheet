import java.util.*;
import java.io.*;

public class rough1 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
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
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                // so now here take the input here
                int n = in.nextInt();
                int k = in.nextInt();
                int[][] arr = new int[k][3];
                // so now here we have to take the input in here
                for(int i = 0; i < k; i++){
                    for(int j = 0; j < 3; j++){
                        arr[i][j] = in.nextInt();
                    }
                }
                boolean isPossilbe = true;
                // so now here intilized the array with the 1 here
                int[] ans = new int[n];
                Arrays.fill(ans , 1);
                // so now here we have to get the value of all here
                for(int i = 0; i < k; i++){
                    // so now take the all three elemnet here
                    int l = arr[i][0]-1;
                    int j = arr[i][1]-1; // zero based here
                    int m = arr[i][2];

                    // so now here we have to check for it
                    for(int x = l; x <= j; x++){
                        if(ans[x] == m){
                            ans[x] = (m + 1 <= n) ? m + 1 : 1;
                        }
                    }
                    // so now after that we have to check that we have find the min value here
                    for(int x = l; x <= j; x++){
                        if(ans[x] == m){
                            // so now here we have to update that we have not found teh answer here
                            isPossilbe = false;
                            out.println(isPossilbe);
                        }
                    }

                }
                // so nwo here if
                if(!isPossilbe){
                    out.println(-1);
                }
                else{
                    for(int o : ans){
                        out.print(o + " ");
                    }
                    out.println("");
                }

            }
            out.close();
        }
        catch(Exception e) {
            return;
        }
    }
}


