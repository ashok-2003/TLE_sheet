import java.io.*;
import java.util.StringTokenizer;

public class ques_3 {
//    https://codeforces.com/problemset/problem/1878/C
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
                long x = in.nextLong();
                // so first of all get the sum of starting k natural number here
                long firstKNaturalNumber = ((long) k * (k+1))/2;
                // so now here get the last k natural number sum from the x here so for it n should be greater than k
                if(n < k){
                    out.println("no");
                    continue;
                }
                // so that was the basic check here
                long lastKNaturalNumber = ((long) n * (n+1)/2) - ((long) (n - k) * (n-k+1))/2;
                // so now if x lies in this then it can be yes
                if(x >= firstKNaturalNumber && x <= lastKNaturalNumber){
                    out.println("yes");
                }else{
                    out.println("no");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
