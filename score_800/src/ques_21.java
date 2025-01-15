import java.io.*;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1829/B
// blank space
public class ques_21 {
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
                // so now here we have to get the blank space here
                int max = 0; // so this take care of my blank space
                int currcount = 0; // so this take care of contstitive blank space here
                // so now here
                int len = in.nextInt();
                for (int i = 0; i < len; i++) {
                    int temp = in.nextInt();
                    if(temp == 0){
                        currcount++;
                        max = Math.max(max , currcount);
                    }else{
                        // so now it means that we have get the 1 so now making the length to the zero here
                        currcount = 0;
                    }
                }
                out.println(max);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
