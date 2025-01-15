import java.io.*;
import java.util.StringTokenizer;

public class ques_15 {
//    https://codeforces.com/problemset/problem/1857/A
    // Array coloring
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
                // so now here in this program here as we can see that if the if have odd number in the even
                // amount the we can say that it can be make then sum even otherwise not
                int len = in.nextInt();
                int oddcount = 0;
                for(int i = 0; i < len; i++){
                    int temp = in.nextInt();
                    if(temp % 2 != 0){
                        // so its odd so counting it
                        oddcount++;
                    }
                }
                // so now here after that
                if(oddcount % 2 == 0){
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
