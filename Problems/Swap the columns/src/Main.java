import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var index1 = sc.nextInt();
        var index2 = sc.nextInt();

        int[][] matrix = new int[index1][index2];

        for (int i = 0; i < index1; i++) {
            for (int z = 0; z < index2; z++) {
                matrix[i][z] = sc.nextInt();
            }
        }
        var switch1 = sc.nextInt();
        var switch2 = sc.nextInt();
        int correction = 0;
        int[][] matrixOut = new int[index1][index2];

        for (int i = 0; i < index1; i++) {

            for (int z = 0; z < index2; z++) {
                if (z == switch1) {
                    correction = switch2;
                } else if (z == switch2) {
                    correction = switch1;
                } else {
                    correction = z;
                }
                matrixOut[i][correction] = matrix[i][z];
            }
        }
        for (int i = 0; i < index1; i++) {
            for (int z = 0; z < index2; z++) {
                System.out.printf(matrixOut[i][z] + " ");
            }
            System.out.printf("%n");
        }
    }
}