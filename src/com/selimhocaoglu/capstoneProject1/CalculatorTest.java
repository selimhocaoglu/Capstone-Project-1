package com.selimhocaoglu.capstoneProject1;


import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args){
        System.out.println("***** Gelişmiş Hesap Makinesi *****");
        System.out.println("Toplama: + | Çıkarma: - | Çarpma: * | Bölme: /");
        System.out.println("Karekök: sqrt(x) | Üs Alma: pow(x,y) | Sin: sin(x) | Cos: cos(x) | Tan: tan(x)");
        System.out.println("Çıkmak için: exit");

        Scanner sc = new Scanner(System.in);
        Calculator nesne = new Calculator(sc);
        while(true){
            System.out.print("İşlemi girin: ");
            nesne.ourLine = sc.nextLine();
            if(nesne.ourLine.equals("exit")){
                System.out.println("Hesap makinesi kapatılıyor. İyi günler!");
                break;
            }
            nesne.Calculate();
            nesne.func();
        }


    }
}
