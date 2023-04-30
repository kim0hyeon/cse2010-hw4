package cse2010.hw4;
/*
 * CSE2010 Homework #4: BinToDec.java
 *
 * Complete the code below.
 */

import static java.lang.Math.pow;

public class BinToDec {

    public static int binToDec(String number) {
        if (number.length() == 1) {
            return Integer.parseInt(number);

        } else {
            int first_number;

            if (number.charAt(0) == '1')
                first_number = (int)pow(2,number.length()-1);
            else
                first_number = 0;

            number = number.substring(1);

            return first_number + binToDec(number);
        }
    }

    // Tail-recursion
    public static int binToDecTR(String number, int result) {
        if (number.length()== 1) {
            return result + Integer.parseInt(number);
        } else {
            if (number.charAt(0) == '1')
                result += (int)pow(2,number.length()-1);

            number = number.substring(1);
            return binToDecTR(number,result);
        }
    }

}
