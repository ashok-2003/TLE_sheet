import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_13 {
//    https://codeforces.com/problemset/problem/1859/A
    // united we stand
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
                // so now here if will give the error in the only case when the all of the element are equals
                int len = in.nextInt();
                int[] arr = new int[len];
                for (int l = 0; l < len; l++) {
                    arr[l] = in.nextInt();
                }
                // so now here we have to sort the array here
                Arrays.sort(arr);
                // so now here we have to return in the two cases here
                if(arr[0] == arr[len-1]){
                    out.println(-1);
                }else{
                    // so now here we have to get the all of the common element from the back here
                    int count = 1;
                    while(arr[len-count-1] == arr[len-1]){
                        count++;
                    }
                    // so now here we have to get the output of the both here
                    out.println(len - count + " " + count);
                    // so now here we have to return in this here
                    for(int i = 0; i < len-count; i++){
                        out.print(arr[i]+" ");
                    }
                    out.println("");
                    for(int i = 0; i < count; i++){
                        out.print(arr[len-1]+ " ");
                    }
                    out.println("");

                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
