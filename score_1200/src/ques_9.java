import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ques_9 {
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
                int[] arr = new int[n];
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();

                    if(!map.containsKey(arr[i])){
                       map.put(arr[i] , 1);
                    }else{
                        int val = map.get(arr[i]);
                        val += 1;
                        map.put(arr[i] , val);
                    }
                }
                int ans = 0;
                Arrays.sort(arr);
                int last = 0;
                for (int i = 0; i < n; i++) {
                    int val = arr[i];
                    if(val == last){
                        continue;
                    }

                    // so now otherwise check the max for the ans
                    ans = Math.max(ans , map.get(val)); // making the frequency to the max

                    // so now for the case  where the array is not continious then for that
                    if(last != 0 && last+1 != val){
                        ans += Math.abs(map.get(last) - map.get(val))+1;
                    }

                    last = val;
                }

                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
