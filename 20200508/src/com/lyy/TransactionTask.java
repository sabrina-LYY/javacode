package com.lyy;

import webapps.ROOT.WebXML;

import java.net.Socket;

public class TransactionTask implements Runnable{

    private final Socket socket;
    public TransactionTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //HTTP1.0协议。一条TCP连接中，只处理一组HTTP请求-响应
        try {
            /**
             * 1.读取Tcp连接中的输入
             * 2.遵照HTTP请求的格式，解析输入
             * 3.解析过程，可能读到错误格式的请求（直接不处理）
             * 4.解析成功，封装成HttpServletRequest对象
             */
            HttpServletRequest request = HttpServletRequest.readAndParse(socket.getInputStream());//readAndParse读取内容并解析
            //为了观察中间步骤--DEBUG
            System.out.println(request);

            //5.构建一个空的HttpServletResponse对象（进行了基本初始化）
            HttpServletResponse response = HttpServletResponse.build(socket.getOutputStream());
            //6.TODO:区分是静态还是动态资源

            //7.先只考虑动态资源-如何根据URL找到对应的Servlet类
            //Tomcat中通过web.xml进行配置
            //通过Webxml类，模拟该操作
            Servlet servlet = WebXML.map(request.getPath());
            //平时404的原因：
            //1.Tomcat找不到对应的Web.xml文件
            //2.Tomcat在Web.xml没有找到url对应的servlet类
            if(servlet==null){
                //响应404
               // servlet = NotFoundServlet;
            }else{
                System.out.println(servlet.getClass().getCanonicalName());
                servlet.service(request,response);
                //response就被应用正确填充
                System.out.println(response);


                //8.按照response中的内容组装成HTTP响应格式并发送
                response.send();
            }

            socket.close();
        }catch(Exception | Error e){
            e.printStackTrace();
        }
    }
}
