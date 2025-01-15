import java.io.*;
import java.util.StringTokenizer;

public class ques_26 {
//    https://codeforces.com/problemset/problem/1789/A
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
                // so now here we have to take the array here
                int len = in.nextInt();
                int[] arr = new int[len];
                for(int i = 0; i < len; i++){
                    arr[i] = in.nextInt();
                }
                // si now here we have take the input now
                // we can  arrange to make it good and beautiful array  so if we find any two numbers having the
                // gcd of 2 then we can just make it good array as we can arrange such that for each of the length
                // we ge the gcd to less than that as
                // less than 3 because for the length 2 of the array gcd 2 will be the good thing their

                boolean ans = false;
                for(int i = 0; i < len; i++){
                    for(int j = i+1; j < len; j++){
                        if(gcd(arr[i] , arr[j]) <= 2){
                            ans = true;
                            break;
                        }
                    }
                }

                if(ans){
                    out.println("yes");
                }else{
                    out.println("no");
                }


            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int gcd(int a , int b){
        // so now here we have the two ways to check for the gcd so we can run the loop till n but that will take the
        // time of 0(n)
        while(a > 0 && b > 0){
            // so now here
            if(a > b){
                a = a % b;
            }else {
                b = b % a;
            }
        }
        // so now here any one of the following will become zero
        if(a == 0){
            return b;
        }else {
            return a;
        }
        // this is knows as the eculadien algorithim
    }
}
