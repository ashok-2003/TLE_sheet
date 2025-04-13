import java.util.*;
import java.io.*;

public class ques_13 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e){
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
            String str = "";
            try{
                str = br.readLine().trim();
            } catch(Exception e){
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;
        public FastWriter(){
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

    // Helper class to mimic the C++ struct
    static class Gap implements Comparable<Gap> {
        long gap;
        int two; // always set to 2
        Gap(long gap, int two) {
            this.gap = gap;
            this.two = two;
        }
        // Sort in descending order based on gap value
        @Override
        public int compareTo(Gap other) {
            return Long.compare(other.gap, this.gap);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int T = in.nextInt();
        while (T-- > 0) {
            long n = in.nextLong();
            int m = in.nextInt();
            long[] arr = new long[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextLong();
            }
            Arrays.sort(arr);

            // Calculate gaps between consecutive positions.
            ArrayList<Gap> gaps = new ArrayList<>();
            for (int i = 1; i < m; i++) {
                long diff = arr[i] - arr[i - 1] - 1;
                gaps.add(new Gap(diff, 2));
            }

            // Calculate the circular gap
            long circularGap = arr[0] + n - arr[m - 1] - 1;
            if (circularGap > 0) {
                gaps.add(new Gap(circularGap, 2));
            }

            // Sort gaps in descending order of gap value.
            Collections.sort(gaps);

            long ans = 0;
            long cnt = 0;
            // Process each gap similar to the C++ loop.
            for (Gap g : gaps) {
                long effective = g.gap - cnt * 2;
                if (effective > 0) {
                    long safe = Math.max(1, effective - 1);
                    ans += safe;
                }
                cnt += 2;
            }

            out.println(n - ans);
        }
        out.close();
    }
}
