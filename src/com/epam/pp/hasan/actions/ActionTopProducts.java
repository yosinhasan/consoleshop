package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ActionTopProducts extends Action {

	public ActionTopProducts(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		request.set("top", productFacade.findTopProducts());
		return Fields.ACTION_TOP_PRODUCTS;
	}

}
