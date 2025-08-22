import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPart1 {

     public static void printList(ArrayList<ArrayList<Integer>> mainlist) {

          // for printing individual elements

          for (int i = 0; i < mainlist.size(); i++) {

               ArrayList<Integer> currentlist = mainlist.get(i);

               for (int j = 0; j < currentlist.size(); j++) {

                    System.out.print(currentlist.get(j));
               }

               System.out.println();
          }

     }

     public static int min(int a, int b) {
          return a < b ? a : b;
     }

     public static int water(ArrayList<Integer> height) {

          int maxWaterArea = Integer.MIN_VALUE;

          for (int i = 0; i < height.size(); i++) {
               int leftBarHeight = height.get(i);
               for (int j = i + 1; j < height.size(); j++) {
                    int rightBarHeight = height.get(j);
                    int waterLevel = min(leftBarHeight, rightBarHeight);
                    int width = j - i;
                    int totalArea = width * waterLevel;
                    if (maxWaterArea < totalArea) {
                         maxWaterArea = totalArea;
                    }

               }
          }

          return maxWaterArea;
     }

     public static int mostWater(ArrayList<Integer> height) {

          int leftPointer = 0;
          int rightPointer = height.size() - 1;
          int largestVolume = Integer.MIN_VALUE;
          while (leftPointer < rightPointer) {
               int width = rightPointer - leftPointer;
               int containerHeight = min(height.get(rightPointer), height.get(leftPointer));
               int water = width * containerHeight;

               if (largestVolume < water) {
                    largestVolume = water;
               }

               if (height.get(leftPointer) < height.get(rightPointer)) {
                    leftPointer++;
               } else {
                    rightPointer--;
               }
          }

          return largestVolume;
     }

     public static void main(String[] args) {

          // ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
          // ArrayList<Integer> list1 = new ArrayList<>();
          // // list1.add(1);
          // // list1.add(2);
          // // list1.add(3);

          // ArrayList<Integer> list2 = new ArrayList<>();
          // // list2.add(1);
          // // list2.add(2);
          // // list2.add(3);

          // ArrayList<Integer> list3 = new ArrayList<>();

          // mainlist.add(0, list1);
          // mainlist.add(1, list2);
          // System.out.println(mainlist);

          // objective to get
          // list1:1 2 3 4 5
          // list2:2 4 6 8 10
          // list3:3,6,9,12,15

          // int size = 5;

          // for (int i = 0; i < size; i++) {
          // list1.add(i + 1);
          // list2.add((i * 2) + 2);
          // list3.add((i * 3) + 3);
          // }

          // mainlist.add(list1);
          // mainlist.add(list2);
          // mainlist.add(list3);

          // printList(mainlist);
          // System.out.println(mainlist);

          // container with most water problem
          ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
          int resultMaxWater1 = water(height);
          int resultMaxWater2 = mostWater(height);
          // tc o(n^2)
          System.out.println(resultMaxWater1);
          // tco(n)
          System.out.println(resultMaxWater2);

     }
}
