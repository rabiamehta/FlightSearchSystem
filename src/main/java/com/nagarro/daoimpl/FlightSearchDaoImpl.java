package com.nagarro.daoimpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.FlightSearchDao;
import com.nagarro.model.Flight;

@Repository
public class FlightSearchDaoImpl implements FlightSearchDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Flight> availableFlights(Flight flight) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		System.out.println("inside flight search dao impl");
		if (flight.getFlightClass().equals("E")) {
			query = session.createQuery("from com.nagarro.model.Flight UID where UID.arrivalLocation=\'"
					+ flight.getArrivalLocation() + "\' and UID.departureLocation=\'" + flight.getDepartureLocation()
					+ "\'and UID.flightClass=\'" + flight.getFlightClass() + "\'and UID.validTill>="
					+ flight.getFlightDate());
		} else if (flight.getFlightClass().equals("EB")) {
			query = session.createQuery("from com.nagarro.model.Flight UID where UID.arrivalLocation=\'"
					+ flight.getArrivalLocation() + "\' and UID.departureLocation=\'" + flight.getDepartureLocation()
					+ "\'and( UID.flightClass=\'" + flight.getFlightClass() + "\' or UID.flightClass=\'" + "E"
					+ "\')and UID.validTill>=" + flight.getFlightDate());
		}
		System.out.println("moving out from flight search dao impl");
		return query.list();
	}

}
