/**
 *
 */
package com.epam.pp.hasan;

import com.epam.pp.hasan.actions.*;
import com.epam.pp.hasan.controllers.FrontController;
import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.facade.service.BasketService;
import com.epam.pp.hasan.facade.service.OrderService;
import com.epam.pp.hasan.facade.service.impl.BasketServiceImpl;
import com.epam.pp.hasan.facade.service.impl.OrderServiceImpl;
import com.epam.pp.hasan.facade.service.impl.ProductServiceImpl;
import com.epam.pp.hasan.network.actions.ActionCount;
import com.epam.pp.hasan.network.actions.ActionItem;
import com.epam.pp.hasan.network.actions.ActionNotFound;
import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.server.Server;
import com.epam.pp.hasan.network.server.factory.impl.HttpServerFactory;
import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.network.views.ViewCount;
import com.epam.pp.hasan.network.views.ViewItem;
import com.epam.pp.hasan.facade.repository.basket.BasketRepository;
import com.epam.pp.hasan.facade.repository.basket.BasketRepositoryImpl;
import com.epam.pp.hasan.facade.repository.order.OrderRepository;
import com.epam.pp.hasan.facade.repository.order.OrderRepositoryImpl;
import com.epam.pp.hasan.facade.repository.product.ProductRepository;
import com.epam.pp.hasan.facade.repository.product.ProductRepositoryImpl;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.strategy.ConsoleRefl;
import com.epam.pp.hasan.strategy.GenerateRefl;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.views.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Yosin_Hasan
 */
public class Demo {
	/**
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
		OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl());
		BasketService basketService = new BasketServiceImpl(new BasketRepositoryImpl());
		ConsoleProductFacade facade = new ConsoleProductFacade(productService, orderService, basketService);
		FrontController controller = new FrontController();
		NetController netController = new NetController(Type.HTTP);
		Scanner sc = new Scanner(System.in);
		init(controller, facade);
		initNetwork(netController, facade);
		Server server = new Server(Constants.PORT, new HttpServerFactory(), netController);
		server.start();
		Integer num = 0;
		controller.start(num);
		while (sc.hasNext()) {
			try {
				num = Integer.parseInt(sc.next());
				controller.start(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
	private static void initNetwork(NetController controller, ConsoleProductFacade facade) {

		Map<String, com.epam.pp.hasan.network.actions.Action> actions = new TreeMap<String, com.epam.pp.hasan.network.actions.Action>();
		Map<String, com.epam.pp.hasan.network.views.View> views = new TreeMap<String, com.epam.pp.hasan.network.views.View>();
		actions.put(Fields.ACTION_NOTFOUND, new ActionNotFound(facade));
		actions.put(Fields.NETWORK_ACTION_COUNT, new ActionCount(facade));
		actions.put(Fields.NETWORK_ACTION_ITEM, new ActionItem(facade));
		views.put(Fields.ACTION_NOTFOUND, new com.epam.pp.hasan.network.views.ViewNotFound());
		views.put(Fields.NETWORK_ACTION_COUNT, new ViewCount());
		views.put(Fields.NETWORK_ACTION_ITEM, new ViewItem());
		controller.setActionHolder(new com.epam.pp.hasan.network.actions.ActionHolder(actions));
		controller.setViewResolver(new com.epam.pp.hasan.network.views.ViewResolver(views));
	}
	private static void init(FrontController controller, ConsoleProductFacade facade) {
		Map<Integer, Action> actions = new TreeMap<Integer, Action>();
		Map<String, View> views = new TreeMap<String, View>();
		int k = 0;
		actions.put(k++, new ActionIndex(facade));
		actions.put(k++, new ActionProducts(facade));
		actions.put(k++, new ActionProduct(facade));
		actions.put(k++, new ActionTopProducts(facade));
		actions.put(k++, new ActionBasket(facade));
		actions.put(k++, new ActionOrders(facade));
		actions.put(k++, new ActionOrdersByDate(facade));
		actions.put(k++, new ActionOrdersByDateTime(facade));
		actions.put(k++, new ActionAddProductToBasket(facade));
		actions.put(k++, new ActionCompleteOrder(facade));
		actions.put(k++, new ActionAddProduct(facade));
		actions.put(k, new ActionExit(facade));
		actions.put(404, new Action404(facade));
		views.put(Fields.ACTION_INDEX, new ViewIndex());
		views.put(Fields.ACTION_NOTFOUND, new ViewNotFound());
		views.put(Fields.ACTION_PRODUCTS, new ViewProducts());
		views.put(Fields.ACTION_PRODUCT, new ViewProduct());
		views.put(Fields.ACTION_TOP_PRODUCTS, new ViewTopProducts());
		views.put(Fields.ACTION_BASKET, new ViewBasket());
		views.put(Fields.ACTION_ORDERS, new ViewOrders());
		views.put(Fields.ACTION_ORDERS_BY_DATE, new ViewOrdersDate());
		views.put(Fields.ACTION_ORDERS_BY_DATETIME, new ViewOrdersDatetime());
		views.put(Fields.ACTION_ADD_TO_BASKET, new ViewAddBasket());
		views.put(Fields.ACTION_COMPLETE_ORDER, new ViewCompleteOrder());
		views.put(Fields.ACTION_ADD_PRODUCT, new ViewAddProduct());
		views.put(Fields.ACTION_EXIT, new ViewExit());
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 1", "Nokia lumia", 600, 0));
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 2", "Nokia lumia", 800, 0));
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 3", "Nokia lumia", 4200, 0));
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 4", "Nokia lumia", 3200, 0));
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 5", "Nokia lumia", 2200, 0));
		facade.getProductService().addProduct(new Product(k++, "Nokia lumia 6", "Nokia lumia", 1200, 0));

		HashMap<Integer, String> types = new HashMap<Integer, String>();
		k = 0;
		types.put(k++, "Computer");
		types.put(k, "Phone");
		Integer opt = ConsoleHelper.getInt("How to add products Console/Auto? (0/1)");
		AddProduct prod = null;
		if (opt.equals(0)) {
			prod = new AddProduct(new ConsoleRefl(types));
		} else {
			prod = new AddProduct(new GenerateRefl(types));
		}
		controller.setAddProductMethod(prod);
		controller.setActionHolder(new ActionHolder(actions));
		controller.setViewResolver(new ViewResolver(views));

	}
}
