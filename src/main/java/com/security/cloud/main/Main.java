package com.security.cloud.main;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Logger logger = Logger.getLogger("");
        Handler fileHandler = new FileHandler("logs/catalina.out", true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.ALL);
        fileHandler.setEncoding("UTF-8");
        logger.addHandler(fileHandler);

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File("src/main/resources/sharefolder/").getAbsolutePath());
        tomcat.getConnector().setURIEncoding("UTF-8");
        
        tomcat.addUser("testuser", "111111"); 	// user, pass
        tomcat.addRole("testuser", "testrole"); // user, role
        
        tomcat.addUser("webdavuser", "111111"); // user, pass
        tomcat.addRole("webdavuser", "webdav"); // user, role

        tomcat.start();
        tomcat.getServer().await();
    }
}

