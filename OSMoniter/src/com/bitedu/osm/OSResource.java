package com.bitedu.osm;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


public class OSResource {
    private static OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    private static final int DATA_LENGTH = 60;
    private static XYPair[] xyPairs = new XYPair[DATA_LENGTH];//60个坐标也就是一个统计周期
    private static int firstIndex = DATA_LENGTH;
    static{

        for(int i=0;i<DATA_LENGTH;++i){
            xyPairs[i] = new XYPair(0,0);
        }
    }


    public static class XYPair{//一个坐标
        private double y;
        private double x;

        public XYPair(double x,double y){
            this.x = x;
            this.y = y;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }
    }


    public  static XYPair[] getCPUPercetage() {
        double cpu = mxBean.getSystemCpuLoad();
        moveCPUData(cpu);
        return xyPairs;
    }
    public static String getOSName(){
        return mxBean.getName();
    }


    private static void moveCPUData(double cpuPercetage){
        int moveIdx = -1;
        if(firstIndex == 0){
            moveIdx = firstIndex+1;
        }else{
            moveIdx = firstIndex;
            firstIndex--;
        }

        for(;moveIdx<xyPairs.length;++moveIdx){
            xyPairs[moveIdx-1].setX(xyPairs[moveIdx].getX()-1);
            xyPairs[moveIdx-1].setY(xyPairs[moveIdx].getY());
        }
        moveIdx--;
        xyPairs[moveIdx] = new XYPair(moveIdx,cpuPercetage);
    }
}
