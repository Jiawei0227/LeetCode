/**
 * Created by Jerry Wang on 11/07/2018.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i = 1 ;i<strs.length;i++){
            String nowStr = strs[i];
            int minLength = Math.min(common.length(),nowStr.length());
            StringBuilder tempString = new StringBuilder();
            for(int j = 0;j<minLength;j++){
                if(common.charAt(j)==nowStr.charAt(j))
                    tempString.append(common.charAt(j));
                else {
                    common = tempString.toString();
                    System.out.println(common);
                    break;
                }
            }
            common = tempString.toString();
            if(common.isEmpty()){
                return "";
            }
        }
        return common;
    }

    public static void main(String args[]){
        String[] test = new String[]{"flower","flow","flight"};
        LongestCommonPrefix.longestCommonPrefix(test);
    }
}
