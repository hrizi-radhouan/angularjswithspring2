package com.mass.test2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VariablesListController {
	private VariablesListModel variablesListModel;

	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.GET)
	public String showForm() {
		return "AddUser";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		variablesListModel = new VariablesListModel();
		variablesListModel.initialize();
		model.addAttribute("variablesListModel", variablesListModel);
		return "AddUser";
	}

	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)

	public @ResponseBody String addUser(@RequestBody Variable selectedVar) {
		String returnText;
		variablesListModel.addSelectedVariable(selectedVar);

		System.out.println("selectedVar =" + selectedVar);
		returnText = variablesListModel.getListVaraiblesSelectedJSON();

		return returnText;
	}

	@RequestMapping(value = "/DeleUser.htm", method = RequestMethod.POST)
	public @ResponseBody String DeleUser(@RequestBody Variable selectedVar) {
		String returnText;

		variablesListModel.removeSelectedVariable(selectedVar);

		returnText = variablesListModel.getListVaraiblesSelectedJSON();

		return returnText;
	}
}
