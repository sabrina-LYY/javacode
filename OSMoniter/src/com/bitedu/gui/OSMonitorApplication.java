package com.bitedu.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// javafx 主程序 的要求：
// 1. 必须继承 javafx 的 Application 类
// 2. 必须覆盖（Override）Application 类的 start 方法
public class OSMonitorApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //1.加载FXML文件
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("os_monitor_tab.fxml"));
        //2.真正的加载
        Parent root = loader.load();

        OSMonitorController controller=loader.getController();
        controller.setPrimaryStage(primaryStage);

        //3.创建一个Scene对象
        Scene scene = new Scene(root,800,600);
        //4.给Stage设置标题
        primaryStage.setTitle("OS Monitor");
        //5.将Scene添加到Stage
        primaryStage.setScene(scene);


        primaryStage.setOnCloseRequest((e) -> controller.shuntdown());
        //6.展示
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
