import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jerry Wang on 12/07/2018.
 */
public class LetterCombination {

    static HashMap<Character,List<Character>> letterMap = new HashMap<Character, List<Character>>();
    static{
        letterMap.put('2', Arrays.asList('a','b','c'));
        letterMap.put('3', Arrays.asList('d','e','f'));
        letterMap.put('4', Arrays.asList('g','h','i'));
        letterMap.put('5', Arrays.asList('j','k','l'));
        letterMap.put('6', Arrays.asList('m','n','o'));
        letterMap.put('7', Arrays.asList('p','q','r','s'));
        letterMap.put('8', Arrays.asList('t','u','v'));
        letterMap.put('9', Arrays.asList('w','x','y','z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.equals("")||digits == null)
            return res;
        for( int i = 0; i<digits.length() ; i++){
            List<String> tmp = new ArrayList<String>();
            if(i == 0){ //initialize
                List<Character> first = letterMap.get(digits.charAt(0));
                for(Character c:first){
                    res.add(c.toString());
                }
                continue;
            }

            for( String r : res){
                List<Character> chars = letterMap.get(digits.charAt(i));
                for(Character c: chars){
                    tmp.add(r+c.toString());
                }
            }

            res = tmp;

        }
        return res;

    }
}
