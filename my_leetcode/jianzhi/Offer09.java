package jianzhi;

import java.util.Iterator;
import java.util.Stack;

public class Offer09 {


    /**
     *
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    class CQueue {

        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        public CQueue() {
            stackIn=new Stack<>();
            stackOut=new Stack<>();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if ( stackOut.size() <1 ){
                stackInToStackOut();
            }
            if (stackOut.size() <1 ){
                return -1;
            }
            return stackOut.pop();
        }

        private void stackInToStackOut(){
            if (stackIn.size() < 1){
                return;
            }
            int size = stackIn.size();
            //把 In 中的全部倒到 Out
            for (int i = 0; i < size; i++) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
