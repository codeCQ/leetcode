package dongTaiGuiHua;

public class Backpack_Easy {

    public static void main(String[] args) {

        //System.out.println(knapsack(new int[]{2,2,4,6,3},5,9));
        System.out.println(Integer.toBinaryString(13948));
        System.out.println(Integer.parseInt("11011001111010",2));
        System.out.println(Integer.parseInt("11011010000111",2));
        String s = Integer.toBinaryString(2);
        char[] chars = s.toCharArray();

        int i = ~(1 << 1);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

    }


    /**
     * 背包问题
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
     * 解决思路：我们物品种类相加的所有可能的结果 然后再在其中获取鱼背包最大重量 最相近的值
     * 用一个Boolean2维数组 值代表可能性 1维长度代表放入次数 2维长度代表背包张放入物品的重量
     */
    //weight:物品重量，n:物品个数，w:背包可承载重量
    public static int knapsack(int[] weight,int n,int w) {
        boolean[][] status = new boolean[n][w + 1];
        //如果首个物品weight小于背包承重 设置首次 00 为true
        if (weight[0] <= w) {
            status[0][0] = true;
        }
        //开始逐个放入物品
        for (int i = 1; i < n; i++) {
            //选择不放入当前物品
            for (int j = 0; j < w + 1; j++) {
                if (status[i - 1][j]) {
                    status[i][j] = true;
                }
            }
            //选择放入当前物品
            for (int j = 0; j < w + 1; j++) {
                if (j + weight[i] < w + 1) {
                    status[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i > -1; i--) {
            if (status[n - 1][i]) return i;
        }

        return 0;
    }
}