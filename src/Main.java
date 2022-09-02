import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int right = 0, selected;
        int[] wrong = new int[5];
        boolean isWin = false; boolean isWrong = false;

        while (right < 5) {
            System.out.print("Lütfen tahminini gir : ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                if(right>1){
                    System.out.println("Lütfen 0-100 arasında bir değer gir.");
                }else{
                    System.out.println("Kaybettin ! ");
                }
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptın. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir sonraki hatalı girişinde -1 hak .");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğin sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Yanlış tahmin !");
                if (selected > number) {
                    System.out.println(selected + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(selected + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[right++] = selected;
                System.out.println("Kalan hak : " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettin ! ");
            if (!isWrong) {
                System.out.println("Tahminlerin : " + Arrays.toString(wrong));
            }
        }

    }
}