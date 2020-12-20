import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var length = sc.nextInt();
        int[] elements = new int[length];

        for(int i = 0; i < length; i++) {
            elements[i] = sc.nextInt();
        }
        var limit = sc.nextInt();
        var sum = 0;

        for(int element : elements){
            if (element > limit){
                sum += element;
            }
        }
        System.out.println(sum);
    }
}