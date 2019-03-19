package com.nagarro.utility;

import com.nagarro.model.Flight;

public class FlightInputValidator {
	public static boolean validateInput(Flight flight) {
		boolean result = true;
		if (flight.getArrivalLocation() == null || flight.getDepartureLocation() == null
				|| flight.getFlightDate() == null || flight.getClass() == null
				|| flight.getOutputPreference() == null) {
			result = false;
		}
		return result;
	}
}
