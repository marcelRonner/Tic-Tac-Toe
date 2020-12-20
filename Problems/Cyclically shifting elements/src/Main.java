import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var length = sc.nextInt();
        int[] elements = new int[length];

        for (int i = 0; i < length; i++) {
            elements[i] = sc.nextInt();
        }

        int[] shiftedElements = new int[length];

        for (int z = 1; z < length + 1; z++) {
            if (z == length) {
                shiftedElements[0] = elements[length-1];
            } else {
                shiftedElements[z] = elements[z - 1];
            }
        }
        for (int element : shiftedElements){
            System.out.print(element + " ");
            }
        }
    }
