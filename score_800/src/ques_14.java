import java.io.*;
import java.util.StringTokenizer;

public class ques_14 {
//    https://codeforces.com/problemset/problem/1858/A
    // buttons
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
               // so now here the algo we can use that first we will use the buttons of the c that is either
                // of the anna or tate can press it
                // then if it is odd then it will end with the anna here so now in the specified button
                // if anna have greater or equal button then anna wins otherwise tate wins
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                // so now here checking on the c first of all
                if(c % 2 != 0){
                    // so it means c is odd so now here
                    if(a >= b){
                        out.println("First");
                    }else{
                        out.println("Second");
                    }
                }else{
                    // so now here
                    if(b >= a){
                        out.println("Second");
                    }else{
                        out.println("First");
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
