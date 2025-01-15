import java.io.*;
import java.util.StringTokenizer;

public class   ques_27 {
//    https://codeforces.com/problemset/problem/1471/A
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
                // so now here we have the simple principle
//                Note that, ⌈a+bx⌉≤⌈ax⌉+⌈bx⌉
                // so now here we have already the max value
                int n = in.nextInt();
                int x = in.nextInt();
                long total_sum = 0;
                long sum = 0;
                for(int i = 0;i < n; i++){
                    // so now here
                    long temp = in.nextInt();
                    total_sum += temp;
                    sum += div(temp , x);
                }
                // so now here
                total_sum = div(total_sum , x);
                // so now here we have to print both here
                out.println(total_sum + " " + sum);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static long div(long val , long divisor){
        if(val % divisor == 0){
            return val / divisor;
        }else{
            return  (val/divisor)+1;
        }
    }
}
