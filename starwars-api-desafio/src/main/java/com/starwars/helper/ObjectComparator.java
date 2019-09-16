package com.starwars.helper;

import java.util.Comparator;

import com.starwars.model.People;

public class ObjectComparator implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2) {
	   	People myObj1 = (People)o1;
    	People myObj2 = (People)o2;
    	int result = myObj1.getAmount_films().compareTo(myObj2.getAmount_films());
        if (result == 0) {
            // Strings are equal, sort by date
            return myObj1.getName().compareTo(myObj2.getName());
        }
        else {
            return result;
        }
	}

}
