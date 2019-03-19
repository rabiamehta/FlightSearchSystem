package com.nagarro.resultsorter;

import java.util.Comparator;
import java.util.List;

import com.nagarro.model.Flight;
import com.nagarro.utility.FareComparator;

public class Sorter {
	public static List<Flight> sortResult(List<Flight> list, String outputPreference) {
		if (outputPreference.equals("FARE")) {
			list.sort(FareComparator::compare);
		} else if (outputPreference.equals("FARE_AND_FLIGHT_DURATION")) {
			list.sort(Comparator.comparing(Flight::getFlightDuration).thenComparing(FareComparator::compare));
		}
		return list;
	}
}
