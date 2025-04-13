import java.io.*;
import java.util.*;

public class ques_30 {
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
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }
                Map<Long ,Integer> map = new HashMap<>();
                for(int i = 0; i < n; i++){
                    map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
                }
                int min = Integer.MAX_VALUE;
                long val = -1;
                // so now checking which have how may size
                for(long i : arr){
                    int temp = map.get(i);
                    if(temp < min){
                        min = temp;
                        val = i;
                    }
                }
                if(min == n){
                    out.println("NO");
                    continue;
                }

                // we can print in other case

                // so nwo here we will connect all the point to the val here
                List<Integer> list = new ArrayList<>();
                // so it will store the all the index occurring of the min
                for(int i = 0; i < n; i++){
                    if(arr[i] == val){ // comparing to the min value that i have
                        list.add(i);
                    }
                }
                // we can print the answer
                out.println("YES");

                int firstIndex = list.get(0);
                for(int i = 0; i < n; i++){
                    if(arr[i] == arr[firstIndex]){
                        continue;
                    }
                    out.println((firstIndex+1) + " " + (i+1));
                }
                // so now we have to get the last different index from the last to print the remaining element
                int lastIndex = n-1;
                while (lastIndex > 0 && arr[lastIndex] == val){
                    lastIndex--;
                }
                // so nwo for remaining pair print this
                for(int i = 1; i < list.size(); i++){
                    int curr = list.get(i);
                    out.println(curr+1 + " " + (lastIndex+1));
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
