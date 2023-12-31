package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.ArrayIsFullException;
import pro.sky.java.course2.exceptions.ElementNotFoundException;
import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.ItemIsNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integers;

    private int size;

    public IntegerListImpl() {
        integers =new Integer[4];
    }

    public IntegerListImpl(int initSize) {
        integers =new Integer[initSize];
    }

    public IntegerListImpl(Integer... args) {

        integers = new Integer[5];
        System.arraycopy(args, 0, integers, 0, args.length);
        size=args.length;
    }




    @Override

    public Integer add(Integer item) {
        checkSize();
        checkItem(item);
        integers[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        checkIndex(index);
        checkSize();

        if (index == size-1) {
            integers[index] = item;
            return item;
        }

        System.arraycopy(integers, index, integers, index + 1, size - index);

        integers[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = integers[index];
        if (index != size-1) {
            System.arraycopy(integers, index+1, integers, index, size-index-1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        mergeSort(toArray());
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(integers[mid])) {
                return mid;
            }

            if (item < integers[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size-1; i > 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {

            throw new ItemIsNullException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = size-1; i >=0; i--) {
            remove(i);

        }

    }
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    private void sortInsertion() {
        for (int i = 1; i < size; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }

    }

    private void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    private void checkSize() {
        if (size == integers.length) {
            grow();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new InvalidIndexException();
        }
    }
    private void grow() {
        integers = Arrays.copyOf(integers, ((int)(integers.length * 1.5)));

    }
}

