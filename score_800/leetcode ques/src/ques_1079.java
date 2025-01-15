import java.util.HashSet;
import java.util.Set;

public class ques_1079 {
    // letter tile possibilites
    public static void main(String[] args) {
        String s = "AAB";
        System.out.println(numTilePossibilities(s));
        System.out.println(set);
    }
    static Set<String> set = new HashSet<>();
    public static int numTilePossibilities(String tiles) {
        // so now here we have to create a map which will store all of it valeu here
        // so now here convert the tiles into the char Array
        char[] tile = tiles.toCharArray();
        // so now here we have to create a map here also that take care if the path visited or not here
        boolean[] map = new boolean[tile.length];
        StringBuilder sb = new StringBuilder();
        helper(tile , map , sb);
        return set.size();
    }
    static void helper(char[]tiles , boolean[] map , StringBuilder sb ){
        // so now here
        for(int i = 0; i < tiles.length; i++){
            // so now here we have to procced only if the path is not visited here
            if(map[i] == false){
                // so now make the map[i] == true
                map[i] = true;
                // so now here append the value to the string here
                sb.append(tiles[i]);
                // so now getting the value in the set here
                set.add(sb.toString());
                // so now here call the function here
                helper(tiles , map , sb);
                // so now here bakctrack here
                sb.deleteCharAt(sb.length()-1);
                // so now here as the loop run each of the time here so now we should backtrack the map here also
                map[i] = false;

            }
        }

    }
}
