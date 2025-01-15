import java.io.*;
import java.util.StringTokenizer;

public class ques_14 {
//    https://codeforces.com/problemset/problem/1679/A
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
                long n = in.nextLong();
                // so now here we have taken the input in the long
                if(n % 2 == 1 || n < 4){
                    out.println(-1);
                    continue;
                }
                // so now here we have to check for the max and min
                long min = 0;
                long max = 0;
                // so now here we have to get the both
                min = n / 6;
                max = n / 4;
                // so now here we have to check for the remainder thing here
                if(n % 6 == 2){
                    // so now here we have to add 1 in the min overall here
                    min += 1;
                }else if (n % 6 == 4){
                    min += 1;
                }
//                if(n % 4 == 2){
//                    max -= 1; // we have to substract the one here
//                }
                // so now here we have to print the both here
                out.println(min + " " + max);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
