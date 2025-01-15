import java.io.*;
import java.util.StringTokenizer;

public class ques_16 {
//    https://codeforces.com/problemset/problem/1853/A
    // d - sorting
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
                // so now here if array is already not sorted then we should return the zero otherwise
                // we can do like we can calculate the point where the difference is minimal then at as at that
                // point we can apply the operation so now it will be get reduced in the case of divided by two
                int min  = Integer.MAX_VALUE;
                boolean is_sorted = true;
                int len = in.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    // so now here storing the values
                    arr[i] = in.nextInt();
                    // so now here we have to check also here
                    if(i > 0){
                        if(arr[i] < arr[i-1]){
                            // so now it means it is not sorted here
                            is_sorted = false;
                        }
                        // so nwo here we have to update the min value here
                        min = Math.min(min , arr[i] - arr[i-1]);
                    }
                }
                // so now here we have to check first of all if the array is sorted or not
                if(is_sorted == false){
                    out.println(0);
                }else{
                    // so now here we have got the min so we have to print the min here
                    out.println((min/2)+1);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
