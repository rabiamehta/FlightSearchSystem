package com.nagarro.services;

import java.util.List;

import com.nagarro.model.Flight;

public interface FlightSearchService 
{
	public List<Flight> availableFlights(Flight flight);
}
