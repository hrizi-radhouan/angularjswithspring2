package com.mass.test2;

import java.util.ArrayList;
import java.util.List;

public class VariablesListModel {

	private List<Variable> listVaraibles;
	private List<Variable> listSelectedVaraibles;
	private int numberSelectedVariables;

	public VariablesListModel() {

	}

	public List<Variable> getListVaraibles() {
		return listVaraibles;
	}

	public void setListVaraibles(List<Variable> listVaraibles) {
		this.listVaraibles = listVaraibles;
	}

	public int getNumberSelectedVariables() {
		return numberSelectedVariables;
	}

	public void setNumberSelectedVariables(int numberSelectedVariables) {
		this.numberSelectedVariables = numberSelectedVariables;
	}

	public void initialize() {
		listVaraibles = new ArrayList<Variable>();
		listSelectedVaraibles = new ArrayList<Variable>();
		Variable var = new Variable();
		var.setId("name123");
		var.setName("Youtube spend 2016");
		var.setMiniBudget("1000");
		var.setMaxBudget("50000");
		listVaraibles.add(var);
		Variable var2 = new Variable();
		var2.setId("name124");
		var2.setName("Facebook spend 2016");
		var2.setMiniBudget("2000");
		var2.setMaxBudget("60000");
		listVaraibles.add(var2);
		Variable var3 = new Variable();
		var3.setId("name129");
		var3.setName("NatGeo spend 2015");
		var3.setMiniBudget("1500");
		var3.setMaxBudget("40000");
		listVaraibles.add(var3);
		Variable var4 = new Variable();
		var4.setId("name127");
		var4.setName("Fr2 spend 2017");
		var4.setMiniBudget("1500");
		var4.setMaxBudget("40000");
		listVaraibles.add(var4);

	}

	public boolean addSelectedVariable(Variable variable) {
		boolean res = false;

		if (this.listSelectedVaraibles.add(variable)) {

			incre();
			res = true;
		}

		return res;
	}

	public boolean removeSelectedVariable(Variable variable) {
		int count = 0;
		boolean test = true;
		while (test && count < listSelectedVaraibles.size()) {
			if (!(variable.getId().equals(listSelectedVaraibles.get(count).getId()))) {
				count++;
			} else {
				test = false;

				listSelectedVaraibles.remove(count);
				System.out.println(" Delete done" + listSelectedVaraibles.toString());
				decre();

			}
		}

		return !test;
	}

	public String getListVaraiblesSelectedJSON() {

		String res = "";
		for (Variable item : listSelectedVaraibles) {
			res = res + item.getId() + ":" + item.getName() + ":" + item.getMiniBudget() + ":" + item.getMaxBudget()
					+ ";";
			System.out.println(" name :" + item.getName());
		}

		res = res.substring(0, res.length() - 1);
		return res;
	}

	public void incre() {
		this.numberSelectedVariables++;
	}

	public void decre() {
		this.numberSelectedVariables--;
	}

}
