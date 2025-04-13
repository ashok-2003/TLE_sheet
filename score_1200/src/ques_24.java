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
                int n = in.nextInt();
                String str = in.next();
                int numberOfZero = 0;
                for(char ch : str.toCharArray()){
                    if (ch == '0'){
                        numberOfZero++;
                    }
                }

                // so now if the zeros are odd then zero is remaining in the middle part

                if(numberOfZero == 1){
                    out.println("BOB");
                    continue;
                }

                // so now when the number of zeros are odd the alice can make the first in the middle
                // so the array remain the palindrome so their role is reverse now
                if(numberOfZero % 2 == 1){

                    // alice will always win in this case
                    out.println("ALICE");
                    continue;
                }

                // otherwise bob will always win
                // why bob win in the case of even zero
                /*
                take the example of this   0000   0000
                so now when alice move to 1 then bob mirror it to one to make the string still palindrome
                so now it will do till teh 3 times so now when fourth time
                alice move 0 to one  now bob will choose to reverse the array costing it zero so now
                alice again have to make it to one  so bob will win


                similar thing alice can do if the zeros are odd so he will choose the first in the middle
                then can do same thing that bob did as win by 1 as in last bob will do 2 steps
                 */
                out.println("BOB");
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
