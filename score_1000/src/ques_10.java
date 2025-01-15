import java.io.*;
import java.util.StringTokenizer;

public class ques_10 {
//    https://codeforces.com/problemset/problem/1744/C
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
                // so first of all calculate the value of first green
                int n = in.nextInt();
                char start = in.next().charAt(0);
                // so now here is the string
                String s = in.next();

                // base case
                if(n == 1 || start == 'g'){
                    out.println(0);
                    continue;
                }
                /*
                int first_green = 0;
                for(int i = 0; i < n; i++){
                    if(s.charAt(i) == 'g' || s.charAt(i) == start){
                        first_green = i;
                        break;
                    }
                }
                // so now here we have get the first green here
                int last_green = n-1;
                for(int i = n-1; i >= 0; i--){
                    if(s.charAt(i) == 'g' || s.charAt(i) == start){
                        last_green = i;
                        break;
                    }
                }
                // so now here
                int max = (n-1)- last_green + (first_green);
                // so now here we have the max this is we have to print here

                 */
                int max = 0;
                s = s+s;
                // so now here we have just add the string again here
                for(int i = 0; i < 2*n; i++){
                    if(s.charAt(i) == start){
                        // so now here we have to get the next value of green from that point
                        int temp = i+1;
                        while (temp < 2*n && s.charAt(temp) != 'g'){
                            temp++;
                        }
                        max = Math.max(max , temp - i);
                        i = temp; // for reducing the number of steps here

                    }
                }
                out.println(max);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
