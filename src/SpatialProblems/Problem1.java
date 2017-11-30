package SpatialProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Problem1 {
	
	public static boolean verifyExchangeRules(List<String[]> pairs){
		List<String[]> temp = new ArrayList<String[]>();
		int n = pairs.size();
		boolean rule1 = T1Rule1(pairs, n);
		boolean rule2 = T1Rule2(pairs, n);
		boolean rule3 = T1Rule3(pairs, n);
		if(rule1 == true && rule2 == true && rule3 == true)
			return true;
		else
			return false;
	}
	
	public static List<String[]> printTask1(List<String[]> pairs){
		List<String[]> temp = new ArrayList<String[]>();
		int n = pairs.size();
		pairs = T2Rule1(pairs, n);
		n = pairs.size();
		pairs = T2Rule2(pairs, n);
		n = pairs.size();
		pairs = T2Rule3(pairs, n);
		return temp;
	}
	
	public static List<String[]> printValidPairs(List<String[]> family){
		int n = family.size();
		ArrayList<String[]> pairs = new ArrayList<String[]>();
		List<String[]> temp = new ArrayList<String[]>();
		temp = family;
		String[] new_pair = new String[2];
		boolean[] receiver = new boolean[family.size()];
		Random rand = new Random();
		int i=0;
		
		while(i<family.size()) {
			int random = ThreadLocalRandom.current().nextInt(0, n);
			if(random>i) {
					new_pair[0] = family.get(i)[0];
					new_pair[1] = temp.get(random)[0];
//					System.out.println(family.get(i)[0]+" "+temp.get(random)[0]);
					temp.remove(random);
					n--;
					i++;
					pairs.add(new_pair);
					System.out.println(i+" "+pairs.get(i)[0]+" "+pairs.get(i)[1]);
			} else if(random<i){
				if(pairs.get(random)[1] != family.get(i)[0]) {
					new_pair[0] = family.get(i)[0];
					new_pair[1] = temp.get(random)[0];
//					System.out.println(family.get(i)[0]+" "+temp.get(random)[0]);
					temp.remove(random);
					n--;
					i++;
					pairs.add(new_pair);
					System.out.println(i+" "+pairs.get(i)[0]+" "+pairs.get(i)[1]);
				}
				else
					System.out.println(i);
			} else
				System.out.println(i);
		}
		for(int j=0; j<pairs.size();j++) {
			System.out.println(pairs.get(j)[0]+" "+pairs.get(j)[1]);
		}
		
		return pairs;
	}
	
	public static boolean T1Rule1(List<String[]> pairs, int n) {
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(pairs.get(i)[0] == pairs.get(j)[1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean T1Rule2(List<String[]> pairs, int n) {
		String[] visited =  new String[10000];
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
	
	public static boolean T1Rule3(List<String[]> pairs, int n) {
		String[] visited =  new String[10000];
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
	
	public static List<String[]> T2Rule1(List<String[]> pairs, int n) {
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(pairs.get(i)[0] == pairs.get(j)[1]) {
					pairs.remove(i);
					pairs.remove(j-1);
					n=n-2;
				}
			}
		}
		return pairs;
	}
	
	public static List<String[]> T2Rule2(List<String[]> pairs, int n) {
		String[] visited =  new String[10000];
		String[] remove = new String[1000];
		int index=0;
		int count = 0;
		for(int i=0; i<pairs.size(); i++) {
			if(contains(visited, pairs.get(i)[0])){
				remove[index] = pairs.get(i)[0];
				index++;
//				pairs.remove(findFirstOccurenceSender(pairs.get(i)[0], pairs));
//				pairs.remove(i-1);
			}
			else{
				visited[count] = pairs.get(i)[0];
				count++;
			}
		}
		for(int i=0; i<index; i++) {
			while(findFirstOccurenceSender(remove[i], pairs)!=-1) {
				pairs.remove(findFirstOccurenceSender(remove[i], pairs));
			}
		}
		return pairs;
	}
	
	public static List<String[]> T2Rule3(List<String[]> pairs, int n) {
		String[] visited =  new String[10000];
		String[] remove = new String[1000];
		int index=0;
		int count=0;
		for(int i=0; i<pairs.size(); i++) {
			if(contains(visited, pairs.get(i)[1])) {
				remove[index] = pairs.get(i)[1];
				index++;
//				pairs.remove(findFirstOccurenceReceiver(pairs.get(i)[1], pairs));
//				pairs.remove(i-1);
			}
			else{
				visited[count] = pairs.get(i)[1];
				count++;
			}
		}
		for(int i=0; i<index; i++) {
			while(findFirstOccurenceReceiver(remove[i], pairs)!=-1) {
				pairs.remove(findFirstOccurenceReceiver(remove[i], pairs));
			}
		}
		return pairs;
	}
	
	
	 public static boolean contains(String[] arr, String item) {
	      for (String n : arr) {
	         if (item == n) {
	            return true;
	         }
	      }
	      return false;
	   }
	 
	 public static int findFirstOccurenceSender(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str == pair.get(i)[0])
				 return i;
		 }
			 return -1;
	 }
	 
	 public static int findFirstOccurenceReceiver(String str, List<String[]> pair){
		 for(int i=0; i<pair.size(); i++) {
			 if(str == pair.get(i)[1])
				 return i;
		 }
			 return -1;
	 }


}
