package SpatialProblems;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

	 public static boolean verifyDebraJensExchangeRules(ArrayList<String[]> pairs,
             ArrayList<String[]> family,
             ArrayList<String[]> previouspairs,
             ArrayList<String[]> badpairs,
             ArrayList<String[]> goodpairs) {
		 return /*PassesRule7(pairs, badpairs) &&*/ PassesRule8(pairs, goodpairs);
	 }
	 
	 public static boolean PassesRule7(ArrayList<String[]> pairs, ArrayList<String[]> badpairs) {
		 for(int i=0; i<pairs.size(); i++) {
				if(findFirstOccurenceSender(pairs.get(i)[0], badpairs)!= -1) {
					if(badpairs.get(findFirstOccurenceSender(pairs.get(i)[0], badpairs))[1].equals(pairs.get(i)[1]))
						return false;
				}
			}
			return true;
	 }
	 
	 public static boolean PassesRule8(ArrayList<String[]> pairs, ArrayList<String[]> goodpairs) {
		 for(int i=0; i<goodpairs.size(); i++) {
				if(findFirstOccurenceSender(goodpairs.get(i)[0], pairs)!= -1) {
					if(!goodpairs.get(findFirstOccurenceSender(pairs.get(i)[0], goodpairs))[1].equals(pairs.get(i)[1]))
						return false;
				}
				else
					return false;
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
