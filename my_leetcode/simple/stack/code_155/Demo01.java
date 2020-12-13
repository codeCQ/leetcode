package simple.stack.code_155;

import java.util.LinkedList;

public class Demo01 {
    public static void main(String[] args) {

    }
}
class MinStack {
    private LinkedList<Integer> list=new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        list.addLast(x);
    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        int num=list.get(0);
        for(int i=1;i<list.size()-1;i++){
            if(num>list.get(i)){
                num=list.get(i);
            }
        }
        return num;
    }
}