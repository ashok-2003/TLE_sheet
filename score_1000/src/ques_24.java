import java.io.*;
import java.util.StringTokenizer;

public class ques_24 {
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
                // in the input we have to check if the negative number is odd or even and the absolute min number and
                // we can also calculate the sum in this operation only with absolute value
                int negative_count = 0;
                int min = 200;
                int sum = 0;


                int n = in.nextInt();
                int m = in.nextInt();
                int[][] arr = new int[n][m];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        arr[i][j] = in.nextInt(); // value updated


                        if(arr[i][j] < 0){
                            negative_count++; // increasing the negative count
                            int abst = Math.abs(arr[i][j]);
                            min = Math.min(min , abst); // updating the min value
                            sum += abst; // adding the sum
                        }else{
                            min = Math.min(min , arr[i][j]); // updating the min value
                            sum += arr[i][j]; // updating the sum
                        }

                    }
                }
                // input taken

                // so now if it is negative is odd  the in the array it will have one element left always
                // so subtracting the min value always


                if(negative_count % 2 != 0){
                    sum -= 2*min; // as we have already added the min value
                }
                out.println(sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
