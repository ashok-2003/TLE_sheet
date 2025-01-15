import java.io.*;
import java.util.*;
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
            // so now here as we have to use this again and again so creating this
            int[] dx = {-1, 1, -1, 1}, dy = {-1, -1, 1, 1};
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // so now first line gave the a and b for the move
                int a = in.nextInt();
                int b = in.nextInt();
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();

                // so now here we have to create the pair so java dose not have pair class so now
                // so now here making the array with the all of the case value here
                int[][] values = new int[4][2];
                if(a != b) {
                    int[][] arr = {{a, b}, {a, -b}, {-a, b}, {-a, -b},
                            {b, a}, {b, -a}, {-b, a}, {-b, -a}};
                    values = arr;
                }
                else{
                    int[][] arr = {{a,a} , {-a , a} , {-a ,-a} , {a , -a}};
                    values = arr;
                }

                // so now here we have to check for each of the values here
                int ans = 0;
                for(int[] val : values){
                    int xn = x1 + val[0];
                    int yn = y1 + val[1];

                    // so now checking here
                    if(isvalid(xn ,  yn , x2 , y2 , a , b)){
                        ans++;
                    }
                }
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            return;
        }

    }
    static boolean isvalid(int xn , int yn  , int x2 , int y2 , int a , int b){
        // so now here as from the posotion of knight if we have reached then we can say it is good move
        if((Math.abs(xn - x2 ) == a && Math.abs(yn - y2) == b) || (Math.abs(xn - x2 ) == b && Math.abs(yn - y2) == a)){
            return true;
        }else{
            return false;
        }
    }
}

