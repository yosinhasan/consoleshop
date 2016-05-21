package com.epam.pp.hasan.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Yosin_Hasan on 5/16/2016.
 */
public class ProductHelper {
    private HashMap<Integer, Class> data;

    public ProductHelper(HashMap<Integer, Class> data) {
        this.data = data;
    }

    public Class getProductType() {
        show();
        Integer key = ConsoleHelper.getInt();
        if (data.containsKey(key)) {
            return data.get(key);
        }
        return null;
    }

    private void show() {
        ConsoleHelper.show("Choose what to add: ");
        Iterator<Map.Entry<Integer, Class>> iterator = data.entrySet().iterator();
        Map.Entry<Integer, Class> entry = null;
        while (iterator.hasNext()) {
            entry = iterator.next();
            ConsoleHelper.show(entry.getKey() + "=>" + entry.getValue().getName());
        }
    }
}
