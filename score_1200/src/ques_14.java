import java.io.*;
import java.util.StringTokenizer;
// tip
// you can also do print all 4 grid and check the diff if you are not able to do the loop here
public class ques_14 {
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
                char[][] arr = new char[n][n];
                for (int i = 0; i < n; i++) {
                    String str = in.next();
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = str.charAt(j);
                    }
                }

                long ans = 0;
                /*
                for(int i = 0; i < n; i++){

                    for(int j = 0; j < n-i-1; j++){
                        int count_one = 0;
                        int count_zero = 0;
                        char first_index = arr[i][i+j];
                        char second_index = arr[i+j][n-i-1];
                        char third_index = arr[n-i-1][n-i-1-j];
                        char fourth_index = arr[n-i-1-j][i];

                        // so now calculate the type of index this are
                        if(first_index == '1'){
                            count_one++;
                        }else{
                            count_zero++;
                        }

                        if(second_index == '1'){
                            count_one++;
                        }else{
                            count_zero++;
                        }

                        if(third_index == '1'){
                            count_one++;
                        }else{
                            count_zero++;
                        }

                        if(fourth_index == '1'){
                            count_one++;
                        }else{
                            count_zero++;
                        }


                        // so now here checking

                        if(count_one == 4){
                            // do nothing
                        }else if (count_zero == 4){
                            // do nothing
                        }else{
                            ans += Math.min(count_one , count_zero);
                        }
                    }
                }

                 */

                for (int i = 0; i < n/2; i++) {
                    for (int j = 0; j < (n + 1) / 2; j++) {
                        int count_one = 0;
                        int count_zero = 0;
                        // Identify the four symmetric positions.
                        char a = arr[i][j];
                        char b = arr[j][n - 1 - i];
                        char c = arr[n - 1 - i][n - 1 - j];
                        char d = arr[n - 1 - j][i];

                        if(a == '1') count_one++; else count_zero++;
                        if(b == '1') count_one++; else count_zero++;
                        if(c == '1') count_one++; else count_zero++;
                        if(d == '1') count_one++; else count_zero++;

                        // If all are the same, no flip is needed.
                        ans += Math.min(count_one, count_zero);
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
