import java.io.*;
import java.util.StringTokenizer;

public class ques_6 {
//    https://codeforces.com/problemset/problem/1840/C
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
                int k = in.nextInt();
                int q = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                /*
                give tle
                int ans = 0;
                for(int i = 0; i < n; i++){
                    if(arr[i] <= q){
                        // so now here we have to get the lagatar value
                        int days = 0;
//                        if(days >= k){
//                            ans++;
//                        }
                        int j = i;
                        while (j < n && arr[j] <= q){
                            j++;
                            days++;
                            if(days >= k){
                                ans++;
                            }
                        }
                    }
                }
                out.println(ans);

                */
                // so now here we can write our code
                long ans = 0;
                int len = 0;

                for (int i = 0; i < n; i++) {
                    if (arr[i] <= q) {
                        len++;
                    } else {
                        if (len >= k) {
                            ans += (long) (len - k + 1) * (len - k + 2) / 2;
                        }
                        len = 0;
                    }
                }

                if (len >= k) {
                    ans += (long) (len - k + 1) * (len - k + 2) / 2;
                }
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
