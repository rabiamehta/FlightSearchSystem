package com.nagarro.dao;

import java.util.List;
import com.nagarro.model.Flight;

public interface FlightSearchDao
{
	public List<Flight> availableFlights(Flight flight);
}
