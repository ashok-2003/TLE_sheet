import java.io.*;
import java.util.StringTokenizer;

public class ques_14 {
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
                int[] arr_sorted = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    arr_sorted[i] = in.nextInt();
                }

                // Step 1: Find leftmost and rightmost differing indices
                int left = 0, right = n - 1;
                while (left < n && arr[left] == arr_sorted[left]) {
                    left++;
                }
                while (right >= 0 && arr[right] == arr_sorted[right]) {
                    right--;
                }

                // If already sorted
                if (left >= right) {
                    out.println((left + 1) + " " + (right + 1));
                    continue;
                }

                // Step 2: Expand left boundary
                while (left > 0 && arr_sorted[left] >= arr[left - 1]) {
                    left--;
                }

                // Step 3: Expand right boundary
                while (right < n - 1 && arr_sorted[right] <= arr[right + 1]) {
                    right++;
                }

                out.println((left + 1) + " " + (right + 1));
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
