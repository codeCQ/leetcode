package jianzhi;

public class offer11 {

    public static void main(String[] args) {
        int[] numbers={2,2,2,0,1};
        minArray(numbers);
    }

    /**
     *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     */
    public static int minArray(int[] numbers) {
        int i = numbers[0];
        for (int j = 0; j < numbers.length; j++) {
            if ( numbers[j]>=i  ){
                i=numbers[j];
            }else {
                i=numbers[j];
                break;
            }
        }
        if ( i >numbers[0]){
            return numbers[0];
        }
        return i;
    }
}
