package com.nagarro.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.dao.FlightSearchDao;
import com.nagarro.model.Flight;
import com.nagarro.services.FlightSearchService;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {
	@Autowired
	private FlightSearchDao flightSearchDao;

	public void setFlightSearchDao(FlightSearchDao flightSearchDao) {
		this.flightSearchDao = flightSearchDao;
	}

	@Transactional(readOnly = true)
	public List<Flight> availableFlights(Flight flight) {
		System.out.println("in flight service impl");
		return flightSearchDao.availableFlights(flight);
	}

}
