import java.io.*;
import java.util.StringTokenizer;

public class ques_26 {
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
                // initially we have 1 stick,and we have to craft k sticks
                // and their exits always answer
                int x = in.nextInt();
                int y = in.nextInt();
                int k = in.nextInt();
                // so now here as we require the coal and we have zero so required cola is  y * k
                long coal_required = (long) y * k;
                // so now this is the minimum step we have to perform so now 1 stick and one coal make a torch
                // so for the total requirement we have to add the k in coal _ required
                long total_required = coal_required + (long)k;
                // so now as we exchange the 1 stick for x stick so each time only x-1 only increase but
                // we have one stick already so now
                long total_count = Math.ceilDiv((total_required-1),(long)(x-1));
                out.println(total_count + k); // as we have to again change the stick to coal

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
