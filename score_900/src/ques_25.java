import java.io.*;
import java.util.StringTokenizer;

public class ques_25 {
//    https://codeforces.com/problemset/problem/1537/B
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
                // so now in this question you are being a silly so now here don't always except that you will
                // have to think harder sometimes go with natural
                // ans when we have multiple answer then never just see the codeforces answer that time that's the
                // most silly thing you can do just think your own answer that time and now one thing also

                // so now here to maximize the distance those all should be placed on corner and most likey the
                // opposite corner so why think so much

                long n = in.nextLong();
                long m = in.nextLong();
                long i = in.nextLong();
                long j = in.nextLong();
                // so now here
                out.println(1+" "+1 +" " + n + " "+ m);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
