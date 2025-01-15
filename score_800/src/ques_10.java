import java.io.*;
import java.util.StringTokenizer;

public class ques_10 {
//    https://codeforces.com/problemset/problem/1873/C
    // target practice
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
                // so now here we have to make the array of the character here
                // or as here we have to take the input here so now
                String[] arr = new String[10];
                // so now here we have to get the all index here
                for(int i = 0; i < 10; i++){
                    arr[i] = in.next();
                }
                // so now here we have got the integer here so now here we have to
                // so now here we have to add to hardcode this here
                int[][] nums = {
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,1},
                        {1,2,3,3,3,3,3,3,2,1},
                        {1,2,3,4,4,4,4,3,2,1},
                        {1,2,3,4,5,5,4,3,2,1},
                        {1,2,3,4,5,5,4,3,2,1},
                        {1,2,3,4,4,4,4,3,2,1},
                        {1,2,3,3,3,3,3,3,2,1},
                        {1,2,2,2,2,2,2,2,2,1},
                        {1,1,1,1,1,1,1,1,1,1}
                };
                // so now here we have hard coded it so now here
                int sum = 0;
                for(int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++) {
                        // so now here we have to get the integer here
                        if(arr[i].charAt(j) == 'X'){
                            // so now here we have to add it
                            sum += nums[i][j];
                        }
                    }
                }
                // so now here we have to add this
                out.println(sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
