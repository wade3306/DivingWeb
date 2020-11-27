package controller;

import model.supplierModel;

public interface supplierInterface {
	// C
	public boolean create(supplierModel sm);

	// R
	public supplierModel read(Integer supplierNum);

	// U
	public boolean update(supplierModel sm);

	// D
	public boolean delete(Integer supplierNum);
}
