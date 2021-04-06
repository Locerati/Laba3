import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @author Denis Popov
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList =new ArrayList<Integer>();
        LinkedList<Integer> linkedList =  new LinkedList<Integer>();
        ListCompare listCompareAL=new ListCompare(arrayList);
        ListCompare listCompareLL=new ListCompare(linkedList);

        /*Цикл тестирования разного количества шагов*/
        for (int i=100;i<=100000;i*=10)
        {
            long[] arrayResult=listCompareAL.compareAll(i,5);
            long[] listResult=listCompareLL.compareAll(i,5);
            System.out.println("ArrayList ("+i + " count) " +arrayResult[0] + "ms -Add " +arrayResult[1] + "ms - Get " +arrayResult[2] + "ms - Delete "  );
            System.out.println("LinkedList ("+i + " count) " +listResult[0] + "ms -Add " +listResult[1] + "ms - Get " +listResult[2] + "ms - Delete \n"  );
        }

    }
}
