package day1;

import java.util.Scanner;

public class CheckPassFail {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        System.out.println("Introduceti un nr : ");
        int mark = s.nextInt();

        System.out.println("The mark is: " + mark);
        if (mark >= 50) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");

        }
    }
}
