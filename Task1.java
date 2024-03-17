import java.util.Random;

import java.util.Scanner;
class Game{
    //Declare two variable to hold the random number and guss number.
    int randomNumber;
    int gussNumber;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    //randomNumber() method to return a generated number.
    int randomNumber(){
        return random.nextInt(1, 100);
    }

    //getGussNumber() method to get a guss number from user and check number is between the range.
    int getGussNumber(){
        System.out.println("Please enter Guss number between 1 to 100");
        System.out.print("Enter guss number: ");
        int num = sc.nextInt();
        if(num >= 1 && num <= 100){
            return num;
        }
        return 0;
    }

    //GussNumberCheck() method to check the guss number is equal to generated number or not. If not repeat process again and again.
    void GussNumberCheck(){
        int attempt = 0;
        System.out.println("************You have 3 Attempts************");
        do{
            randomNumber = randomNumber();
            gussNumber = getGussNumber();

            if(gussNumber == 0){
                System.out.println("You enter a guss number from out of range. Try Again");
            }
            else{
                System.out.print("Attempt "+attempt++);
                if(randomNumber == gussNumber){
                    System.out.print(" Guss is correct\n\n");
                } else if (randomNumber < gussNumber) {
                    System.out.print(" Guss is too high\n\n");
                }else{
                    System.out.print(" Guss is too low\n\n");
                }
            }

        }while(attempt < 3);
    }

    //multipleRound() method to provide facility to the user to play game again and again till user get tired.
    void multipleRound(){
        int choice;
        do{
            System.out.print("1.Play Game \n2.Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                GussNumberCheck();
            } else {
                System.out.println("Game Over");
            }
        }while(choice < 2);
    }


}
class NumberGame {
    public static void main(String[] args){
        Game g = new Game();
        g.multipleRound();
    }
}
