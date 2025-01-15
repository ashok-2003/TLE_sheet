import java.io.*;
import java.util.StringTokenizer;

public class ques_8 {
//    https://codeforces.com/problemset/problem/1837/B
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
                int n = in.nextInt();
                String str = in.next();
                // so now here we have to count here again
                int count = 1;
                int ans = 1;
                for(int i = 1; i < n; i++){
                    if(str.charAt(i-1) != str.charAt(i)){
                        count = 1;
                    }else{
                        count++;
                    }
                    ans = Math.max(ans , count);
                }
                // so now here we have to print the ans here
                out.println(ans+1);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
