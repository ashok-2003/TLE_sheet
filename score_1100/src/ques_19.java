import java.io.*;
import java.util.StringTokenizer;

public class ques_19 {
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
                int[] arr = new int[n];
                int total_negative = 0;
                long sum = 0;
                int min_value = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();

                    min_value = Math.min(min_value , Math.abs(arr[i])); // calculated the min value
                    sum += Math.abs(arr[i]);

                    if(arr[i] < 0){
                        total_negative++;
                    }
                }
                // if total_negative is odd then subtract the min element
                if(total_negative % 2 != 0){
                    out.println(sum - (2L *min_value));
                }else {
                    out.println(sum);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
