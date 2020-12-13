import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var numb = sc.nextInt();
        int index = 0;

        while (numb != 0){
            numb = sc.nextInt();
            index++;
        }
        System.out.println(index);
    }
}