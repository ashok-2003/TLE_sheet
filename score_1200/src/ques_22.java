import java.io.*;
import java.util.*;

public class ques_22 {
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
            int n = in.nextInt();
            long k = in.nextLong();  // values you can add here
            long x = in.nextLong();  // maximum allowed Difference

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            Arrays.sort(arr);

            // so nwo here we have to store the values which are greater than x here

            List<Long> list = new ArrayList<>();
            for(int i = 1; i < n; i++){
                if(arr[i] - arr[i-1] > x){
                    list.add(arr[i] - arr[i-1]);
                }
            }

            // so now here all the values are added now
            Collections.sort(list);
            int dividedArr = list.size()+1;  // as list should have 2

            for(long val : list){
                // so now checking if we able to minimize the partition
                long needed = (val - 1) / x;
                if (needed <= k) {
                    dividedArr--;
                    k -= needed;
                }
            }

            out.println(dividedArr);


            // so now list has been sorted


            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
