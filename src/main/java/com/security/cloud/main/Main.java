package com.security.cloud.main;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {

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