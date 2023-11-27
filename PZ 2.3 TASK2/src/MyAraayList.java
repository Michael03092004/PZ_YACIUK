import java.util.Arrays;

public class MyAraayList {

    private int size;
    private Object[] array;

    public MyAraayList() {
        this(10);
    }

    public MyAraayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    public void add(Object e) {
        ensureCapacity(size + 1);
        array[size] = e;
        size++;
    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    void addAll(Object[] c) {
        ensureCapacity(size + c.length);
        System.arraycopy(c, 0, array, size, c.length);
        size += c.length;
    }

    Object get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Індекс вийшов за границю масива");
            return null;
        }
        return array[index];
    }

    Object remove(int index) {
        if (index < 0  ||index >= size) {
            System.out.println("Індекс вийшов за границю масива");
            return null;
        }
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        if (size * 2 < array.length) {
            array = Arrays.copyOf(array, array.length / 2);
        }
        return removed;
    }

    void removed(int index) {
        for (int i = size - 1; i >= index; i--) {
            remove(i);
        }
    }

    public int size() {
        return size;
    }
}
