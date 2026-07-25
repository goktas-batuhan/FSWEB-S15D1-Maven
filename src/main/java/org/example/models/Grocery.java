package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("0: Çıkış\n1: Eklenmesini istediğiniz elemanları giriniz.\n2: Cıkarılmasını istediğiniz elemanları giriniz.\nSeçiminiz: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                addItems(input);
                printSorted();
            } else if (choice == 2) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                removeItems(input);
                printSorted();
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim();
            if (!checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim();
            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
