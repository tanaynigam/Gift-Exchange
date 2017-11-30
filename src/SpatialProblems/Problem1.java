package SpatialProblems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Problem1 {
	
	 public static boolean verifyExchangeRules(ArrayList<String[]> pairs){
	        boolean rule1 = PassesRule1(pairs);
	        boolean rule2 = PassesRule2(pairs);
	        boolean rule3 = PassesRule3(pairs);
	        return rule1 && rule2 && rule3;
	    }

	    public static ArrayList<String[]> computePairs(ArrayList<String> family) {
	        boolean[] receiver = new boolean[family.size()];
	        ArrayList<String[]> pairs =  new ArrayList<String[]>();

	        for ( int i = 0 ; i < family.size(); i++) {
	            int random_Receiver = ThreadLocalRandom.current().nextInt(0, family.size());
	            String[] single_pair = new String[2];
	            single_pair[0] = family.get(i);
	            single_pair[1] = family.get(random_Receiver);
	            pairs.add(single_pair);
	            // You cannot gift yourself
	            if(receiver[random_Receiver] ||
	                    !PassesRule1(pairs) ||
	                    !PassesRule2(pairs) ||
	                    !PassesRule3(pairs) ||
	                    random_Receiver == i) {
	                pairs.remove(single_pair);
	                i--;
	                continue;
	            }
	            receiver[random_Receiver] = true;
	        }
	        return pairs;
	    }

	    public static boolean PassesRule1(ArrayList<String[]> pairs) {
	        HashMap<String,String> occurance = new HashMap<String,String>();
	        for(int i=0; i<pairs.size(); i++) {
	            occurance.put(pairs.get(i)[0],pairs.get(i)[1]);
	        }
	        //Check for occurance in the hashmap where
	        for(int i=0; i<pairs.size(); i++) {
	            if(occurance.containsKey(occurance.get(pairs.get(i)[0])) &&
	                    pairs.get(i)[0].equals(occurance.get(occurance.get(pairs.get(i)[0]))))
	                return false;
	        }
	        return true;
	    }

	    public static boolean PassesRule2(List<String[]> pairs) {
	        String[] visited =  new String[pairs.size()];
	        int count = 0;
	        for(int i=0; i<pairs.size(); i++) {
	            if(contains(visited, pairs.get(i)[0]))
	                return false;
	            else {
	                visited[count] = pairs.get(i)[0];
	                count++;
	            }
	        }
	        return true;
	    }

	    public static boolean PassesRule3(List<String[]> pairs) {
	        String[] visited =  new String[pairs.size()];
	        int count=0;
	        for(int i=0; i<pairs.size(); i++) {
	            if(contains(visited, pairs.get(i)[1]))
	                return false;
	            else{
	                visited[count] = pairs.get(i)[1];
	                count++;
	            }
	        }
	        return true;
	    }

	    public static boolean contains(String[] arr, String item) {
	        for (String n : arr) {
	            if (item.equals(n)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static boolean PassesBasicRule(ArrayList<String[]> pairs) {
	        for(int i=0; i<pairs.size(); i++) {
	            if(pairs.get(i)[0].equals(pairs.get(i)[1]))
	                return false;
	        }
	        return true;
	    }

}
