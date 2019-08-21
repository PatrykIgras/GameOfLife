package appi;

import controls.Contrlol;

import java.util.Scanner;

public class Interface {
    Contrlol contrlol = new Contrlol();
    Scanner scan = new Scanner(System.in);


    public void startGame() {
        System.out.println("Wybierz rozmiar tablicy");
        System.out.println("Podaj wysokość");
        int x = scan.nextInt();
        System.out.println("Podaj szerokośc");
        int y = scan.nextInt();
        contrlol.fillStartBoard(x, y);

        System.out.println("Wybierz tryb gry");
        System.out.println("0. Manualny - ręcznie ustawiasz komórki");
        System.out.println("1. Randomowy - tablica zostaje wypełniona lsosowo");
        System.out.println("2. Gotowe figur");
        int numberOfAction = scan.nextInt();

        if (numberOfAction == 0) {
            contrlol.chooseCellsToLive();
            contrlol.printBoard();
            contrlol.choseNumberOfSteps();
        } else if (numberOfAction == 1) {
            contrlol.setRandomCellsToLive();
            contrlol.printBoard();
            contrlol.choseNumberOfSteps();
        } else if (numberOfAction == 2) {
            System.out.println("Wybierz fihurę");
            System.out.println("0. linia");
            System.out.println("1. krokodyl");
            int number = scan.nextInt();

            if (number == 0) {
                contrlol.setLineShape();
                contrlol.printBoard();
                contrlol.choseNumberOfSteps();
            } else if (number == 1) {
                if (x < 12 && y < 35) {
                    System.out.println("Wybrana tablica jest za mała dla tej figury - zostanie utworzona domyślna");
                    contrlol.fillStartBoard(15, 50);
                    contrlol.setCrocodile();
                    contrlol.printBoard();
                    contrlol.choseNumberOfSteps();
                } else {
                    contrlol.setCrocodile();
                    contrlol.printBoard();
                    contrlol.choseNumberOfSteps();
                }
            }else if (number < 0 || number > 1){
                System.out.println("Wybrałeś numer spoza zakresu");
            }
        }else if (numberOfAction < 0 || numberOfAction > 2){
            System.out.println("Wybrałeś numer spoza zakresu");
        }
    }
}
