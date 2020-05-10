package webapps.ROOT;

import com.lyy.Servlet;

import java.util.HashMap;
import java.util.Map;

public class WebXML {
    //Key:url-pattern
    //value:sevlet-name
    private static Map<String,String> servletMapping=new HashMap<>();
    //Key:servlet-name
    //value-:servlet-class 简单实现成servlet对象
    private static Map<String,Servlet> servlet=new HashMap<>();

    static{
        //<servlet>
        servlet.put("Hello",new HelloServlet());
        servlet.put("Login",new LoginServlet());
        //<servlet-mapping>
        servletMapping.put("/login","Login");
        servletMapping.put("/hello","Hello");

    }
/**
 * @param path
 * @return 路径对应的Servlet对象；null表示没有对应的Servlet资源
 */
    public static Servlet map(String path){
        String servletName = servletMapping.get(path);
        if(servletName==null){
            return null;
        }
        return servlet.get(servletName);
    }
}
