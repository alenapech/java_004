package com.alenapech;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert 5 digits using space as delimiter for the 1st player:");
        Queue<Integer> player1 = new LinkedList(Arrays.stream(input.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
        System.out.println("Insert 5 digits using space as delimiter for the 2nd player:");
        Queue<Integer> player2 = new LinkedList(Arrays.stream(input.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
        System.out.println(player1);
        System.out.println(player2);
        int i = 0;
        while(!player1.isEmpty() && !player2.isEmpty() && i < 100000) {
            System.out.println(player1);
            System.out.println(player2);
            int p1 = player1.poll();
            int p2 = player2.poll();
            if ((p1 > p2 && p1 !=9 && p2 !=0) || (p1 == 0 && p2 == 9)) {
                player1.add(p1);
                player1.add(p2);
            } else if ((p2 > p1 && p2 !=9 && p1 !=0) || (p2 == 0 && p1 == 9)) {
                player2.add(p1);
                player2.add(p2);
            } else {
                throw new Exception("Impossible Case");
            }
            i++;
        }
        if (i == 100000 - 1) {
            System.out.println("botva");
        }
        System.out.println((player1.isEmpty() ? "Second" : "First") + " " + i);
    }

}
