import java.io.*;
import java.util.StringTokenizer;

public class ques_24_v2 {
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
                String str = in.next();

                // so nwo checking if the string is palindrome
                int numberOfZero = 0;
                for(int i = 0; i < n; i++){
                    if(str.charAt(i) == '0'){
                        numberOfZero++;
                    }
                }

                if(isPalindrome(str)){
                    // so now here we will continue to use the first case here
                    if(numberOfZero == 1){
                        out.println("BOB");
                    }
                    else if (numberOfZero % 2 == 1){

                        // alice will always win in this case
                        out.println("ALICE");
                    }
                    else{
                        out.println("BOB");
                    }
                }else{

                    // so if the string is not palindrome so alice will always reverse the array till it have
                    // odd number of zero till it became palindrome or till all element become 1 in both case
                    // alice win

                    // the match come to draw if and only if the length of array is odd and have only two zero
                    // and one zero is in middle
                    // so now in this case as if alice make the reverse the bob make the changes which is not a center
                    // thus making it palindrome again so alice have to make 0 to one so draw
                    if(n % 2 == 1 && numberOfZero == 2 && str.charAt(n/2) == '0'){
                        out.println("DRAW");
                    }else{
                        out.println("ALICE");
                    }
                }

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static  boolean isPalindrome (String str){
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
