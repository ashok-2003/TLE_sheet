import java.io.*;
import java.util.StringTokenizer;

public class ques_10_1 {
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
                // so the thing is for the number when doing xor can only be x if it's zero bit dose not changes
                // with the number applying the value as
                // 0 | 1 = 1
                // 1 | 1 = 1

                // so now here we can check each of stack separately if it is possible to make the x
                int n = in.nextInt();
                int x = in.nextInt();

                // so now three stack have n books  so getting all of them one by one
                int s = 0; // this store my initial value

                for(int j = 0; j < 3; j++){
                    int[] arr = new int[n];
                    for (int i = 0; i <n; i++) {
                        arr[i] = in.nextInt();
                    }

                    // so now here it has stack so it can only proceed by applying the top value first

                    for (int i = 0; i < n; i++) {
                        if((x | arr[i]) != x){
                            break;
                        }
                        // otherwise it is safe to update the value in the s doesn't  matter whether it will affect or not
                        s = (s | arr[i]);
                    }
                }

                // so now  if at the last in s = temp then we can print the true

                out.println( (s == x) ? "Yes" : "No" );

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
