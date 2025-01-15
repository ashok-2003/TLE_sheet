import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1831/B

public class ques_7 {
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
                int[] arr = new int[n];
                int[] arr2 = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    arr2[i] = in.nextInt();
                }
                // so now here we can merge the both array but the thing is as we just cannot sort it
                // we can take elements in any of the order we want
                // so now here is the frequency of both here
                int[] fa = frequency(arr);
                int[] fb = frequency(arr2);
                // so now here we have to update the both
                // so both are updated so now here we have to get the max in both of the array
                int sum = 0;
                for(int i = 0; i < 2 * (n+1); i++){
                    sum = Math.max(sum , fa[i] + fb[i]);
                }
                out.println(sum);


            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int[] frequency(int[] arr){
        // so now here
        int n = arr.length;
        int[] f = new int[2*(n+1)];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n){
            while (j < n && arr[i] == arr[j]){
                j++;
                count++;
            }
            f[arr[i]] = Math.max(count , f[arr[i]]);
            i = j; // updating the value
            count = 0;
        }
        return f;
    }
}
