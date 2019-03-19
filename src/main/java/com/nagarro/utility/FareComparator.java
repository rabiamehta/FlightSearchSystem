package com.nagarro.utility;

import com.nagarro.model.Flight;

public class FareComparator {

	static public int compare(Flight o1, Flight o2) {
		return (Integer.parseInt(o1.getFare()) - Integer.parseInt(o2.getFare()));
	}
}
