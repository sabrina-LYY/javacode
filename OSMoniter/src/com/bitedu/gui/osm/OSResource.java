package com.bitedu.gui.osm;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class OSResource {
    private static OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    private static final int DATA_LENGTH = 60;
    private static XYPair[] xyPairs = new XYPair[DATA_LENGTH];//60个坐标

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
    public  static double getCPUPercetage() {
        return mxBean.getSystemCpuLoad();
    }
}

