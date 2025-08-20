import java.util.ArrayList;

public class ArrayListPart1 {

     public static void main(String[] args) {

          ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
          ArrayList<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);

          mainlist.add(0, list);
          System.out.println(mainlist);

     }
}
