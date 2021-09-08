package sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a ={9,5,8,6,9,5};
        bubbleSort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n<1) {
            return ;
        }
        boolean b= true;
        for (int j = 0; j < a.length-1; j++) {
            b= true;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    b= false;
                }
            }
            if (b){
                return ;
            }
        }
    }
}
