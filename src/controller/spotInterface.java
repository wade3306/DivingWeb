package controller;

import java.util.ArrayList;

import model.spotModel;

public interface spotInterface {
	//C
	//R
	public spotModel readId(Integer num);
	
	public ArrayList<spotModel> readSpot(String spotCity, String spotArea);
	
	public ArrayList<spotModel> readAllSpot() ;
	//U
	//D
}
