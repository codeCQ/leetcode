package simple.stack.code_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo01 {
    /**
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(isValid("))"));
    }


    public static boolean isValid(String s) {
        char[] crr=s.toCharArray();
        if( crr.length-2*(crr.length/2) !=0 ){
            return false;
        }
        Stack<Character> left=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i=0; i< crr.length;i++){
            char c=crr[i];
            if( c=='(' || c=='{'  ||  c=='['  ){
                left.push(c);
            }
            if( c==')' || c=='}'  ||  c==']'  ){
                if( left.isEmpty() || c != map.get(left.pop())){
                    return false;
                }
            }
        }
        if (left.isEmpty()){
            return  true;
        }
        return false;
    }
}
