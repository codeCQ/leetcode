package simple.linkedlist.code_41;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private int length;
    private Queue<Integer> queue;
    private double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        length = size;
    }

    public double next(int val) {
        if (queue.size() < length){
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
        Integer remove = queue.remove();
        queue.add(val);
        sum -= remove;
        sum += val;
        return sum / queue.size();
    }
}
