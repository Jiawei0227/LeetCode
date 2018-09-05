import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 16/07/2018.
 */
public class ConcatenationSubstring {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words == null || s.isEmpty())
            return res;
        int word_len = words[0].length();
        if (word_len > s.length ())
            return res;
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words)
            counts.put (word, counts.getOrDefault(word,0)+1);

        for (int i = 0; i < word_len; i++){
            int count = 0;
            int l = i;
            final Map<String, Integer> seen = new HashMap<>();
            for( int j = i; j<=s.length()-word_len ; j+=word_len){
                String word = s.substring(j,j+word_len);
                if(counts.containsKey(word)){
                    seen.put (word, seen.getOrDefault(word,0)+1);
                    if (seen.get(word) <= counts.get(word)) {
                        count++;
                    } else {
                        while (seen.get(word) > counts.get(word)) {
                            String first = s.substring(l, l += word_len);
                            seen.put(first, seen.getOrDefault(first, 0) - 1);
                            if (seen.get(first) < counts.getOrDefault(first, 0)) {
                                count--;
                            }
                        }
                    }
                    if (count == words.length) {
                        res.add(l);
                        count--;
                        final String first = s.substring(l, l + word_len);
                        l = l+word_len;
                        seen.put(first, seen.get(first) - 1);
                    }
                }
                else{
                    seen.clear();
                    count = 0;
                    l = j+word_len;
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        String a = "foo";
        String b = "bar";
        String s = "barfoothefoobarman";
        for (Integer e : ConcatenationSubstring.findSubstring(s, new String[]{a, b})) {
            System.out.println(e);
        }
    }





}
