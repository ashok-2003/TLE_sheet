import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ques_31 {
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
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }

                // so nwo here we will calculate the most significant  bit of every number and same should be grouped
                // together then
                Map<Integer , Integer> map = new HashMap<>();
                for(int i = 0; i < n; i++){
                    int val = mostSignificant(arr[i]);
                    map.put(val , map.getOrDefault(val , 0)+1);
                }

                long ans = 0;
                // so now getting the answer
                for(int i : map.values()){
                    ans += ((long) i * (i-1))/2;
                }

                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  int mostSignificant(long val){
        int count  = 0;
        while (val > 0){
            count++;
            val = val>>1;
        }
        return  count;
    }
}
