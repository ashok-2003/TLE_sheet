import java.io.*;
import java.util.StringTokenizer;

public class ques_31 {
//    https://codeforces.com/problemset/problem/1374/B
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
                int count_two = 0;
                int count_three = 0;
                boolean other_prime = false;
                while (n != 1){
                    if(n%2 == 0){
                        count_two++;
                        n = n/2;
                    }else if (n % 3 == 0){
                        count_three++;
                        n = n/3;
                    }else{
                        other_prime = true;
                        break;
                    }
                }
                // so now here
                if(other_prime){
                    out.println(-1);
                    continue;
                }
                // so now here in the other case
                if(count_two > count_three){
                    out.println(-1);
                    continue;
                }
                out.println(count_three+(count_three-count_two));
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
