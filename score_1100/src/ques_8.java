import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_8 {
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
                int k = in.nextInt();
                int a = in.nextInt() -1; // zero based
                int b = in.nextInt() -1; // zero based

                long[][] arr = new long[n][2];  // stored one extra for marking the major cities at the last and staring and ending
                for (int i = 0; i < n; i++) {

                    arr[i][0] = in.nextLong(); // x coordinate
                    arr[i][1] = in.nextLong(); // y coordinate
                }

                // calculating the direct difference here
                long directDifference = Math.abs(arr[a][0] - arr[b][0]) + Math.abs(arr[a][1] -  arr[b][1]);

                if(k == 0){  // to avoid long overflow
                    out.println(directDifference);
                    continue;
                }

                // so now calculating the nearest possible distance to a major city from a
                long aToMajor = Long.MAX_VALUE;
                long bToMajor = Long.MAX_VALUE;
                for(int i = 0; i < k; i++){
                    long aVal = Math.abs(arr[a][0] - arr[i][0]) + Math.abs(arr[a][1] - arr[i][1]);
                    long bVal = Math.abs(arr[b][0] - arr[i][0]) + Math.abs(arr[b][1] - arr[i][1]);

                    aToMajor = Math.min(aToMajor , aVal);
                    bToMajor = Math.min(bToMajor , bVal);
                }



                long ans = Math.min(directDifference , (aToMajor + bToMajor));  // it will overflow if we add to max
                // long value
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

}
