import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_17 {
//    https://codeforces.com/problemset/problem/1665/B
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
                int len = in.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = in.nextInt();
                }
                if(len == 1){
                    out.println(0);
                    continue;
                }
                Arrays.sort(arr);

                // so now get the biggest part of the array which we have the same value here
                int count = 1;
                int temp = 1;
                for(int i = 1; i < len; i++){
                    if(arr[i] != arr[i-1]){
                        temp = 1;
                    }else{
                        temp++;
                        count = Math.max(count , temp);
                    }
                }

                int ans = 0;
                while (count < len){
                    ans++; // clone
                    if(len - count >= count){
                        ans += count;
                        count *= 2;
                    }else{
                        ans += len - count;
                        count = len; // so as all element became the same
                    }
                }
                out.println(ans);


            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
