package com.algorithm;

public class LC0622 {
    private int[] arr;
    private int head;
    private int tail;
    private int count;
    private int capacity;
    /** Initialize your data structure here. Set the count of the queue to be k. */
    public LC0622(int k) {
        arr = new int[k];
        head = 0;
        tail = 0;
        count = 0;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (count >= capacity) {
            return false;
        }
        //队列为空,重新设置头部
        if(count == 0) {
            head = (head==capacity)? 0 : head;
            tail = head;
            arr[tail] = value;
            count++;
            return true;
        }

        //队列有数据未满
        if (tail == capacity - 1) {
            tail = 0;
        } else {
            tail++;
        }
        arr[tail] = value;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        //队列为空
        if(count == 0) {
            return false;
        }
        count--;
        head++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(count==0) {
            return -1;
        }
        return arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(count==0) {
            return -1;
        }
        return arr[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}
