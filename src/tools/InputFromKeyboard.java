/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class InputFromKeyboard {
    
    public static int inputNumberFromRange(Integer min, Integer max) {
        Scanner scanner = new Scanner(System.in);
        int number = min - 1;
        boolean isNumber = true;
        boolean repeat;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception event) {
                scanner.nextLine();
                isNumber = false;
            }
            if((number >= min && number <= max) && isNumber){
                repeat = false;
            }else{
                System.out.printf("Enter number from next range: %d ... %d: ", min, max);
                isNumber = true;
                repeat = true;
            }
        } while(repeat);
        return number;
    }
}
