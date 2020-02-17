package com.bitedu.gui;

import com.bitedu.osm.FileScanner;
import com.bitedu.osm.FileTreeNode;
import com.bitedu.osm.OSResource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OSMonitorController {

    @FXML private LineChart cpuChart;
    @FXML private TreeTableView<FileTreeNode> fileStat;
    @FXML private Text osType;

    //定时器任务
    private TimerTask timerTask = null;
    private Timer timer= new Timer();//定时器线程执行定时任务

    private Stage primaryStage = null;

    private final Image image = new Image(getClass().getClassLoader().getResourceAsStream("Folder.png"));
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }


    public void handleCPUSelectionChanged(Event event) {
        Tab tab = (Tab) event.getTarget();

        if(tab.isSelected()){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    OSResource.XYPair[] xyPairs = OSResource.getCPUPercetage();
                    XYChart.Series series = new XYChart.Series();

                    for(OSResource.XYPair xyPair: xyPairs){
                        XYChart.Data data = new XYChart.Data(xyPair.getX(),xyPair.getY());
                        series.getData() .add(data);
                    }

                    //将渲染逻辑切换到主线程执行
                    Platform.runLater(
                        () ->{
                            if(cpuChart.getData().size()>0){
                                cpuChart.getData().remove(0);
                            }
                            cpuChart.getData().add(series);//把数据放进LineChart中
                            osType.setTextContent((OSResource.getOSName()));
                        }
                    );
                }
            };

            timer.schedule(timerTask,0,1000);
            //0表示任务安排好立即执行，1000表示周期执行时间，单位是毫秒


        } else{
            if(timerTask != null){
                timerTask.cancel();
                timerTask = null;
            }
        }

    }

    public void shuntdown(){
        if(timer != null){
            timer.cancel();
        }
    }
    public void handleSelectFile(ActionEvent actionEvent) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        //表示选择目录 File可以表示目录，也可表示普通文件
        File file = directoryChooser.showDialog(primaryStage);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                FileTreeNode rootNode = new FileTreeNode();
                rootNode.setFile(file);
                rootNode.setFileName(file.getName());

                FileScanner.scannerDirectory(rootNode);//扫描目录

                TreeItem rootItem = new TreeItem(rootNode,new ImageView(image));//根节点传入，表示要渲染这棵树;
                rootItem.setExpanded(true);//允许展开

                fillTreeItem(rootNode,rootItem);

                Platform.runLater(
                        ()->{
                            fileStat.setRoot(rootItem);
                        }
                );
            }
        });
        thread.setDaemon(true);//线程结束，自动退出
        thread.start();
    }

    private void fillTreeItem(FileTreeNode rootNode,TreeItem rootItem){
        List<FileTreeNode> childs = rootNode.getChildrens();
        for(FileTreeNode node:childs){
            TreeItem item = new TreeItem(node);

            if(node.getChildrens().size()>0){
                item.setGraphic(new ImageView(image));
            }
            rootItem.getChildren().add(item);

            //递归调用转换子目录
            fillTreeItem(node,item);
        }
    }
}

