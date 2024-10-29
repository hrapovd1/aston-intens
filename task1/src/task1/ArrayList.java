package task1;

import java.util.Collection;
import java.util.Comparator;

public class ArrayList<E extends Comparable<E>> {
    /**
     * arrList - underline array
     */
    private Object[] arrList;
    /**
     * size - next index in array
     */
    private int size;

    private void initArr(int size) {
        arrList = new Object[size];
        this.size = 0;
    }

    private boolean needResize(int index) {
        if (index > arrList.length - 1) {
            return true;
        }
        return false;
    }

    private void resize(int index) {
        var newArr = new Object[index + 10];
        for(int i = 0; i < arrList.length; i++) {
            newArr[i] = arrList[i];
        }
        arrList = newArr;
    }

    /**
     * linear search in array
     * @param o
     * @return
     */
    private int find(Object o) {
        for(int i = 0; i < size; i++) {
            if(arrList[i] == null) {
                continue;
            }
            if(arrList[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /*=============== Merge sort implement ================= */

    private void sortArray(
        Object[] a, int lo, int hi,
        Object[] buf, Comparator<? super E> c) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sortArray(a, lo, mid, buf, c);
        sortArray(a, mid + 1, hi, buf, c);
        merge(a, lo, mid, hi, buf, c);
    }

    @SuppressWarnings({"unchecked"})
    private void merge(
        Object[] a, int lo, int mid, int hi,
        Object[] buf, Comparator<? super E> c) {

        for (int i = lo; i <= hi; i++) {
            buf[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = buf[j++];
            else if (j > hi)
                a[k] = buf[i++];
            else if (c.compare((E) buf[i], (E) buf[j]) <= 0)
                a[k] = buf[i++];
            else
                a[k] = buf[j++];
        }

    }

    public ArrayList() {
        this(10);
    }

    public ArrayList(int size) {
        initArr(size);
    }

    /**
     * return count of existed elements
     */
    public int size() {
        return size;
    }

    /* =============== methods from task =============== */

    /**
     * add element by index
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (needResize(index)) {
            resize(index);
        }
        arrList[index] = element;
        if(index > size) {
            size = index + 1;
        }
    }

    /**
     * add elements from collection.
     * @param c
     */
    public void addAll(Collection<? extends E> c) {
        if (needResize(size + 1 + c.size())) {
            resize(size + 1 + c.size());
        }
        for (E e : c) {
            arrList[size] = e;
            size++;
        }
    }

    /**
     * clear array by init it.
     */
    public void clear() {
        initArr(10);
    }

    /**
     * return element by index
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings({"unchecked"})
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
        return (E) arrList[index];
    }

    /**
     * check array is empty
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * remove element by index
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public boolean remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == size - 1) {
            size--;
            return true;
        }
        for (int i = index;i < size - 1; i++) {
            arrList[i] = arrList[i + 1];
        }
        size--;
        return true;
    }

    /**
     * find element in array and remove it.
     */
    public boolean remove(Object o) {
        int index = find(o);
        if (index >= 0) {
            try {
                return remove(index);
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * sort array in place
     * @param c
     */
    public void sort(Comparator<? super E> c) {
        if (isEmpty()) {
            return;
        }
        Object[] buf = new Object[size];
        sortArray(arrList, 0, size - 1, buf, c);
    }
}