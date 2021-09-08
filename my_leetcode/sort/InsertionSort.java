package sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a ={9,5,8,6,9,5};
        System.out.println(a.length);
        insertionSort(a,a.length);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n<1) {
            return;
        }
        // 9,5,8,6,9,5
        for (int i = 0; i < a.length-1; i++) {
            int num= a[i];
            int next= a[i+1];
            int j=i;
            //向前移动 568995
            for(;j>0;--j){
                if (next <a[j]){
                    a[j+1]=a[j];
                }else {
                    break;
                }
            }
            a[j]=next;
            for (int x = 0; x < a.length; x++) {
                System.out.print(a[x]);
            }
                System.out.println();
        }
    }
}
