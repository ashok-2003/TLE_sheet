import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ques_6 {
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
                    arr[i] = in.nextInt();
                }
                // so now removing the duplicated item as they are not needed
                List<Integer> ls = new ArrayList<>();
                ls.add(arr[0]);
                for(int i = 0; i < n; i++){
                    if(ls.get(ls.size()-1) == arr[i]){
                       continue;
                    } // otherwise add the element
                    ls.add(arr[i]);
                }
                // so now all the element is added without  being repeated
                if(ls.size() == 1){
                    out.println(1);
                    continue;
                }
                //otherwise  we have to check if at any place we are getting the mountain array thing
                // if we get the mountain array type of thing then the answer increases by one each time
                int increase = 0;
                for(int i = 1; i < ls.size()-1; i++){
                    if(ls.get(i) > ls.get(i-1) && ls.get(i) > ls.get(i+1)){
                        increase++;
                    }else if (ls.get(i) < ls.get(i-1) && ls.get(i) < ls.get(i+1)){
                        increase++;
                    }
                }

                out.println(2+increase);  // as the initial answer will be two here
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
