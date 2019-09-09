package ru.ttv.interviewprepare.lesson2;

import java.util.Arrays;

/**
 * @author Teplykh Timofey  03.09.2019
 */
public class ArrayList<T> {

    private Object[] list;

    private int size;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    public ArrayList(int size) {
        this.list = new Object[size];
    }

    public ArrayList(){
        this.list = new Object[10];
    }

    public void add(int index, T elem){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

        int minCapacity = size +1;

        if (minCapacity - list.length > 0){
            int oldCapacity = list.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            list = Arrays.copyOf(list, newCapacity);
        }

        System.arraycopy(list, index, list, index + 1,size - index);
        list[index] = elem;
        size++;
    }

    public void remove(int index){
        if(index >= size)
            throw new IndexOutOfBoundsException();
        int numMoved = size - index - 1;
        if(numMoved > 0){
            System.arraycopy(list, index+1, list, index, numMoved);
        }
        list[--size] = null;
    }

    public void trimToSize(){
        if(size < list.length){
            if(size == 0){
                list = EMPTY_ELEMENTDATA;
            }else{
                Arrays.copyOf(list, size);
            }
        }
    }

}
