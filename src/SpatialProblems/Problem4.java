package SpatialProblems;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
	
	public static boolean verifyJensExchangeRules(ArrayList<String[]> pairs,
			ArrayList<String[]> family,
			ArrayList<String[]> previouspairs) {
		return PassesRule6(pairs, previouspairs) && Problem3.verifyDebrasCircularExchangeRules(pairs, family);
	}
	
	public static boolean PassesRule6(ArrayList<String[]> pairs, ArrayList<String[]> previouspairs) {
		for(int i=0; i<pairs.size(); i++) {
			if(findFirstOccurenceSender(pairs.get(i)[0], previouspairs)!= -1) {
				if(previouspairs.get(findFirstOccurenceSender(pairs.get(i)[0], previouspairs))[1].equals(pairs.get(i)[1]))
					return false;
			}
		}
		return true;
	}
	
	public static int findFirstOccurenceSender(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str.equals(pair.get(i)[0]))
				 return i;
		 }
			 return -1;
	 }

}
