import java.io.*;
import java.util.StringTokenizer;

public class ques_18 {
//    https://codeforces.com/problemset/problem/1624/B
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
                // so now here
                long a = in.nextLong();
                long b = in.nextLong();
                long c = in.nextInt();
                // just solve the question on the copy
                // either am b c     a bm c    a b cm is an ap so now  d should be same so calculate this to find
                // the answer here
                if((2* b - c)/a > 0 && (2 * b - c) % a == 0){
                    out.println("yes");
                }else if ((c + a) % (2*b) == 0){
                    out.println("yes");
                }else if ((2 * b -a)/c > 0 && (2 * b -a) % c == 0){
                    out.println("yes");
                }else if (a == b && b == c){
                    out.println("yes");
                } else{
                    out.println("no");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
