import java.util.List;

public class ListCompare<T> {
    List<T> list;
    public ListCompare(List<T> enterList){
        list=enterList;
    }
    public long[] compareAll(int count, T value){
        long[] testList= new long[3];
        testList[0]=compareAdd(count,value);
        testList[1]=compareDelete(count,value);
        testList[2]=compareGet(count,value);
        return testList;
    }
    public long compareAdd(int count, T value){
        list.clear();
        long time = System.nanoTime();
        for (int i=0;i<count;i++){
            list.add(value);
        }
        time=System.nanoTime() - time;
        return time;
    }
    public long compareDelete(int count, T value){
        compareAdd(count,value);
        long time = System.nanoTime();
        for (int i=count-1;i>=count/2;i--){
            list.remove(i);
        }
        for (int i=0;i<count/2;i++){
            list.remove(i);
        }
        time=System.nanoTime() - time;
        return time;
    }
    public long compareGet(int count, T value){
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
