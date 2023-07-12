package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.ArrayIsFullException;
import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.ItemIsNullException;

import java.util.Arrays;

    public class StringListImpl implements StringList{
        private final String[] strings;

        private int size;

        public StringListImpl() {
            strings =new String[10];
        }

        public StringListImpl(int initSize) {
            strings =new String[10];
        }


        @Override

        public String add(String item) {
            checkSize();
            checkItem(item);
            strings[size++] = item;
            return item;
        }

        @Override
        public String add(int index, String item) {
            checkItem(item);
            checkIndex(index);
            checkSize();

            if (index == size) {
                strings[size++] = item;
                return item;
            }

            System.arraycopy(strings, index, strings, index + 1, size - index);
            strings[index] = item;
            size++;

            return null;
        }

        @Override
        public String set(int index, String item) {
            checkIndex(index);
            checkItem(item);
            strings[index] = item;
            return item;
        }

        @Override
        public String remove(String item) {
            return null;
        }

        @Override
        public String remove(int index) {
            return null;
        }

        @Override
        public boolean contains(String item) {
            checkItem(item);
            return indexOf(item) != -1;
        }

        @Override
        public int indexOf(String item) {
            checkItem(item);
            for (int i = 0; i < size; i++) {
                if (strings[i].equals(item)) {
                    return i;
                }
            }

            return -1;
        }

        @Override
        public int lastIndexOf(String item) {
            checkItem(item);
            for (int i = size; i > 0; i--) {
                if (strings[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public String get(int index) {
            checkIndex(index);
            return strings[index];
        }

        @Override
        public boolean equals(StringList otherList) {
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
            size = 0;

        }

        @Override
        public String[] toArray() {
            return Arrays.copyOf(strings, size);
        }

        private void checkItem(String item) {
            if (item == null) {
                throw new ItemIsNullException();
            }
        }

        private void checkSize() {
            if (size == strings.length) {
                throw new ArrayIsFullException();
            }
        }

        private void checkIndex(int index) {
            if (index < 0 || index > size) {
                throw new InvalidIndexException();
            }
        }


    }

