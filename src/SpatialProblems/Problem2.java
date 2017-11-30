package SpatialProblems;
import java.util.List;

public class Problem2 {
	
	public static boolean verifyDebrasExchangeRules(List<String[]> pairs, List<String[]> family) {
		for(int i=0; i<pairs.size(); i++) {
			//System.out.println(family.get(findFirstOccurenceSender(pairs.get(i)[0], family))[1]+" "+ family.get(findFirstOccurenceSender(pairs.get(i)[1], family))[1]);
			if(family.get(findFirstOccurenceSender(pairs.get(i)[0], family))[1] == family.get(findFirstOccurenceSender(pairs.get(i)[1], family))[1]) {
				return false;
			}
		}
		return Problem1.verifyExchangeRules(pairs);
	}

	void createDebrasPairs(List<String[]> pairs, List<String[]> family) {
		
	}
	
	public static int findFirstOccurenceSender(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str == pair.get(i)[0])
				 return i;
		 }
			 return 0;
	 }
}
