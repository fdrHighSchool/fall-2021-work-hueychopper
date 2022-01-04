import java.util.*;

public class Exams {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    // sample student with 5 slots for grades
    int[] sampleStudent = new int[5]; //0,1,2,3,4,5

    // fill up the "gradebook"
    for(int i = 0; i < sampleStudent.length; i++) {
      sampleStudent[i] = (int)(Math.random() * 46) + 55;
    } // end for loop

    // display the first 5 grades
    System.out.println(Arrays.toString(sampleStudent)+"<--sample student array");
    appendTo(sampleStudent);
  } // end main method
  public static void appendTo(int[] arr) {
    int[] inh = new int[arr.length+1];
    for(int i = 0; i < arr.length; i++) {
      inh[i] = arr[i];
    }
    inh[inh.length-1] = (int)(Math.random() * 46) + 55;
    System.out.println(Arrays.toString(inh));
    lingrade(inh, arr);
  }
  public static void lingrade(int[] arr, int[] oArr) {
    int min = arr[0];
    for(int i = 0; i < arr.length; i++) {
      if(min > arr[i]) min = arr[i];
    }
    int sGrade = arr[arr.length - 1];
    if(sGrade > min) {
      for(int i = 0; i < oArr.length; i++) {
        if(min == oArr[i]) {
          oArr[i] = sGrade; //replace
          System.out.println("min: "+min+" replaced at: "+ i);
        }
      }
      System.out.println(Arrays.toString(oArr)+"<--array with min replaced");
    }
  }

/*
A) Write a method that adds a 6th exam
to the sample student’s set of grades.
*/

/*
B) Write a method that takes the original set
of 5 grades and replaces the lowest grade if
the 6th grade is greater than it.

If it is not, then the original 5 grades remain.
*/


} // end class