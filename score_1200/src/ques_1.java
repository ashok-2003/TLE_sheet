import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ques_1 {
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
                // so nwo trying the brute force approach here
                int n = in.nextInt();
                int[][] arr1 = new int[n][2];
                int[][] arr2 = new int[n][2];
                int[][] arr3 = new int[n][2];
                for(int i = 0; i < n; i++){
                    arr1[i][0] = in.nextInt();
                    arr1[i][1] = i;
                }
                for(int i = 0; i < n; i++){
                    arr2[i][0] = in.nextInt();
                    arr2[i][1] = i;
                }
                for(int i = 0; i < n; i++){
                    arr3[i][0] = in.nextInt();
                    arr3[i][1] = i;
                }

                /*

                long sum = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            if(i != j && j != k && k != i){
                                long temp = arr1[i] + arr2[j] + arr3[k];
                                sum = Math.max(temp , sum);
                            }
                        }
                    }
                }

                out.println(sum);

                 */

                // this solution dose not work so we can do one thing we can sort the array and take the max3 element
                // in the each array and do the operation

                // sorting the all array here

                Arrays.sort(arr1 , (a , b) -> b[0]-a[0]);  // sorted in descending order
                Arrays.sort(arr2 , (a , b) -> b[0]-a[0]);
                Arrays.sort(arr3 , (a , b) -> b[0]-a[0]);

                // so nwo we have to take 3 elements so at max 27 combination can be formed
                long sum = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            if (arr1[i][1] != arr2[j][1] && arr2[j][1] != arr3[k][1] && arr3[k][1] != arr1[i][1]) {
                                sum = Math.max(sum, arr1[i][0] + arr2[j][0] + arr3[k][0]);
                            }
                        }
                    }
                }

                out.println(sum);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
