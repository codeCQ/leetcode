package simple.stack.code_844;

public class BackSpaceCompare {
    public static void main(String[] args) {
        myBackspaceCompare("a######","b");
    }

    public static boolean myBackspaceCompare(String s, String t) {
        char[] srr = s.toCharArray();
        char[] trr = t.toCharArray();
        int i=srr.length-1;
        int j=trr.length-1;
        //经过leetcode测试，证明2个变量放在while内和外效果一样
        //根据逻辑 skip最小为0
        int sSkip = 0,tSkip=0;
        //这里用||
        //为了避免极端情况，当 其中某个字符串的第一个字符，与另一个字符串的另一个字符匹配上后
        //最后还会有一个 -- 操作，那么另一个字符串其实还没有比对完全，还需要进行比对，所以选择||
        while (i>=0 || j >=0){
            //获取当前s中的不会被退格的字符
            while (i>=0){
              if (srr[i] == '#'){
                  sSkip++;
                  i--;
              }
              //进入这个else if代表当前字符非'#',不是一个退格符，是一个普通字符
              //则sSkip--，继续退位
              else if( sSkip>0 ){
                  sSkip--;
                  i--;
              }else {
                  //进入这个else,则代表退格与普通字符抵消完全
                  //当前i指向当前不糊被退格的字符
                  break;
              }
            }
            //获取当前t中的不会被退格的字符
            while (j>=0){
             if (trr[j] == '#'){
                 tSkip++;
                 j--;
             }else if ( tSkip > 0){
                 tSkip--;
                 j--;
             }else {
                 break;
             }
            }
            //这里 如果i,j>=0 说明还没有退格完，进行对比
            //如果2个都退格完了 那么久直接true
            //如果有一个没退格玩 就进else
            if ( i >= 0 && j >= 0){
                //当skip>=0时，
                if (srr[i] != trr[j]){
                    return false;
                }
            }
            //进入这个else说明，在i or j前，有一个字符串的有效字符个数不够，退格比有效字符多
            //那么只要i or j中有一个大于0（仍存在有效字符，则表示2者不匹配）
            else{
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            //当前指针所指向的字符已经比对完成，所以指针前移
            i--;
            j--;
        }
        return true;
    }
    
}
