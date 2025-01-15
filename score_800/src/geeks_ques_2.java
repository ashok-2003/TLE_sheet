public class geeks_ques_2 {
//    https://www.geeksforgeeks.org/problems/handshakes1303/1
    // hand shake problem
    public static void main(String[] args) {
        // so here it will let us know the handshakes here
        System.out.println(count(6));
        // so here we have to avoid the cross handshakes here
    }
    static int count(int N)
    {
        // code here
        if(N==0) return 1;
        int ans=0;
        for(int i=0; i < N; i+=2)
            ans+= count(i)*count(N-2-i);

        return ans;
    }
}
