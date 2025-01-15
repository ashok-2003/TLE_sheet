import java.io.*;
import java.util.StringTokenizer;

public class ques_2 {
//    https://codeforces.com/problemset/problem/1883/C
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
                // as here notice that we have the value of k to 2 and 3 and 4 and 5 only
                int min = Integer.MAX_VALUE;
                int less1four = Integer.MAX_VALUE;
                int even = 0;
                for (int i = 0; i < n; i++) {
                    int temp = in.nextInt();
                    if(temp == 3 || temp == 7){
                        less1four = 1;
                    }
                    if(temp % 2 == 0){
                        even++;
                    }
                    int val = temp % k;
                    if (val == 0) {
                        min = 0;
                    }
                    min = Math.min(min, k - val);
                }
                if(k != 4){
                    out.println(min);
                }else{
                    even = (even >= 2) ? 0 : 2-even;
                    // so now here we have to compare the all three here
//                    out.println(less1four + " " + even + " " + min);
                    min = Math.min(less1four , Math.min(even , min));
                    out.println(min);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
