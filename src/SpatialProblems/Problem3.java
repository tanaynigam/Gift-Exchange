package SpatialProblems;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	public static boolean verifyDebrasCircularExchangeRules(ArrayList<String[]> pairs, ArrayList<String[]> family) {
		return Problem2.verifyProblem2(pairs, family) && PassesRule5(pairs, family);
	}
	
	public static boolean PassesRule5(ArrayList<String[]> pairs, ArrayList<String[]> family) {
		String[] names = new String[pairs.size()+1]; 
		names[0] = (pairs.get(0)[0]);
		for(int i=0; i<pairs.size(); i++) {
			names[i+1] = pairs.get(findFirstOccurenceSender(names[i], pairs))[1].trim();
		}
		if(names[pairs.size()].equals(names[0])) {
			return true;
		}
		return false;
	}
	
	public static int findFirstOccurenceSender(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str.equals(pair.get(i)[0]))
				 return i;
		 }
			 return 0;
	 }
}
