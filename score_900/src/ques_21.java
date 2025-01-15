import java.io.*;
import java.util.StringTokenizer;

public class ques_21 {
//    https://codeforces.com/problemset/problem/1593/B
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
                // so now here
                long n = in.nextLong();
                // so nwo here we have to change this into the string here
                if(n % 25 == 0){
                    out.println(0);
                    continue;
                }
                String sb = String.valueOf(n);
                // so now here we have fit the string in this so now here
                // so for checking the divisible by two we have to check if last two digit are divisible by 25 or not


                // so now we have to try to make the last two digit either 00 25 75 50

                // so now here for that
                String[] str = {"00" , "25" , "50" , "75"};

                // so now here
                int ans = Integer.MAX_VALUE;

                for(String s : str){
                    int min = solve(sb , s);
                    ans = Math.min(ans , min);
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int solve(String sb , String tar){
        // so now here taking the both index here
        int x = tar.charAt(0);
        int y = tar.charAt(1);

        // so now here we have to first get the value for the y then for the x here
        int step = 0;
        int j = sb.length()-1;
        while (j >= 0 && sb.charAt(j) != y){
            j--;
            step++;
        }

        // so now here we have to search for the x here
        j--; // decreasing one index here
        while(j >= 0 && sb.charAt(j) != x){
            j--;
            step++;
        }
        // so now here we have to return the step
        return step;
    }

}
