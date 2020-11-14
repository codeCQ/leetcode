package other;

/**
 * author ChenQian
 * 哨兵思想
 * date 2020.11.14
 */
public class Sentry {
    public static void main(String[] args) {
        int[] nums=new int[]{ 11, 15,2, 7};
        System.out.println(findKey(nums,15));
        System.out.println(findKeyAddSentry(nums,0));
    }

    // 在数组a中，查找key，返回key所在的位置
    // 其中，n表示数组a的长度
    //普通情况
    public static int findKey(int[] irr , int key){
        //防止数组长度为空 或者 Null
        if (irr==null || irr.length<1){
            return -1;
        }
        //循环找到值0
        int i=0;
        while (i<irr.length){
            if (key==irr[i]){
                return i;
            }
            i++;
        }
        return -1;
    }
    //引入哨兵
    public static int findKeyAddSentry(int[]irr , int key){
        //防止数组长度为空 或者 Null
        if (irr==null || irr.length<1){
            return -1;
        }
        //因为我们需要在数组最后一位插入哨兵，所以我们定义一个int
        // 存储数组最后一位
        int temp=irr[irr.length-1];
        if (temp==key){
            return irr.length-1;
        }
        //然后把key存入数组的最后一位
        irr[irr.length-1]=key;
        int i=0;
        //相比于上方的方法 我们少了一步i<irr.length
        while (key!=irr[i]){
            i++;
        }
        //最后我们返回i,当key==irr[i]时候，循环就会结束
        if (i==irr.length-1){
            return -1;
        }
        return i;
    }

}
