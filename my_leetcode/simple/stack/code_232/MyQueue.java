package simple.stack.code_232;

import java.util.Stack;

class MyQueue {
    //用两个栈 实现一个先进先出的队列
    //一个栈专门push 一个栈为空
    //当需要pop或peak时 and s2为空，把s1中数全部倒序到s2 然后s2 peek or pop
    // 如果s2不为空 则直接 pop or peak
    private Stack<Integer> s1=null;
    private Stack<Integer> s2=null;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack();
        s2=new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( s2.isEmpty() ){
            //把s1的元素全部倒叙到s2
            while( !s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if( s2.isEmpty() ){
            //把s1的元素全部倒叙到s2
            while( !s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }


}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
