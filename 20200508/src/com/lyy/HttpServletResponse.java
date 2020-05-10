package com.lyy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponse {
    private static final Map<Integer,String>reasonMap = new HashMap<>();
    static{
        reasonMap.put(200,"OK");
        reasonMap.put(400,"Bad Request");
        reasonMap.put(404,"Not Found");
        reasonMap.put(500,"Internal Server Error");


    }

    private int status = 200;
    private Map<String,String> headersMap = new HashMap<>();
    private OutputStream outputStream;

    private ByteArrayOutputStream bodyOutputStream = new ByteArrayOutputStream(8192);
    private PrintWriter bodyPrintWriter;

    public HttpServletResponse()throws UnsupportedEncodingException{
         bodyPrintWriter = new PrintWriter(new OutputStreamWriter(bodyOutputStream,"UTF-8"));
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setHeader(String name,String value){
        headersMap.put(name,value);
    }
    public void setContentType(String contentType){
        setHeader("Content-Type",contentType);
    }
    public PrintWriter getWriter() throws IOException {
        return bodyPrintWriter;
    }

    public static HttpServletResponse build(OutputStream outputStream) throws UnsupportedEncodingException {
        HttpServletResponse response = new HttpServletResponse();
        //基本的初始化功能
        response.outputStream = outputStream;
        return response;
    }


    public void send() throws IOException {
        //强制把所有的body的内容都刷新到最终的目的地buffer中
        bodyPrintWriter.flush();

        //计算响应体的长度，填充contentLength首部
        int contentLength = bodyOutputStream.size();//计算实际内容长度
        setHeader("Content-Length",String.valueOf(contentLength));

        //为了方便写字符，用printWriter 封装了socket.outputStream
        PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(outputStream,"utf-8")
        );
        //1.先入响应行
        sendResponseLine(printWriter);
        sendResponseHeaders(printWriter);
        //数据有可能还缓存在printWriter（写入socket的printWriter）
        //为确保响应行-》响应头-》响应体的顺序就刷新printWriter，确保数据先写入socket  outputStream中
        printWriter.flush();

        sendResponseBody(outputStream);
        //确保数据最终写入Socket中
        outputStream.flush();
    }

    private void sendResponseBody(OutputStream outputStream) throws IOException {
        outputStream.write(bodyOutputStream.toByteArray());
    }

    private void sendResponseHeaders(PrintWriter printWriter) {
        for(Map.Entry<String,String>entry:headersMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            printWriter.print(key);
            printWriter.print(": ");
            printWriter.print(value);
            printWriter.print("\r\n");
        }
        printWriter.print("\r\n");
    }

    private void sendResponseLine(PrintWriter printWriter) {
        //<HTTP/1.0>空格<状态>空格<状态描述>CRLF
        printWriter.print("HTTP/1.0");
        printWriter.print(" ");
        printWriter.print(status);
        printWriter.print(" ");
        printWriter.print(reasonMap.get(status));
        printWriter.print("\r\n");
    }

    @Override
    public String toString() {
        return "HttpServletResponse{" +
                "status=" + status +
                ", headersMap=" + headersMap +
                '}';
    }
}

