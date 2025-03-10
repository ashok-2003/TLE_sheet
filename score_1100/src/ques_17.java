import java.io.*;
import java.util.StringTokenizer;

public class ques_17 {
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
                int k = in.nextInt();
                int[][] arr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = in.nextInt();
                    }
                }
                // so now after all of this we can check the array upside down to match the same value both up and down

                if(n == 1){
                    out.println("YES"); // always true for one
                    continue;
                }

                long changes = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(arr[i][j] != arr[n-i-1][n-j-1]){
                            changes++;
                        }
                    }
                }
                changes = changes/2; // this because as the changes are counted twice
                // so now what if we have remaining k then it should be even so that it will not affect the symmetry
                // so now if n is even then it will affect this thing if the n is odd then we can do as much
                // operation we want at it's center then in case of odd it is not an issue
                if(n% 2 != 0){
                    out.println((k-changes) >= 0 ? "YES" : "NO");
                }else{
                    // so nwo here we have to check both
                    if((k-changes) >= 0 && (k-changes) % 2 == 0){
                        out.println("YES");
                    }else{
                        out.println("NO");
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
