import java.io.*;
import java.util.*;
public class ques_3_1 {

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
            int T = in.nextInt(); // Read number of test cases
            while (T-- > 0){
                int n = in.nextInt();  // Read number of elements
                Pair[] arr = new Pair[n + 1];
                for (int i = 1; i <= n; i++) {
                    arr[i] = new Pair(in.nextLong(), i);  // Input as Pair (value, index)
                }

                // Sort the array based on the value
                Arrays.sort(arr, 1, n + 1, (a, b) -> Long.compare(a.first, b.first));
                // all start with one based indexing as
                // for the first test case see the 4th number
                int[] nxt = new int[n + 1];
                long[] sum = new long[n + 1];
                int[] ans = new int[n + 1];
                nxt[0] = (int) (sum[0] = 0);

                for (int i = 1; i <= n; i++) {
                    if (nxt[i - 1] >= i) { // checking for the previous value if it is greater no need
                        // as on the way in also included it's sum so it will still remains the same here also
                        nxt[i] = nxt[i - 1];
                        sum[i] = sum[i - 1];
                    } else {
                        sum[i] = sum[i - 1] + arr[i].first;
                        nxt[i] = i;
                        while (nxt[i] + 1 <= n && sum[i] >= arr[nxt[i] + 1].first) { // calulating till which value
                            // we can go
                            nxt[i]++;
                            sum[i] += arr[nxt[i]].first;
                        }
                    }
                    ans[arr[i].second] = nxt[i]; // updating the index of the answer
                }

                for (int i = 1; i <= n; i++) {
                    out.print(ans[i] - 1 + " ");
                }
                out.println("");
            }

            out.close();  // Close the output writer

        } catch (Exception e) {
            return;
        }
    }

    // Helper Pair class to store (value, index) pairs
    static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
