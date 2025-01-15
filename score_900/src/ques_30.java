import java.io.*;
import java.util.StringTokenizer;

public class ques_30 {
//    https://codeforces.com/problemset/problem/1373/B
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
                String str = in.next();
                int count_one = 0;
                int count_zero = 0;
                for(char ch  : str.toCharArray()){
                    if(ch == '0'){
                        count_zero++;
                    }else{
                        count_one++;
                    }
                }
                // so now here we have to take the min in both
                int min = Math.min(count_one , count_zero);
                if(min%2 == 0){
                    out.println("NET");
                }else{
                    out.println("DA");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
