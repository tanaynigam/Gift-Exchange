package SpatialProblems;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	
	 public static boolean verifyProblem2(ArrayList<String[]> pairs, ArrayList<String[]> family) {
	        return Problem1.verifyExchangeRules(pairs) && PassesRule4(pairs,family);
	    }

	    public static ArrayList<String[]> computePairs(ArrayList<String[]> family) {
	        ArrayList<String> members = new ArrayList<String>();
	        for( String[] val : family)
	            members.add(val[0]);
	        ArrayList<String[]> pairs =  Problem1.computePairs(members);
	        //Remove all pairs that do not follow Rule 4
	        ArrayList<String[]> pairs_to_replace = new ArrayList<String[]>();
	        for (String [] single_pair: pairs){
	            if(!checkIfGivenPairPasses(single_pair,family)) {
	                pairs_to_replace.add(single_pair);
	            }
	        }
	        return pairs_to_replace;
	    }

	    public static boolean PassesRule4(ArrayList<String[]> pairs, ArrayList<String[]> family) {
	        for(int i = 0 ; i < pairs.size(); i++) {
	            if(!checkIfGivenPairPasses(pairs.get(i),family))
	                return false;
	        }
	        return true;
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
