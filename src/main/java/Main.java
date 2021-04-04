public class Main {
    public static void main(String[] args) {
        ListCompare listCompare=new ListCompare();
        for (int i=100;i<=100000;i*=10)
        {
            System.out.println(listCompare.compareDelete(i));
            System.out.println(listCompare.compareAdd(i));
        }

    }
}
