package SpatialProblems;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	public static boolean verifyDebrasCircularExchangeRules(ArrayList<String[]> pairs, ArrayList<String[]> family) {
		String[] names = new String[pairs.size()+1]; 
		names[0] = (pairs.get(0)[0]);
		for(int i=0; i<pairs.size(); i++) {
			names[i+1] = pairs.get(findFirstOccurenceSender(names[i], pairs))[1];
		}
		if(names[pairs.size()] == names[0]) {
			return true;
		}
		return false;//(Problem1.verifyExchangeRules(pairs));// && Problem2.verifyDebrasExchangeRules(pairs, family));
	}
	
	public static int findFirstOccurenceSender(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str == pair.get(i)[0])
				 return i;
		 }
			 return 0;
	 }
}
