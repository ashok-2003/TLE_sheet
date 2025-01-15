import java.io.*;
import java.util.StringTokenizer;

public class ques_4 {
//    https://codeforces.com/problemset/problem/1875/A
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
                int a = in.nextInt(); // initial timer
                int b = in.nextInt(); // starting timer
                int n = in.nextInt(); // numbers of tolls
                // so now here
                long sum = 0;
                int[] tolls = new int[n];
                for (int i = 0; i < n; i++) {
                    tolls[i] = in.nextInt();
                    // so now here we have to change it to a max value if this is greater than that here
                    if(tolls[i] >= a){
                        tolls[i] = a-1;
                    }
                    // so now here make the sum
                    sum += tolls[i];
                }
                // so nwo here
                sum += b;
                out.println(sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
