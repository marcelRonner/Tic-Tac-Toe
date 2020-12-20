import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var length = sc.nextInt();
        int[] elements = new int[length];
        int sequence = 0;
        int longestSequence = 1;
        int lastElement = 0;

        for (int i = 0; i < length; i++) {

            elements[i] = sc.nextInt();
            if (elements[i] > lastElement) {
                sequence += 1;
            } else {
                if (sequence > longestSequence) {
                    longestSequence = sequence;
                }
                sequence = 1;
            }
            lastElement = elements[i];
        }
        if (sequence > longestSequence) {
            longestSequence = sequence;
        }
        System.out.println(longestSequence);
    }
}