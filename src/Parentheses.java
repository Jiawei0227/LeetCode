import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jerry Wang on 12/07/2018.
 */
public class Parentheses {
    public boolean isValid(String s) {
        Stack<Character> parentheseStack = new Stack<Character>();
        parentheseStack.push('#');

        for(Character c:s.toCharArray()){
            if (c.equals('('))
                parentheseStack.push('(');
            if (c.equals('['))
                parentheseStack.push('[');
            if (c.equals('{'))
                parentheseStack.push('{');
            if (c.equals(')'))
                if(parentheseStack.pop()=='(')
                    continue;
                else
                    return false;
            if (c.equals(']'))
                if(parentheseStack.pop()=='[')
                    continue;
                else
                    return false;
            if (c.equals('}'))
                if(parentheseStack.pop()=='{')
                    continue;
                else
                    return false;

        }
        if(parentheseStack.pop() == '#')
            return true;
        else
            return false;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0)
            return res;
        generate(res,"",n,n);

        return res;

    }

    private void generate(List<String> res,String str,int inLeft, int outLeft){
        if(inLeft == 0 && outLeft == 0){
            res.add(str);
            return;
        }

        if(inLeft > 0)
            generate(res,str+"(",inLeft-1,outLeft);

        if(inLeft < outLeft)
            generate(res,str+")",inLeft,outLeft-1);


    }

    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int a = s.length();
        for(int i =0 ; i<a ; i++){
            Character c = s.charAt(i);
            if(c == '(')
                stack.push(i);
            else{
                if(s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }

        int b = 0;
        int maxNum = 0;
        if(stack.isEmpty())
            return s.length();
        while(!stack.isEmpty()){
            b = stack.pop();
            maxNum = Math.max(maxNum,a-b-1);
            a = b;
        }

        return maxNum;
    }
}
