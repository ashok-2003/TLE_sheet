import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ques_25 {
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
                for (int i = 0; i < n; i++) {
                    arr[i]  = in.nextInt();
                }
/*
                int goodPosition = 0;
                for(int i = 0; i < n; i++){
                    if(arr[i] == (i+1)){
                        goodPosition++;
                    }
                }

                // so now
                if(goodPosition < 2){
                    out.println(0);
                }else if (goodPosition == 2){
                    out.println(1);
                }else{
                    // as for 3 the answer is 3 so we are doing one minus here
                    long multiple = ((long) (goodPosition) *(goodPosition-1))/2;
                    out.println(multiple);
                }

 */

                // so now here as aj - ai = j - i so we can rearrange it to aj - j = ai - i
                // so nwo we have to get the same gap at all position here

                Map<Integer , Integer> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int diff = arr[i]-i;
                    map.put(diff , map.getOrDefault(diff , 0) +1);
                }

                // so now we have to calculate the result
                long ans = 0;
                for(int count : map.values()){
                    ans += ((long) (count) *(count-1))/2;
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
