package controller;

import model.memberModel;

public interface memberInterface {
	//C
	public boolean create(memberModel mm);
	//R
	public memberModel read(Integer num);
	//U
	public boolean update(memberModel mm);
	//D
	public boolean delete(Integer num);
}
