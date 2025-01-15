import java.io.*;
import java.util.StringTokenizer;

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
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int a = in.nextInt();
                int b = in.nextInt();
                int ans = (int)1e18;
                int count = 0;
                // going till square root as after that no benefits as the step will be same for increasing the
                // number their and if the number is already greater than that it will get caught in the i = 0 their
                for(int i = 0; i*i <= a; i++){
                    // so the case for
                    if(b == 1 && i == 0){
                        continue;
                    }
                    // setting count to the i
                    count = i;
                    int temp = a;
                    while (temp > 0){
                        temp = temp/(b+i);
                        count++;
                    }
                    ans = Math.min(ans , count);
                }
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
