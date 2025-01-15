import java.io.*;
import java.util.StringTokenizer;

public class ques_20 {
//    https://codeforces.com/problemset/problem/1606/A
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
                // so now here we observe that if the string end with a and a or with b and b then
                // it will have same number of a and b
                // or if the string end with a and b different so to make it same we can change it to aa or bb

                String str = in.next();
                // so nwo here
                int len = str.length();
                StringBuilder sb = new StringBuilder();
                if(str.charAt(0) == str.charAt(len-1)){
                    out.println(str);
                }else{
                    sb.append(str.charAt(len-1));
                    sb.append(str.substring(1,len));
                    out.println(sb.toString());
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
