package com.epam.pp.hasan.util;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.action.*;
import com.epam.pp.hasan.controller.FrontController;
import com.epam.pp.hasan.entity.Computer;
import com.epam.pp.hasan.entity.Phone;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.repository.basket.BasketRepositoryImpl;
import com.epam.pp.hasan.facade.repository.order.OrderRepositoryImpl;
import com.epam.pp.hasan.facade.repository.product.ProductRepositoryImpl;
import com.epam.pp.hasan.facade.service.BasketService;
import com.epam.pp.hasan.facade.service.OrderService;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.facade.service.impl.BasketServiceImpl;
import com.epam.pp.hasan.facade.service.impl.OrderServiceImpl;
import com.epam.pp.hasan.facade.service.impl.ProductServiceImpl;
import com.epam.pp.hasan.network.action.Action;
import com.epam.pp.hasan.network.action.ActionCount;
import com.epam.pp.hasan.network.action.ActionItem;
import com.epam.pp.hasan.network.action.ActionNotFound;
import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.network.view.ViewCount;
import com.epam.pp.hasan.network.view.ViewItem;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.strategy.impl.ConsoleRefl;
import com.epam.pp.hasan.strategy.impl.GenerateRefl;
import com.epam.pp.hasan.view.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Yosin_Hasan on 5/16/2016.
 */
public class InitializeConsole {
    private FrontController frontController;
    private NetController netController;
    private ConsoleProductFacade facade;
    private Type type;

    public InitializeConsole() {

    }

    public InitializeConsole(Type type) {
        this.type = type;
    }
    public void init() {
        initController();
        initFacade();
        initFrontController();
        initNetController();
    }
    private void initController() {
        if (type == null) {
            type = Type.HTTP;
        }
        frontController = new FrontController();
        netController = new NetController(type);
    }
    public NetController getNetController() {
        return netController;
    }

    public FrontController getFrontController() {

        return frontController;
    }

    private void initFacade() {
        facade = new ConsoleProductFacade(new ProductServiceImpl(new ProductRepositoryImpl()), new OrderServiceImpl(new OrderRepositoryImpl()),
                new BasketServiceImpl(new BasketRepositoryImpl()));
        int k = 0;
        facade.addProduct(new Product(k++, "Shit 1", "Nokia lumia", 600, 0));
        facade.addProduct(new Product(k++, "Shit 2", "Nokia lumia", 800, 0));
        facade.addProduct(new Product(k++, "Shit 3", "Nokia lumia", 4200, 0));
        facade.addProduct(new Product(k++, "Shit 4", "Nokia lumia", 3200, 0));
        facade.addProduct(new Product(k++, "Shit 5", "Nokia lumia", 2200, 0));
        facade.addProduct(new Product(k++, "Shit 6", "Nokia lumia", 1200, 0));

    }
    private void initNetController() {
        Map<String, Action> actions = new TreeMap<>();
        Map<String, com.epam.pp.hasan.network.view.View> views = new TreeMap<>();
        initNetActions(actions);
        initNetViews(views);
        netController.setActionHolder(new com.epam.pp.hasan.network.action.ActionHolder(actions));
        netController.setViewResolver(new com.epam.pp.hasan.network.view.ViewResolver(views));
    }
    private void initFrontController() {
        Map<Integer, com.epam.pp.hasan.action.Action> actions = new TreeMap<Integer, com.epam.pp.hasan.action.Action>();
        Map<String, View> views = new TreeMap<>();
        AddProduct prod = initAddProduct();
        HashMap<Integer, Class> productTypes = new HashMap<>();
        initActions(actions);
        initViews(views);
        initProductHelper(productTypes);
        frontController.setProductHelper(new ProductHelper(productTypes));
        frontController.setAddProductMethod(prod);
        frontController.setActionHolder(new ActionHolder(actions));
        frontController.setViewResolver(new ViewResolver(views));
    }
    private void initProductHelper(HashMap<Integer, Class> productTypes) {
        int k = 0;
        productTypes.put(k++, Product.class);
        productTypes.put(k++, Computer.class);
        productTypes.put(k, Phone.class);
    }
    private AddProduct initAddProduct() {
        AddProduct prod = null;
        Integer opt = ConsoleHelper.getInt("How to add products Console/Auto? (0/1)");
        if (opt.equals(0)) {
            prod = new AddProduct(new ConsoleRefl());
        } else {
            prod = new AddProduct(new GenerateRefl());
        }
        return prod;
    }
    private void initActions(Map<Integer, com.epam.pp.hasan.action.Action> actions) {
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
    }
    private void initViews(Map<String, View> views) {
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

    }
    private void initNetActions(Map<String, Action> actions) {
        actions.put(Fields.ACTION_NOTFOUND, new ActionNotFound(facade));
        actions.put(Fields.NETWORK_ACTION_COUNT, new ActionCount(facade));
        actions.put(Fields.NETWORK_ACTION_ITEM, new ActionItem(facade));
    }
    private void initNetViews(Map<String, com.epam.pp.hasan.network.view.View> views) {
        views.put(Fields.ACTION_NOTFOUND, new com.epam.pp.hasan.network.view.ViewNotFound());
        views.put(Fields.NETWORK_ACTION_COUNT, new ViewCount());
        views.put(Fields.NETWORK_ACTION_ITEM, new ViewItem());
    }



}
