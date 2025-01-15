import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_5 {
//    https://codeforces.com/problemset/problem/1849/B
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
                // so now here we have to make the array
                int n = in.nextInt();
                int k = in.nextInt();
                // so now here we have to take input
                int[] arr = new int[n];

//                int[] freq = new int[k+1];

                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt() % k;
                    if(arr[i] == 0) arr[i] = k;

//                    freq[arr[i]]++;
                }
                // so now here we have count the whole of it so now here we have to make the prefix sum for this

//                for (int i = 1; i < k+1; i++) {
//                    freq[i] = freq[i] + freq[i-1];
//                }

                // so now here we have updated the frequency array so now
                Integer[] ans = new Integer[n];
                for(int i = n-1; i >= 0; i--){
                    ans[i] = i;
                }
                Arrays.sort(ans ,(a ,b)-> arr[b] - arr[a]);
                // sorted the array in decreasing order on the value of original array
                for(int i : ans){
                    System.out.print(i+1 + " ");
                }
                System.out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
