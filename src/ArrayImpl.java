public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;

    public E[] data;
    public int size;

    public ArrayImpl(int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public boolean deleteValue(E value) {
        int index = searchValue(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        E valueDel = data[index];
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        data[--size] = null;
        return valueDel;
    }

    @Override
    public void addValue(E value) {
        data[size++] = value;
    }

    @Override
    public int searchValue(E value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    public void display() {
        System.out.println(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }

        sb.append("]");
        return sb.toString();
    }
}
