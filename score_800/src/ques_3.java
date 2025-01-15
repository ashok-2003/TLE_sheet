import java.io.*;
import java.util.StringTokenizer;

public class ques_3 {
//    https://codeforces.com/problemset/problem/1900/A
    // cover in water
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
                // read the question carefully we only need to find minimum number of action one here
                // so now when ever if we encounter the . of length 3 then we only need 2 times the action one
                // as we can empty the middle box then we can get unlimited supply chain here
                int n = in.nextInt();
                String str = in.next();
                // so now just check for the substring of "..." only
                String s = "...";
                if(str.contains(s)){
                    out.println(2);
                    continue;
                }
                // so now here we have to only count the number of dots we require that many boxes here
                int ans = 0;
                for(int i = 0; i < n; i++){
                    if(str.charAt(i) == '.'){
                        ans++;
                    }
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
