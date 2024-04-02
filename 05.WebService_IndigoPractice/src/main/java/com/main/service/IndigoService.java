package com.main.service;

import java.util.List;

import com.main.model.Flight;
import com.main.model.Passanger;

public interface IndigoService {

	public void saveData(Flight flight);

	public List<Flight> getData();

	public List<Flight> getData(String fromLocation, String toLocation);

	public void savePassanger(Passanger passanger);

	public Passanger getPassanger(String pName);

}
