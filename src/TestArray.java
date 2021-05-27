import java.util.concurrent.TimeUnit;

public class TestArray {

    public static final int ARRAY_SIZE = 10000;
    public static final int MAX_VALUE = 10000;

    public static void main(String[] args) {
        ArrayImpl<Integer> arrayAlg1 = new ArrayImpl<>(ARRAY_SIZE);
        ArrayImpl<Integer> arrayAlg2 = new ArrayImpl<>(ARRAY_SIZE);
        ArrayImpl<Integer> arrayAlg3 = new ArrayImpl<>(ARRAY_SIZE);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            int value = (int) (Math.random() * MAX_VALUE);
            arrayAlg1.addValue(value);
            arrayAlg2.addValue(value);
            arrayAlg3.addValue(value);
        }

        long Start = System.nanoTime();
        arrayAlg1.sortBubble();
        long Finish1 = System.nanoTime();
        arrayAlg2.sortSelect();
        long Finish2 = System.nanoTime();
        arrayAlg3.sortInsert();
        long Finish3 = System.nanoTime();

        long sortBubbleTime = Finish1-Start;
        long sortSelectTime = Finish2-Finish1;
        long sortInsertTime = Finish3-Finish2;

        System.out.println("Время сортировки пузырьком - " + TimeUnit.MICROSECONDS.toMicros(sortBubbleTime));
        System.out.println("Время сортировки выбором - " + TimeUnit.MICROSECONDS.toMicros(sortSelectTime));
        System.out.println("Время сортировки вставкой - " + TimeUnit.MICROSECONDS.toMicros(sortInsertTime));






//        ArrayImpl<Integer> data = new ArrayImpl <>(8);
//        data.addValue(1);
//        data.addValue(2);
//        data.addValue(3);
//        data.addValue(4);
//        data.addValue(5);
//        data.addValue(6);
//        data.display();
//        System.out.println(data.searchValue(4));
//
//        System.out.println(data.remove(4));
//        data.display();
//
//        System.out.println(data.deleteValue(6));
//        data.display();

    }


}
