import net.sf.saxon.expr.ItemMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T>{

    private T[] Items;
    private int size;
    private int head;
    private int tail;
    private int arrSize;

    private static int MULTIPLE = 2;

    public ArrayDeque61B(){
        size = 0;
        Items = (T[]) new Object[8];
        arrSize = 8;
        head = 0;
        tail = 0;
    }

    private void resize(){
        int originalSize = arrSize;
        int newSize = arrSize * MULTIPLE;

        T[] newArr;
        newArr = (T[]) new Object[newSize];

        int newHead = head + (newSize - originalSize);

        // copy array
        if(head > tail) {
            arrayCopy(Items, newArr, 0, tail, 0, tail);
            arrayCopy(Items, newArr, head, originalSize - 1, newHead, newSize - 1);

            head = newHead;
        }
        else{
            arrayCopy(Items, newArr, head, tail, head, tail);
        }

        Items = newArr;
        arrSize = newSize;
    }

    private void arrayCopy(T[] List1, T[] List2, int start1, int end1, int start2, int end2) {
        if(start1 >= 0 && start2 >= 0 && end1 < List1.length && end2 < List2.length) {
            int copySize = end1 - start1;

            if (copySize != (end2 - start2)) {
                throw new IllegalArgumentException("Length are not equal!");
            }

            for (int i = start1; i <= end1; i++) {
                int newi = start2 + (i - start1);
                List2[newi] = List1[i];
            }
        }
        else {
            throw new ArrayIndexOutOfBoundsException("One of your array index is out of Bound");
        }
    }

    @Override
    public void addFirst(T x) {
        if(size == arrSize){
            resize();
        }

        if(!isEmpty()) {
            int newHead = Math.floorMod(head - 1, arrSize);
            Items[newHead] = x;
            head = newHead;
        }
        else {
            Items[0] = x;
        }

        size++;
    }

    @Override
    public void addLast(T x) {
        if(size == arrSize){
            resize();
        }

        if(!isEmpty()) {
            int newTail = Math.floorMod(tail + 1, arrSize);
            Items[newTail] = x;
            tail = newTail;
        }
        else{
            Items[0] = x;
        }

        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for(int index = 0; index < size; index ++){
            T curr = get(index);
            returnList.addLast(curr);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(!isEmpty()){
            T returnValue = Items[head];

        }
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size){
            int trueIndex = Math.floorMod(index + head, arrSize);
            return Items[trueIndex];
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
