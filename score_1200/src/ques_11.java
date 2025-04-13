import java.io.*;
import java.util.StringTokenizer;

public class ques_11 {
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
                String s = in.next();
                char[] str = s.toCharArray();
                // so now we can proceed to the next index only if we have used the lowest multiple
                int numberOfZero = 0;
                for (int i = 0; i < n; i++) {
                    if(str[i] == '0'){
                        numberOfZero++;
                    }
                }

                // so now here we have to count it
                // as we have the number till n so for that
                long ans = 0;
                for(int i = 1; i <= n; i++){
                    if(numberOfZero == 0){
                        break;
                    }
                    if(str[i-1] == '1'){
                        continue;
                    }
                    // so now otherwise  we can use the value here
                    int val = i;
                    while (val <= n){
                        if(str[val-1] == '0'){
                            ans += i;
                            str[val-1] = 's';
                            numberOfZero--;
                        }else if(str[val-1] == '1'){ // break it we can only continue for the s only
                            break;
                        }
                        val += i;
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
