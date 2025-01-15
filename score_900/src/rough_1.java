import java.io.*;
import java.util.StringTokenizer;

public class rough_1 {
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
                int x = in.nextInt();
                // so now here
                long sum = 0;
                int  max = 0;
                for(int i = 0; i < n; i++){
                    int temp = in.nextInt();
                    sum += temp; // storing the value for the min result
                    max += (int)Math.ceil((double) temp/x); // adding the value for the max output here
                }
                int min = (int)Math.ceil((double) sum/x);
                // so now printing the output
                out.println(min + " " + max);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
