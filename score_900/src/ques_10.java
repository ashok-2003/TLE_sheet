import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_10 {
//    https://codeforces.com/problemset/problem/1807/D
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
                // so now here we have to take the input here
                int n = in.nextInt();
                int q = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here we have to get the pefix sum and suffix sum here
                int[] prefix = Arrays.copyOf(arr , n);
                int[] suffix = Arrays.copyOf(arr , n);
                for(int i=1, j=n-2; i<n && j>=0; i++,j--){
                    prefix[i] += prefix[i-1];
                    suffix[j] += suffix[j+1];
                }
                // so now here we have taken the total input so now here we have to print for the all of the cases here
                while (q-- > 0){
                    int l = in.nextInt();
                    int r = in.nextInt();
                    int k = in.nextInt();

                    int total = prefix[l-1] - arr[l-1];
                    total += suffix[r-1] - arr[r-1];
                    total += (r - l +1) * k;

                    if(total % 2 == 0){
                        out.println("no");
                    }else{
                        out.println("yes");
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
