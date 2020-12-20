package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var symbols = sc.next().toCharArray();

        String[] table;
        table = new String[9];

        for (int i = 0; i < 9; i++) {
            table[i] = symbols.substring(i,i + 1);
        }

        System.out.println("---------");
        System.out.printf("| %s %s %s |%n", table[0], table[1], table[2]);
        System.out.printf("| %s %s %s |%n", table[3], table[4], table[5]);
        System.out.printf("| %s %s %s |%n", table[6], table[7], table[8]);
        System.out.println("---------");
    }
}
