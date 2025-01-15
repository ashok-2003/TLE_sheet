import java.io.*;
import java.util.StringTokenizer;

public class ques_2 {
//    https://codeforces.com/problemset/problem/1901/A
    // a line trip question
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
                // so now here is the code so now as we done the tescase here
                // so now here we have to take the input of the every number here
                int n = in.nextInt();;
                int x = in.nextInt();
                // so now taking the distance in the array here
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here we have taken the all of  the element here and we have  taken the all of the distance
                // here so now here we have to take the max of gap between the two here
                int dis = 0;
                // so now here in teh array
                for(int i = 1; i < n; i++){
                    dis = Math.max(dis , arr[i] - arr[i-1]);
                }
                // so now here at the last we have to take the difference between the that x distance and the last
                // index of it here
                int last = 2*(x - arr[arr.length-1]);
                // so now here we have to agian the take the max distance here
                dis = Math.max(dis , last);
                // so now priting the list here
                // but wait before that we have to just make the differnce betwenn the first index also here so
                last = arr[0] - 0;
                dis = Math.max(last , dis);
                out.println(dis);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
