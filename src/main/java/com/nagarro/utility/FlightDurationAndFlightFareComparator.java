package com.nagarro.utility;

import java.util.Comparator;

import com.nagarro.model.Flight;

public class FlightDurationAndFlightFareComparator implements Comparator<Flight> {

	public int compare(Flight o1, Flight o2) {
		if (Integer.parseInt(o1.getFare()) == Integer.parseInt(o2.getFare()))
			return o1.getFlightDuration().compareTo(o2.getFlightDuration());
		return Integer.parseInt(o1.getFare()) - Integer.parseInt(o2.getFare());
	}
}
