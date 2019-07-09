/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.JCheckBox;
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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Lucero Reyes
 */
public class HistogramTest extends ApplicationFrame implements ItemListener{
    private static Color COLOR_SERIE_1 = Color.RED;
    private static Color COLOR_SERIE_2 = Color.BLUE;
    private static Color COLOR_SERIE_3 = Color.GREEN;
    private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);
    private static Color COLOR_FONDO_GRAFICA = Color.white;
    private static JCheckBox B= new JCheckBox(); 
    private static JCheckBox G= new JCheckBox(); 
    private static JCheckBox R= new JCheckBox();
    XYSeries datasetb;
    XYSeries datasetg;
    XYSeries datasetr;
    XYSeriesCollection collection = new XYSeriesCollection();
    JFreeChart chart;
    public HistogramTest(String title,double[] b,double[] g,double[] r) {
        super(title);    
        B.setText("Blue");
        R.setText("Red");
        G.setText("Green");
        datasetr = createDataset(r,"Red");
        datasetb = createDataset(b,"Blue");
        datasetg = createDataset(g,"Green"); 
        JFreeChart chart = createChart(collection);
        chart.setTitle("");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        chartPanel.add(B);
        chartPanel.add(R);
        chartPanel.add(G);
        R.addItemListener(this);
        B.addItemListener(this);
        G.addItemListener(this);
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(G.isSelected() && R.isSelected() && B.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetb);
            collection.addSeries(datasetg);
            collection.addSeries(datasetr);
        }else if(G.isSelected() && R.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetg);
            collection.addSeries(datasetr);
        }else if(B.isSelected() && R.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetb);
            collection.addSeries(datasetr);
        }else if(G.isSelected() && B.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetg);
            collection.addSeries(datasetb);
        }else if(G.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetg);
        }else if(B.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetb);
        }else if(R.isSelected()){
            collection.removeAllSeries();
            collection.addSeries(datasetr);
        }else{
            collection.removeAllSeries();
        }
    }
}
