import java.io.*;
import java.util.StringTokenizer;

public class ques_29 {
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
                long n = in.nextLong();
                long k = in.nextLong();
                k--; // subtracting this for making the modulo works

                // as we can observe that in even no collapse is their
                // but in the odd every n/2 it collapses  so making the b to move one extra
                // so for the even case
                if((n& 1) == 0){
                    out.println(((k)%n)+1);
                }else{
                    // so for odd it changes every n/2 times so now
                    long half = n/2;
                    // so now effective index will be
                    k += ((k)/half);

                    // so now for counting now it will be
                    out.println((k%n)+1);
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
