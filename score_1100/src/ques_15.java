import java.io.*;
import java.util.StringTokenizer;

public class ques_15 {
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
                String str = in.next();
                // so now mixing both array together to get the most continuous 1s of it
                str = str+str;
                int n = str.length();
                // so now here
                // for the count of 1 is 1 we have to take the another case
                int count1 = 0;
                for (int i = 0; i < n/2; i++) {
                    if(str.charAt(i) == '1'){
                        count1++;
                    }
                }
                if(count1== 1){
                    out.println(1);
                    continue;
                }
                if(count1 == n/2){
                    long area = (long)count1*count1;
                    out.println(area);
                    continue;
                }

                // for rest of the case

                int max = 0;
                for(int i = 0; i < n; i++){
                    int j = i;
                    int count = 0;
                    // so now here
                    while (j < n && str.charAt(j) == '1' ){
                        j++;
                        count++;
                    }
                    // so after the loop comparing it
                    max = Math.max(max , count);
                    i = j;
                }

                // so now the max area of rectangle can be when it is square the result would be max
                // but in the case of odd 1s

                int val = (max +1)/2;
                int val2 = max/2 + 1;
                long area = (long) val2 * val;
                out.println(area);

//                if(max % 2 != 0){
//                    int val = (max+1)/2;
//                    long area = (long) val * val;
//                    out.println(area);
//                }else{
//                    // so now it is even in that case
//                    int val = max/2;
//                    long area = (long) val * (val+1);
//                    out.println(area);
//                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
