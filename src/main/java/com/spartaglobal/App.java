package com.spartaglobal;

import com.spartaglobal.controller.SortManager;
import com.spartaglobal.view.DisplayManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class App {
    private static Logger logger = Logger.getLogger("Sorting Application");
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");

        SortManager controller = new SortManager(new DisplayManager());
        controller.selectAlgorithm();
        try {
            controller.sortArray();
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
