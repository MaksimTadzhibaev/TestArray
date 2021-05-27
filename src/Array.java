public interface Array<E> {

    boolean deleteValue(E value);

    E remove(int index);

    void addValue(E value);

    int searchValue(E value);

    void sortBubble();

    void sortSelect();

    void sortInsert();
}
