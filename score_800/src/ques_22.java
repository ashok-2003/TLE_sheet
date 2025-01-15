import java.io.*;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1814/A
// coins
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
                // so now here we have to make the n using the ruppes of k coin or the 2 ruppes coin here
                long n = in.nextLong(); // as it exceed the int here 
                long k = in.nextLong();
                // so now here
//                if(n % 2 == 0 || n % 2 == k || n % k == 0 || n % k == 2){
//                    out.println("Yes");
//                }else{
//                    out.println("NO");
//                }
                // so now this solution give us the wrong answer in the case of 7 and 3 here so now
                boolean found = false;
                for(int i = 0; i < 10; i ++){
                    // so now here
                    if((n - i * k) >= 0 && (n-i*k)% 2 == 0){
                        out.println("yes");
                        found = true;
                        break;
                    }
                }
                if(!found){
                    out.println("no");
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
