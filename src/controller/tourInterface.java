package controller;

import java.util.ArrayList;

import model.tourModel;
import model.tourspotModel;

public interface tourInterface {
		// C
		public boolean create(tourModel tm);

		// R tour
		public ArrayList<tourModel> tourRead(Integer tourSize,Integer tourPriceMin,Integer tourPriceMax);
		public ArrayList<tourModel> tourRead(Integer spotNum);

		// R supplier
		public ArrayList<tourModel> supplierRead(Integer supplierNum);

		// U
		public boolean update(tourModel tm);

		// D tour
		public boolean deletetour(Integer tourNum);

		// D tourspot
		public boolean deletetourspot(Integer tourspotNum);
}
