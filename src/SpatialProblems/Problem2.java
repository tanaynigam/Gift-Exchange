package SpatialProblems;
import java.util.ArrayList;
import java.util.List;
import static SpatialProblems.Problem1.*;

public class Problem2 {

    public static boolean verifyProblem2(ArrayList<String[]> pairs, ArrayList<String[]> family) {
        return Problem1.verifyExchangeRules(pairs) && PassesRule4(pairs,family);
    }

    public static ArrayList<String[]> computePairs(ArrayList<String[]> family) {
        ArrayList<String> members = new ArrayList<String>();
        for( String[] val : family)
            members.add(val[0]);
        // Compute all possible permutations of receivers
        ArrayList<ArrayList<String>> allReceiverCombinations = calculateAllReceiverPermutations(members);
        ArrayList<Integer> violations = new ArrayList<Integer>();
        ArrayList<ArrayList<String[]>> validPairs = new ArrayList<ArrayList<String[]>>();
        // Create a List of all valid pairs
        for (ArrayList<String> val:allReceiverCombinations) {
            ArrayList<String[]> create_pair = new ArrayList<String[]>();
            for(int i = 0; i < val.size();i++ ) {
                String[] pair = new String[2];
                pair[0] = family.get(i)[0];
                pair[1] = val.get(i);
                create_pair.add(pair);
            }
            if(PassesRule1(create_pair) &&
                    PassesRule2(create_pair) &&
                    PassesRule3(create_pair) &&
                    PassesBasicRule(create_pair)) {
                violations.add(calculateRule4Violations(create_pair,family));
                validPairs.add(create_pair);
            }
        }
        //Compute The min no of violations
        int minIndex = 0;
        for(int i = 0 ; i < violations.size();i++)
            if(violations.get(minIndex) > violations.get(i))
                minIndex = i;
        //return the valid pair with the min no of violations
        return validPairs.get(minIndex);
    }

    public static ArrayList<ArrayList<String>> calculateAllReceiverPermutations(ArrayList<String> members) {
        if (members.size() == 0) {
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            result.add(new ArrayList<String>());
            return result;
        }
        ArrayList<ArrayList<String>> returnMe = new ArrayList<ArrayList<String>>();
        String firstElement = members.remove(0);
        ArrayList<ArrayList<String>> recursiveReturn = calculateAllReceiverPermutations(members);
        for (ArrayList<String> li : recursiveReturn) {

            for (int index = 0; index <= li.size(); index++) {
                ArrayList<String> temp = new ArrayList<String>(li);
                temp.add(index, firstElement);
                returnMe.add(temp);
            }
        }
        return returnMe;
    }


    public static boolean PassesRule4(ArrayList<String[]> pairs, ArrayList<String[]> family) {
        for(int i = 0 ; i < pairs.size(); i++) {
            if(!checkIfGivenPairPasses(pairs.get(i),family))
                return false;
        }
        return true;
    }

    public static int calculateRule4Violations(ArrayList<String[]> pairs, ArrayList<String[]> family) {
        int violations = 0;
        for(int i = 0 ; i < pairs.size(); i++) {
            if(!checkIfGivenPairPasses(pairs.get(i),family))
                 violations++;
        }
        return violations;
    }

    private static boolean checkIfGivenPairPasses(String[] pair,ArrayList<String[]> family) {
        if(family.get(findSenderIndex(pair[0], family))[1].equals(family.get(findSenderIndex(pair[1], family))[1])) {
            return false;
        }
        return true;
    }

    private static int findSenderIndex(String str, ArrayList<String[]> family){
        for(int i=0; i<family.size(); i++) {
            if(str.equals(family.get(i)[0]))
                return i;
        }
        return 0;
    }
}
