import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix;
        matrix = new char[4][4];
        var pretty = "YES";

        for (int index1 = 0; index1 < 4; index1++) {
                matrix[index1] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < 3; i++) {

            for (int z = 0; z < 3; z++){

                if (matrix[i][z] == matrix[i][z + 1] &&
                        matrix[i][z] == matrix[i + 1][z] &&
                        matrix[i][z] == matrix[i + 1][z + 1]) {
                    pretty = "NO";
                    break;
                }
            }
        }
        System.out.println(pretty);
    }
}