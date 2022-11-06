package general;

import config.Properties.ProjectProperties;

public class EnvGlobals {
    public static ProjectProperties p = new ProjectProperties();
    public static String password = p.getProperties("password");
    public static String passwordinv =  p.getProperties("passwordinv");
    public static String URL = p.getProperties("URL");

    public static String username = p.getProperties("username");
    public static String usernameinv = p.getProperties("usernameinv");

    public static String dbhost = p.getProperties("dbhost");
    public static String dbUser = p.getProperties("dbUser");
    public static String dbPassword = p.getProperties("dbPassword");

    public static String browser = p.getProperties("browser");

    public static String execution = p.getProperties("execution");


}


