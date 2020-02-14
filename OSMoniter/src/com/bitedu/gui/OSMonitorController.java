package com.bitedu.gui;

import com.bitedu.gui.osm.OSResource;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.chart.LineChart;

public class OSMonitorController {

    private LineChart cpuChart;
    public void handleCPUSelectionChanged(Event event) {
        System.out.println(OSResource.getCPUPercetage());
    }
    
    public void handleSelectFile(ActionEvent actionEvent) {
    }
}

