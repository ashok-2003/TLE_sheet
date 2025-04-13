import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ques_2 {
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

                // it will always work for the power of 2 because see the bits of number you will realize it
                long ans = 0;
                for(int i = 1; i <= 60; i++){
                    long evenMod = 1L << i;

                    // so nwo here using two set
                    Set<Long> evenSet = new HashSet<>();

                    for(int j = 0; j < n; j++){
                        evenSet.add(arr[j] % evenMod);
                    }

                    if(evenSet.size() == 2){
                        ans = evenMod;
                        break;
                    }
                }

                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
