import java.util.List;
/**
 * Класс - коллекция позволяющий сравнивать производительность наследников List
 * @author Denis Popov
 * @version 1.0
 * @param <T> тип элемента Списка
 */
public class ListCompare<T> {
    List<T> list;
    public ListCompare(List<T> enterList){
        list=enterList;
    }
    /**
     *  Проверка всех методов
     * @param count - принимает количество элементов
     * @param value - принимает элемент для вставки
     * @return - возвращает массив с временем работы каждого метода
     */
    public long[] compareAll(int count, T value){
        long[] testList= new long[3];
        testList[0]=compareAdd(count,value);
        testList[1]=compareGet(count,value);
        testList[2]=compareDelete(count,value);
        return testList;
    }
    /**
     *  Проверка метода вставки
     * @param count - принимает количество элементов
     * @param value - принимает элемент для вставки
     * @return - возвращает время работы метода
     */
    public long compareAdd(int count, T value){
        list.clear(); //Очишаем список на случай уже имеющихся данных
        long time = System.nanoTime();
        for (int i=0;i<count;i++){
            list.add(value);
        }
        time=System.nanoTime() - time;
        return time;
    }
    /**
     *  Проверка метода удаления элементов
     * @param count - принимает количество элементов
     * @param value - принимает элемент для вставки
     * @return - возвращает время работы метода
     */
    public long compareDelete(int count, T value){
        /* Для того что бы была возможность тестирования каждого метода по отдельности
        * инициализирум каждый раз метод нужным для тестирования количеством элементов*/
        compareAdd(count,value);
        long time = System.nanoTime();
        for (int i=count-1;i>=count/2;i--){
            list.remove(i);
        }
        for (int i=0;i<count/2;i++){
            list.remove(0);
        }
        time=System.nanoTime() - time;
        return time;
    }
    /**
     *  Проверка метода выбора элементов
     * @param count - принимает количество элементов
     * @param value - принимает элемент для вставки
     * @return - возвращает время работы метода
     */
    public long compareGet(int count, T value){
        /* Для того что бы была возможность тестирования каждого метода по отдельности
         * инициализирум каждый раз метод нужным для тестирования количеством элементов*/
        compareAdd(count,value);
        long time = System.nanoTime();
        for (int i=count/2;i<count;i++){
            list.get(i);
        }
        for (int i=0;i<count/2;i++){
            list.get(i);
        }
        time=System.nanoTime() - time;
        return time;
    }

}
