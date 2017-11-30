package SpatialApplication;

import SpatialProblems.Problem1;
import SpatialProblems.Problem2;
import SpatialProblems.Problem3;
import SpatialProblems.Problem4;
import SpatialProblems.Problem5;

import java.util.ArrayList;

public class Solution {

    //Problem 1:
    public static boolean verifyExchangeRules(ArrayList<String[]> pairs) {
        return Problem1.verifyExchangeRules(pairs);
    }
    
    public static void createValidPairs(ArrayList<String[]> family) {
        ArrayList<String> members = new ArrayList<String>();
        for( String[] val : family)
            members.add(val[0]);
        ArrayList<String[]> pairs = Problem1.computePairs(members);
        printList(pairs);
    }

    //Problem 2:
    public static boolean verifyDebrasExchangeRules(ArrayList<String[]> pairs,
                                                    ArrayList<String[]> family) {
        return Problem2.verifyProblem2(pairs, family);
    }

    public static void createDebrasPairs(ArrayList<String[]> family) {
    	ArrayList<String[]> pairs = Problem2.computePairs(family);
        printList(pairs);
    }

    //Problem 3:
    public static boolean verifyDebrasCircularExchangeRules(ArrayList<String[]> pairs,
                                                            ArrayList<String[]> family) {
        return Problem3.verifyDebrasCircularExchangeRules(pairs, family);
    }

    public static void  createDebrasCircularPairs(ArrayList<String[]> family) {
        System.out.println("No Implementation");
    }

    //Problem 4:
    public static boolean verifyJensExchangeRules(ArrayList<String[]> pairs,
                                                  ArrayList<String[]> family,
                                                  ArrayList<String[]> previouspairs) {
        return Problem4.verifyJensExchangeRules(pairs, family, previouspairs);
    }

    public static void  createJensPairs(ArrayList<String[]> family,
                                        ArrayList<String[]> previouspairs) {
        System.out.println("No Implementation");
    }

    //problem 5:
    public static boolean verifyDebraJensExchangeRules(ArrayList<String[]> pairs,
                                                       ArrayList<String[]> family,
                                                       ArrayList<String[]> previouspairs,
                                                       ArrayList<String[]> badpairs,
                                                       ArrayList<String[]> goodpairs) {
        return Problem5.verifyDebraJensExchangeRules(pairs, family, previouspairs, badpairs, goodpairs);
    }

    public static void  createDebraJensPairs(ArrayList<String[]> family,
                                             ArrayList<String[]> previouspairs,
                                             ArrayList<String[]> badpairs,
                                             ArrayList<String[]> goodpairs) {
        System.out.println("No Implementation");
    }

    //problem 6:
    public static void  createDebraJensPenaltyPairs(ArrayList<String[]> family,
                                             ArrayList<String[]> previouspairs,
                                             ArrayList<String[]> badpairs,
                                             ArrayList<String[]> goodpairs) {
        System.out.println("No Implementation");
    }

    private static void printList(ArrayList<String[]> family) {
        for( String[] val : family) {
            for(int i = 0 ; i < val.length;i++) {
                if (i == val.length-1)
                    System.out.print(val[i]);
                else
                    System.out.print(val[i]+",");
            }
            System.out.println();
        }

    }
}