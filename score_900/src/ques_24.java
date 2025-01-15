import java.io.*;
import java.util.StringTokenizer;

public class ques_24 {
//    https://codeforces.com/problemset/problem/1543/A
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
                // so now here
                if(a == b){
                    out.println(0+" "+0);
                    continue;
                }
                if(a-b == 1 || b-a == 1){
                    out.println(1+ " "+ 0);
                    continue;
                }
                // so now here we have to use the property of gcd which
                long gcd = Math.abs(a-b);
                // so now here we have to get the min of both step here
                long step = Math.min(a% gcd , gcd - a % gcd);
                // so this because let suppose the case of
                // 3 and 6 so diff = 3 so now     3 % 3 = 0 and 3 - 0 = 0 so the min  if we do with the 9 we will get
                // the same result this is the basic property of gcd here

                // so now print it
                out.println(gcd + " " + step);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
