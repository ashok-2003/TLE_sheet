import java.io.*;
import java.util.StringTokenizer;

public class ques_21 {
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
                String a = in.next();
                String b = in.next();
                int n = a.length();
                int m = b.length();
                int ans = 0;
                // compare each substring of it
                for (int len = 1; len <= Math.min(n, m); len++) {
                    for (int i = 0; i + len <= n; i++) {
                        for (int j = 0; j + len <= m; j++) {
                            if (a.substring(i, i + len).equals(b.substring(j, j + len))) {
                                ans = Math.max(ans, len);
                            }
                        }
                    }
                }

                out.println((n + m) - 2 * ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
