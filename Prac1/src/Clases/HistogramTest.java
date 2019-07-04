/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.io.IOException;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Lucero Reyes
 */
public class HistogramTest extends ApplicationFrame {
    private static Color COLOR_SERIE_1 = new Color(255, 128, 64);
    private static Color COLOR_SERIE_2 = new Color(28, 84, 140);
    private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);
    private static Color COLOR_FONDO_GRAFICA = Color.white;
    
    public HistogramTest(String title,double[] b,double[] g,double[] r) {
        super(title);    
        XYSeries datasetb = createDataset(r,"Red");
        XYSeries datasetg = createDataset(b,"Blue");
        XYSeries datasetr = createDataset(g,"Green");
        XYSeriesCollection collection = new XYSeriesCollection();
	collection.addSeries(datasetb);
	collection.addSeries(datasetg);
        collection.addSeries(datasetr);
        JFreeChart chart = createChart(collection);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
       setContentPane(chartPanel);
    }

    private XYSeries createDataset(double[] ar,String n) {
        XYSeries serie1 = new XYSeries(n);
	for(int i=0;i<255;i++){
            serie1.add(i,ar[i]);
        }
	return serie1;
    }

    private JFreeChart createChart(XYSeriesCollection dataset) { 
        JFreeChart chart = ChartFactory.createHistogram(
            "Histogram Demo", 
            "Valores", 
            "Frecuencias", 
            dataset, 
            PlotOrientation.VERTICAL, 
            true, 
            false, 
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setForegroundAlpha(0.75f);
        NumberAxis axis = (NumberAxis) plot.getDomainAxis();
        axis.setAutoRangeIncludesZero(false);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(NumberFormat.getInstance());        
        return chart;
    }

}
