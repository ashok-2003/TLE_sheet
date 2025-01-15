import java.io.*;
import java.util.StringTokenizer;

public class ques_13 {
//    https://codeforces.com/problemset/problem/1696/B
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
                // so now here
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here atmost the answer will be 2 and if all 0 then 0 and otherwise we have 1 as the answer
                int i = 0;
                int j = n-1;
                while(i < n && arr[i] == 0){
                    i++;
                }
                while (j >= 0 && arr[j] == 0){
                    j--;
                }
                // so now here we have to check for the zero case
                if(i == n){
                    // so now it reach the other end so we have to get answer 0
                    out.println(0);
                    continue;
                }
                // so now here we have to check that if we have the zero in between for the seperation or not
                boolean inzerobetween = false;
                for(int k = i; k <= j; k++){
                    if(arr[k] == 0){
                        inzerobetween = true;
                    }
                }
                // so nwo here
                if(inzerobetween){
                    out.println(2);
                }else{
                    out.println(1);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
