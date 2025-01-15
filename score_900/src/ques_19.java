import java.io.*;
import java.util.StringTokenizer;

public class ques_19 {
//    https://codeforces.com/problemset/problem/1607/B
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
                // so now here we have two int
                long start = in.nextLong();
                long end = in.nextLong();
                long d = 0;
                if(end % 4 == 0){
                    d = 0;
                }else if(end % 4 == 1){
                    d =  -(end);
                }else if (end % 4 == 2){
                    d = 1;
                }else if (end % 4 == 3){
                    d = (end +1);
                }
                if(start % 2 == 0){
                    out.println(start+d);
                }else{
                    out.println(start-d);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
/*
−n
 if n≡1mod4
1
 if n≡2mod4
n+1
 if n≡3mod4
0
 if n
 is divisible by 4

 */
