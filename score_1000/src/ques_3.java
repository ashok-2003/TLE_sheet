import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ques_3 {
//    https://codeforces.com/problemset/problem/1876/A
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
                int p = in.nextInt();

//                int[] dis = new int[n];
//                int[] val = new int[n];
//                for (int i = 0; i < n; i++) {
//                    dis[i] = in.nextInt();
//                }
//                for (int i = 0; i < n; i++) {
//                    val[i] = in.nextInt();
//                }
//                // so now here we have to get the min value and the index for that
//                long total = p;
//                n--;
//                while(n> 0){
//                    // so now here we have to get the min index here
//                    int ind = min(val);
//                    // so now here we have to
//                    int freq = dis[ind];
//                    int value = val[ind];
////                    System.out.println(freq + " " + value);
//                    // so now here we have to increase the value here
//                    if(n >= freq){
//                        total += (long) value * freq;
//                        n -= freq;
//                    }else{
//                        total += (long) value * n;
//                        n = 0;
//                    }
//                    val[ind] = Integer.MIN_VALUE;
//                }
//                // so now here
//                out.println(total);


                int[][] arr = new int[2][n];
                // input
                for (int i = 0; i < n; i++) {
                    arr[0][i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    arr[1][i] = in.nextInt();
                }
                int columns = arr[0].length;

                // Create an array of columns where each column is an int[] of size 2
                int[][] columnsArray = new int[columns][2];
                for (int i = 0; i < columns; i++) {
                    columnsArray[i][0] = arr[0][i];
                    columnsArray[i][1] = arr[1][i];
                }

                // Sort the columnsArray based on the second row
                Arrays.sort(columnsArray, (a, b) -> Integer.compare(a[1], b[1]));

                // Reconstruct the sorted array
                for (int i = 0; i < columns; i++) {
                    arr[0][i] = columnsArray[i][0];
                    arr[1][i] = columnsArray[i][1];
                }

//                for(int[] a : arr){
//                    System.out.println(Arrays.toString(a));
//                }

                // so now here my array has been sorted on the second index based here so now
                long total = p;
                n--;
                int i = 0;
                while (n >= 0){
                    if(n >= arr[0][i]){
                        total += arr[0][i] * arr[1][i];
                        n -= arr[0][i];
                        i++;
                    }else{
                        total += arr[1][i] * n;
                        n = 0;
                        i++;
                    }
                }
                // so now here
                out.println(total);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

}
