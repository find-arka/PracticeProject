package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bo.Human;

public class HackerRankApplication2 {

	public static void main(String[] args) {
		
	}

	public static List<String> blah(String s) {
		List <String> subsequencesList = new ArrayList<>();
		for (int i=0; i<s.length();i++) {
			subsequencesList.add(s.substring(i, i));
			for (int j=i+1;j<s.length();j++) {
				subsequencesList.add(s.subSequence(i, j).toString());
			}
		}
		subsequencesList.add(s);		
		Collections.sort(subsequencesList);
		return subsequencesList;
	}
}
