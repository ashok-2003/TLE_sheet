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
                long a = in.nextLong();
                long b = in.nextLong();
                // so now here check all of these
                if(b > a){
                    long temp = a;
                    a = b;
                    b = temp;
                }
//                // so now checking it
//                if(a % b != 0){
//                    out.println(-1);
//                    continue;
//                }
//                // so now here
//                long divide = a/b;
//                double pow_of_two = Math.log10(divide)/Math.log10(2);
//                if(pow_of_two % 1 != 0){
//                    out.println(-1);
//                    continue;
//                }
//                // so now here
//                int total_step = 0;
//                while (pow_of_two != 0){
//                    if(pow_of_two >= 3){
//                        total_step++;
//                        pow_of_two -= 3;
//                    }else if(pow_of_two >= 2){
//                        total_step++;
//                        pow_of_two -= 2;
//                    }else{
//                        total_step++;
//                        pow_of_two--;
//                    }
//                }
//                out.println(total_step);

                // so now here
                int ans = 0;
                while (a >= b){
                    if(b*8 <= a){
                        b *= 8;
                        ans++;
                    }else if (b*4 <= a){
                        b *= 4;
                        ans++;
                    }else if (b*2 <= a){
                        b *= 2;
                        ans++;
                    }else{
                        break;
                    }
                }
                if(a == b){
                    out.println(ans);
                }else{
                    out.println(-1);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
