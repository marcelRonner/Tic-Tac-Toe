import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var inputSize = sc.nextInt();
        var size = inputSize * inputSize;
        var decision = "YES";

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int z = 0; z < size; z++) {
                matrix[i][z] = sc.nextInt();
            }
        }

        int[][] checkMatrix = new int[size][2];            //checkMatrix init
        for (int i = 0; i < size;) {
            checkMatrix[i][1] = 0;
            checkMatrix[i][0] = ++i;
        }

        for (int i = 0; i < size; i++) {                   //check Rows
            for (int z = 0; z < size; z++) {
                if (matrix[i][z] <= size) {
                    checkMatrix[matrix[i][z] - 1][1] = 1;
                }
            }
            for (int z = 0; z < size; z++) {
                if (checkMatrix[z][1] == 0) {
                    decision = "NO";
                }
                checkMatrix[z][1] = 0;
            }
        }

        for (int i = 0; i < size; i++) {                   //check Columns
            for (int z = 0; z < size; z++) {
                if (matrix[z][i] <= size) {
                    checkMatrix[matrix[z][i] - 1][1] = 1;
                }
            }
            for (int z = 0; z < size; z++) {
                if (checkMatrix[z][1] == 0) {
                    decision = "NO";
                }
                checkMatrix[z][1] = 0;
            }
        }
        for (int y = 0; y < size; y += inputSize){
            for (int x = 0; x < size; x += inputSize){
                for (int i = x; i < inputSize + x; i++) {                   //check single quadrant
                    for (int z = y; z < inputSize + y; z++) {
                        if (matrix[z][i] <= size) {
                            checkMatrix[matrix[z][i] - 1][1] = 1;
                        }
                    }
                }
                for (int z = 0; z < size; z++) {
                    if (checkMatrix[z][1] == 0) {
                        decision = "NO";
                    }
                    checkMatrix[z][1] = 0;
                }
            }
        }
        System.out.println(decision);
    }
}
