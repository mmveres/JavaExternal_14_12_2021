package ua.univer.lesson06;

import java.util.Iterator;

class MyList implements Iterable<Integer>{
    private int[] arr;

    public MyList(int... arr) {
        this.arr = arr;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyListIterator(arr);
//                new Iterator<Integer>() {
//            int i = 0;
//            @Override
//            public boolean hasNext() {
//                return i< arr.length;
//            }
//
//            @Override
//            public Integer next() {
//                return arr[i++];
//            }
//        };
    }

    private class MyListIterator implements Iterator<Integer>{
        private int i ;
        private int[] arr;
        MyListIterator(int []arr){
            this.arr = arr;
            i=0;
        }
        @Override
        public boolean hasNext() {
            return  i< arr.length;
        }

        @Override
        public Integer next() {
            return arr[i++];
        }
    }
}

public class ProgramIter {
    public static void main(String[] args) {
        MyList list = new MyList(1,2,3,4,3,5,3,3,4,99);

        for (var el: list) {
            System.out.println(el);
        }

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
