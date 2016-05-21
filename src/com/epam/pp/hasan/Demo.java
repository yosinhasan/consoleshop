/**
 *
 */
package com.epam.pp.hasan;

import com.epam.pp.hasan.controller.FrontController;
import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.server.Server;
import com.epam.pp.hasan.network.server.factory.impl.HttpServerFactory;
import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.util.InitializeConsole;

import java.util.Scanner;

/**
 * @author Yosin_Hasan
 */
public class Demo {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        InitializeConsole console = new InitializeConsole(Type.HTTP);
        console.init();
        FrontController controller = console.getFrontController();
        NetController netController = console.getNetController();
        Scanner sc = new Scanner(System.in);
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
}
