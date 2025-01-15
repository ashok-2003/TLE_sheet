import java.io.*;
import java.util.StringTokenizer;

public class ques_25 {
//    https://codeforces.com/problemset/problem/1791/C
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
                // so now here we have taken the length here
                int len = in.nextInt();
                String str = in.next();  // we can't take the input as the array here
                int i = 0;
                int j = len-1;
                while(i <= j){
                    if(str.charAt(i) == '1' && str.charAt(j) == '0'){
                        i++;
                        j--;
                    }else if(str.charAt(i) == '0' && str.charAt(j) == '1'){
                        i++;
                        j--;
                    }else {
                        break;
                    }
                }
                // so now here we have to print the answer
                int ans = j- i + 1;
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
