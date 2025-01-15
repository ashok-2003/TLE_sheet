import java.io.*;
import java.util.StringTokenizer;

public class ques_23 {
//    https://codeforces.com/problemset/problem/1806/A
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
                // so now here is the code so now as we done the tescase here
                int ax = in.nextInt();
                int ay = in.nextInt();
                int bx = in.nextInt();
                int by = in.nextInt();
                // so now here we can just go the increase in the y here
                if(by < ay){
                    out.println(-1);
                    continue;
                }
                // so now otherwise here
                int count = 0;
                //so now first of all reach to the y here so now
                count = by - ay;
                // so now here we have updated the value of count here
                // so now increasing the ax value to that time here
                ax += count;
                // so now here if we get the bx still greater than the ax then we just cannot reach their
                if(bx > ax){
                    out.println(-1);
                    continue;
                }
                // so now if bx is now smaller than the  ax so we have to get that much step backward here
                count += (ax - bx);
                // so now printing the count
                out.println(count);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
