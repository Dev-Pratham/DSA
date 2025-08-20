import java.util.ArrayList;

public class ArrayListPart1 {

     public static void main(String[] args) {

          ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
          ArrayList<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);

          ArrayList<Integer> list2 = new ArrayList<>();
          list2.add(1);
          list2.add(2);
          list2.add(3);

          mainlist.add(0, list);
          mainlist.add(1, list2);
          System.out.println(mainlist);

          // for printing individual elements

          for (int i = 0; i < mainlist.size(); i++) {

               ArrayList<Integer> currentlist = mainlist.get(i);

               for (int j = 0; j < currentlist.size(); j++) {

                    System.out.print(currentlist.get(j));
               }

               System.out.println();
          }

     }
}
