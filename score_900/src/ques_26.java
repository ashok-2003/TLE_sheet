import java.io.*;
import java.util.StringTokenizer;

public class ques_26 {
//    https://codeforces.com/problemset/problem/1475/A
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
                // so now if number is prime then it will be not even so it divide itself so it have odd divisor
                // so here





//                if(n == 2){
//                    out.println("no");
//                    continue;
//                }
//                if(n % 2 == 1 && n > 1){
//                    out.println("yes");
//                    continue;
//                }
//                // so now here we have to check if the number is power of 2 then it is not
//                // so now here we have to check if this contain the power of 2 here
//                double val = Math.log(n)/Math.log(2);
//                // so now here if we got the nothing here
//                if(val % 1 == 0){
//                    out.println("no");
//                }
//                else{
//                    out.println("yes");
//                }




                // so now inspite of using the math log we can use the bitwise operator

                if((n & (n-1))== 0){
                    out.println("no");
                }else{
                    out.println("yes");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
