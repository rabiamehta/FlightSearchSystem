package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Flight;
import com.nagarro.resultsorter.Sorter;
import com.nagarro.services.FlightSearchService;
import com.nagarro.utility.Constant;
import com.nagarro.utility.FlightInputValidator;

@Controller
public class FlightSearchScreenController {
	@Autowired
	private FlightSearchService flightSearchService;

	@RequestMapping(value = "/flightsearchscreen")
	public ModelAndView welcomePage(@ModelAttribute("inputfromuser") Flight flight) {
		System.out.println("inside flight search controller");
		ModelAndView modelAndView;
		System.out.println(flight);
		if (FlightInputValidator.validateInput(flight)) {
			System.out.println("valid flight input");
			List<Flight> list = flightSearchService.availableFlights(flight);
			modelAndView = new ModelAndView(Constant.FLIGHTSEARCHSCREEN);
			if (list != null && !CollectionUtils.isEmpty(list)) {
				list = Sorter.sortResult(list, flight.getOutputPreference());
				modelAndView.addObject(Constant.LIST, list);
			} else {
				modelAndView.addObject(Constant.ERRORMESSAGE, Constant.MESSAGE);
			}
		} else {
			System.out.println("here in else ");
			modelAndView = new ModelAndView(Constant.FLIGHTSEARCHSCREEN);
		}
		System.out.println("moving out from flight search contrller");
		return modelAndView;
	}
}