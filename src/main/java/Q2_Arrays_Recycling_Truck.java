import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Lab 4, Question 2
 */


public class Q2_Arrays_Recycling_Truck {

    /*You are a recycling truck driver. You’ll like to collect some statistics on how
    much each of the houses on a certain street is recycling.

    Each house has to use crates for their recycling. This street is a
    little unusual since it only has 8 houses, and the city planner
    must have been a computer programmer, since the house numbers are
    0, 1, 2, 3, 4, 5, 6, and 7.

    (Hint – the house numbers are the same as array element indexes.)

    Write a program that asks for the number of recycling crates set out
    by each house. You should store this data in an array.

    How many recycling crates, in total, from all the houses on the street?

    What is the largest number of crates set out by any house?

    What is the smallest number of crates set out by any house?

    Which house had the most recycling? Display that house number.*/

    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfHouses = 8;

        int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);

        int totalCrates = calculateTotal(cratesPerHouse);

        int maxCrates = calculateMax(cratesPerHouse);

        int minCrates = calculateMin(cratesPerHouse);

        ArrayList<Integer> housesWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse, maxCrates);

        System.out.println("Total crates from all houses = " + totalCrates);
        System.out.println("Max crates at any house = " + maxCrates);
        System.out.println("Min crates at any house = " + minCrates);

        if (housesWithMostRecycling.size() > 1) {
            String houses = "";
            System.out.print("Houses with most recycling = ");
            for (int x = 0; x < (housesWithMostRecycling.size() -1); x++) {
                houses += housesWithMostRecycling.get(x) + ", ";
            }
            houses += housesWithMostRecycling.get(housesWithMostRecycling.size() - 1);
            System.out.println(houses);
        }
        else {
            System.out.println("House with most recycling = " + housesWithMostRecycling.get(0).toString());
        }
        numberScanner.close();

    }

    // Ask user for number of crates for each house. Store in array and return this array.
    public static int[] getRecyclingPerHouse(int houses) {
        int[] data = new int[houses];
        for (int x = 0; x < data.length; x++) {
            System.out.println("How many recycling crates are " +
                    "set out for House #" + x + "?");
            int input = numberScanner.nextInt();
            data[x] = input;
        }
        return data;
    }

    //Add up all of the numbers in the array and return that
    public static int calculateTotal(int[] cratesPerHouse) {
        int total = 0;
        for (int x : cratesPerHouse) {
            total += x;
        }
        return total;
    }

    //Which is the largest number in the array?
    public static int calculateMax(int[] cratesPerHouse) {
        int max = 0;
        for (int x : cratesPerHouse) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    //Which is the smallest number in the array?
    public static int calculateMin(int[] cratesPerHouse) {
        int min = cratesPerHouse[0];
        for (int x : cratesPerHouse) {
            if (x < min) {
                min = x;
            }
        }
       return min;

    }

    //Use the array to figure out which house number - or array element number - has the most recycling
    public static ArrayList calculateHouseWithMostRecycling(int[] cratesPerHouse, int max) {
        ArrayList<Integer> housesWithMost = new ArrayList<>();
        for (int x = 0; x < cratesPerHouse.length; x++) {
            if (cratesPerHouse[x] == max) {
                housesWithMost.add(x);
            }
        }

        // return ArrayList?
       return housesWithMost;
    }
}
