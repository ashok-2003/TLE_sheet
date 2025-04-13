import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_21_1 {
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
                int[][] arr = new int[n][2];
                for(int i = 0; i < n; i++){
                    arr[i][0] = in.nextInt();
                    arr[i][1] = i+1;
                }

                Arrays.sort(arr , (a , b) -> a[0]-b[0]);

                // so now the array is sorted
                int total = 0;
                for(int i = 0; i < n-1; i++){
                    for(int j = i+1; j < n; j++){
                        if ((long)arr[i][0] * arr[j][0] > 2L * n) {
                            break;
                        }


                        // so now in other case here
                        if ((long)arr[i][0] * arr[j][0] == arr[i][1] + arr[j][1]) {
                            total++;
                        }

                    }
                }

                out.println(total);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
