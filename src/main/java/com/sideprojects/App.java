package com.sideprojects;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        System.out.println("Password Generator");
        new App().start();

    }

    private void start() {
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        int length = 0;
        boolean loop = true;

        while (loop = true) {
            try {
                System.out.println("Enter password length (min = 8, max = 20): ");
                length = keyboard.nextInt();
                if (length >= 8 && length <= 20) {
                    ArrayList<Character> pwd = new ArrayList<Character>();
                    for (int i = 0; i < length; i++) {
                        int decision = rand.nextInt(3);
                        if (decision == 0) {
                            char c = (char) ('1' + rand.nextInt(9));
                            pwd.add(c);
                        } else if (decision == 1) {
                            char c = (char) ('!' + rand.nextInt(15));
                            pwd.add(c);
                        } else if (decision == 2) {
                            char c = (char) ('A' + rand.nextInt(26));
                            pwd.add(c);
                        } else {
                            char c = (char) ('a' + rand.nextInt(26));
                            pwd.add(c);
                        }
                    }
                    String fullPwd = pwd.stream().map(e -> e.toString()).collect(Collectors.joining());
                    System.out.println("\nYour password is : ");
                    System.out.println(fullPwd + "\n");
                    break;
                }else{
                    throw new Exception();
                }

            } catch (InputMismatchException ime) {
                System.out.println("Please enter a number");
                keyboard.nextLine();
            } catch(Exception e){
                System.out.println("Please enter an int > 8 & <= 20");
                keyboard.nextLine();
            }
        }

    }
}
