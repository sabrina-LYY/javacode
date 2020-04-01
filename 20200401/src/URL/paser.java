package URL;

import java.util.HashMap;
import java.util.Map;

public class paser {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/dbnane?characterEncoding = utf8";

        parse(url);
    }
    private static Map<String,Integer> schemaToPort = new HashMap<>();
    static{
        schemaToPort.put("jdbc:mysql",3306);
        schemaToPort.put("https",443);
        schemaToPort.put("http",40);

    }
    public static void parse(String url){
        String remain;
        String schema;
        {
            int i = url.indexOf("://");
            schema = url.substring(0,i);
            System.out.println(schema);
            remain = url.substring(i+3);//跳过://这三个字符
        }

        {
            //确定有没有认证信息（用户名和密码）
            int i = remain.indexOf("@");
            if(i==-1) {
                System.out.println("用户名：");
                System.out.println("密码：");
            }else{
                String authentication = remain.substring(0,i);

                int j = authentication.indexOf(":");
                if(j==-1){
                    System.out.println("用户名"+authentication);
                    System.out.println("密码：");
                }else{
                    String user = authentication.substring(0,j);
                    String password = authentication.substring(j+1);
                    System.out.println("用户名："+user);
                    System.out.println("密码："+password);
                }
                //切割认证信息
                //再根据：分割用户名和密码部分
                //remain = remain.subString()
                remain = remain.substring(i+1);//跳过@符
            }
        }

        {
            //确定主机+端口部分
            //通过找 / 分割（主机+端口）和后面部分
            int i = remain.indexOf("/");
            String ipAndPort = remain.substring(i);
            remain = remain.substring(i);//不跳过/


            //根据： 分割主机+端口部分
            //端口有可能没有写出来
            int j = ipAndPort.indexOf(":");
            if(j==-1){
                String host = ipAndPort;
                int port = schemaToPort.get(schema);
                System.out.println("主机："+host);
                System.out.println("端口："+port);
            }
        }
        {
            //分割路径和QueryString
            //通过？分割路径部分
            //通过#分割Query  String部分

            int i = remain.indexOf("?");
            if(i==-1){
                String path = remain;
                remain = "";
            }else {
                String path = remain.substring(0, i);
                remain = remain.substring(i + 1);
                System.out.println("路径：" + path);
            }
        }
        {    //通过#分割Query  String部分
                int i = remain.indexOf("#");
                if(i==-1){
                    String queryString = remain;
                    remain = "";
                    System.out.println("查询字符串："+queryString);
                }else{
                    String queryString = remain.substring(0,i);
                    remain = remain.substring(i+1);
                    System.out.println("查询字符串："+queryString);
                }
            }
        {
            //segment部分
            System.out.println("片段标识符："+remain);
        }

    }
}

