import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_28 {
//    https://codeforces.com/problemset/problem/1783/A
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
                for(int i = 0; i < len; i++){
                    arr[i] = in.nextInt();
                }
                // so now here sorting the array
                Arrays.sort(arr);
                if(arr[0] == arr[len-1]){
                    out.println("no");
                    continue;
                }
                // so interchange the first and last index here
                int temp = arr[0];
                arr[0] = arr[len-1];
                arr[len-1] = temp;
                // so now here print yes and print the element
                // so now here for the case of 3 it is failing here
                if(arr[0] == arr[1]){
                    // so we have to interchange here
                    int te = arr[1];
                    arr[1] = arr[len-1];
                    arr[len-1] = te;
                }
                out.println("yes");
                for(int i : arr){
                    out.print(i + " ");
                }
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
