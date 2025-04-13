import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_12 {
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
                long[] spend = new long[n];
                long[] total = new long[n];
                for (int i = 0; i < n; i++) {
                    spend[i] = in.nextLong();
                }
                for (int i = 0; i < n; i++) {
                    total[i] = in.nextLong();
                }

                // so now getting their difference here
                long[] diff = new long[n];
                for (int i = 0; i < n; i++) {
                    diff[i] = total[i] - spend[i];
                }

                // so now sort the answer here
                Arrays.sort(diff);

                int start = 0;
                int end = n-1;
                int ans = 0;
                while (start < end){
                    if(diff[start] + diff[end] >= 0){
                        ans++;
                        start++;
                        end--;
                    }else{
                        start++; // take the smaller negative value of diff here
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
