package com.interview.dropbox;

import java.util.BitSet;

/**
 * Created by Jerry Wang on 05/10/2018.
 */
public class PhoneDirectory {

    /**
    //O(N)
    int max;
    HashSet<Integer> set;
    LinkedList<Integer> queue;

    public PhoneDirectory(int maxNumbers){
        set = new HashSet<>();
        queue = new LinkedList<>();
        for(int i = 0 ; i<maxNumbers; i++){
            queue.offer(i);
        }
        max = maxNumbers - 1;
    }

    //O(1)
    public int get(){
        if(queue.isEmpty())
            return -1;
        int e = queue.poll();
        set.add(e);
        return e;
    }

    //O(1)
    public boolean check(int number){
        return !set.contains(number) && number <= max;
    }

    //O(1)
    public void release(int number){
        if(set.contains(number)){
            set.remove(number);
            queue.offer(number);
        }
    }
    **/
//    BitSet bitSet;
//    int maxNumber;
//    int idx;
//    public PhoneDirectory(int maxNumber){
//        bitSet = new BitSet(maxNumber);
//        this.maxNumber = maxNumber;
//        idx = 0;
//    }
//
//    public int get(){
//        if(idx == maxNumber)
//            return -1;
//        int num = idx;
//        bitSet.set(num);
//        idx = bitSet.nextClearBit(idx);
//        return num;
//    }
//
//    public boolean check(int number){
//        if(number < 0 || number>= maxNumber)
//            return false;
//        return !bitSet.get(number);
//    }
//
//    public void release(int number){
//        if(number<0 || number >= maxNumber)
//            return;
//        if(!bitSet.get(number)) return;
//
//        bitSet.clear(number);
//        if(number<idx)
//            idx = number;
//
//    }

    private BitSet bitmap;
    private int maxNumber;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumber = maxNumbers;
        this.bitmap = new BitSet(maxNumbers*2-1);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {

        int left = 0, right = maxNumber-1;
        int start = 0;
        if(bitmap.get(start)) return -1;
        while(left<right){
            int mid = left+((right-left)>>1);
            if(!bitmap.get(start*2+1)){
                start = start*2+1;
                right = mid;
            }
            else{
                start = start*2+2;
                left = mid+1;
            }
        }

        flip(left);
        // print();
        return left;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return getStatus(number,0,0,maxNumber-1);
    }

    private boolean getStatus(int number, int current, int left, int right){
        if(bitmap.get(current)) return false;
        if(left == right) return !bitmap.get(current);
        int mid = left + ((right-left)>>1);
        if(mid <number){
            return getStatus(number,current*2+2,mid+1,right);
        }else{
            return getStatus(number,current*2+1,left,mid);
        }

    }
    private void flip(int number){
        setStatus(number, 0, 0, maxNumber-1);
    }
    private void setStatus(int number, int cur, int left, int right){
        if(left == right){
            bitmap.flip(cur);
            return ;
        }
        int mid = left + ((right-left)>>1);
        if(mid >= number){
            setStatus(number,cur*2+1,left,mid);
        }else{
            setStatus(number,cur*2+2,mid+1,right);
        }
        if(bitmap.get(cur*2+1) && bitmap.get(cur*2+2))
            bitmap.set(cur);
        else{
            bitmap.clear(cur);
        }
    }


    /** Recycle or release a number. */
    public void release(int number) {
        if(number>=maxNumber || number <0) return;
        if(!check(number)){
            flip(number);
        }
    }



    public static void main(String args[]){
        PhoneDirectory p = new PhoneDirectory(5);
        System.out.println(p.get());
        System.out.println(p.get());
        System.out.println(p.get());
        p.release(1);
        p.release(2);
        System.out.println(p.get());
    }

}
