/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.jfree.ui.RefineryUtilities;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Lucero Reyes
 */
public class Filtros {
     public static Mat agregaBrillo(Mat image){
             double[] newSpec;
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = newSpec[0] + 2;
                    newSpec[1] = newSpec[1] + 2;
                    newSpec[2] = newSpec[2] + 2;
                    image.put(i, j, newSpec);
                }
            }
         return image;        
    }
     public static Mat quitarBrillo(Mat image){
             double[] newSpec;
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = newSpec[0] - 2;
                    newSpec[1] = newSpec[1] - 2;
                    newSpec[2] = newSpec[2] - 2;
                    image.put(i, j, newSpec);
                }
            }
         return image;        
    }
    public static Mat Contraste(Mat image){
        double[] newSpec;
        double u=126;
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    if(newSpec[0]<=u)
                        newSpec[0] = newSpec[0] - 2;
                    else
                        newSpec[0] = newSpec[0] + 2;
                    if(newSpec[1]<=u)
                        newSpec[1] = newSpec[1] - 2;
                    else
                        newSpec[1] = newSpec[1] + 2;
                    if(newSpec[2]<=u)
                        newSpec[2] = newSpec[2] - 2;
                    else
                        newSpec[2] = newSpec[2] + 2;
                    image.put(i, j, newSpec);
                }
            }
        return image;
    }
    public static Mat agregarCorrecion(Mat image,int r){
        double[] newSpec;
           
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] +=Math.pow(newSpec[0],(r/10));
                    newSpec[1] +=Math.pow(newSpec[1],(r/10));
                    newSpec[2] +=Math.pow(newSpec[2],(r/10));
                    image.put(i, j, newSpec);
                } 
            }
        return image;
    }
    public static Mat Negativo(Mat image){
        double[] newSpec;
        int n=8;
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = Math.pow(2,n)-1-newSpec[0];
                    newSpec[1] = Math.pow(2,n)-1-newSpec[1];
                    newSpec[2] = Math.pow(2,n)-1-newSpec[2];
                    image.put(i, j, newSpec);
                }
            }
        return image;
    }
    public static Mat Binarizacion(Mat image){
        double[] newSpec;
        double u=126;
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    double m=Math.max(newSpec[0], newSpec[1]);
                    m=Math.max(m, newSpec[2]);
                    if(m<u){
                        newSpec[0]=0;
                        newSpec[1]=0;
                        newSpec[2]=0;
                    }else{
                        newSpec[0]=255;
                        newSpec[1]=255;
                        newSpec[2]=255;
                    }
                    image.put(i, j, newSpec);
                }
            }
        return image;
    }
    public static Mat Averaging(Mat image){
        for(int i=1;i<image.rows()-2;i++){
           for(int j=1;j<image.cols()-2;j++){
               double[] newSpec=image.get(i, j);
               double r=0,g=0,b=0;
               for(int a=0;a<3;a++){
                   for(int c=0;c<3;c++){
                       r=r+(image.get(a+i-1,c+j-1)[0]/9.0);
                       g=g+(image.get(a+i-1,c+j-1)[1]/9.0);
                       b=b+(image.get(a+i-1,c+j-1)[2]/9.0);
                   }
               }
               newSpec[0]=r;
               newSpec[1]=g;
               newSpec[2]=b;
               image.put(i, j, newSpec);
           }
       }
        return image; 
    }
    public static Mat Gauss(Mat image){
        double [][]k=new double[3][3];
        k[0][0]=1.0/16.0;
        k[0][1]=2.0/16.0;
        k[0][2]=1.0/16.0;
        k[1][0]=2.0/16.0;
        k[1][1]=4.0/16.0;
        k[1][2]=2.0/16.0;
        k[2][0]=1.0/16.0;
        k[2][1]=2.0/16.0;
        k[2][2]=1.0/16.0;
        for(int i=1;i<image.rows()-2;i++){
           for(int j=1;j<image.cols()-2;j++){
               double[] newSpec=image.get(i, j);
               double r=0,g=0,b=0;
               for(int a=0;a<3;a++){
                   for(int c=0;c<3;c++){
                       r=r+(k[a][c]*image.get(a+i-1,c+j-1)[0]);
                       g=g+(k[a][c]*image.get(a+i-1,c+j-1)[1]);
                       b=b+(k[a][c]*image.get(a+i-1,c+j-1)[2]);
                   }
               }
               newSpec[0]=r;
               newSpec[1]=g;
               newSpec[2]=b;
               image.put(i, j, newSpec);
           }
       }
        return image; 
    }
    public static Mat Media(Mat image){
        for(int i=1;i<image.rows()-2;i++){
           for(int j=1;j<image.cols()-2;j++){
               double[] newSpec=image.get(i, j);
               ArrayList r=new ArrayList();
               ArrayList g=new ArrayList();
               ArrayList b=new ArrayList();
               for(int a=0;a<3;a++){
                   for(int c=0;c<3;c++){
                       r.add(image.get(a+i-1,c+j-1)[0]);
                       g.add(image.get(a+i-1,c+j-1)[1]);
                       b.add(image.get(a+i-1,c+j-1)[2]);
                   }
               }
               Collections.sort(r);
               Collections.sort(g);
               Collections.sort(b);
               newSpec[0]=(double)r.get(4);
               newSpec[1]=(double)g.get(4);
               newSpec[2]=(double)b.get(4);
               image.put(i, j, newSpec);
           }
       }
        return image; 
    }
     public static Mat rotacion(Mat image,int g,double e){
        double r =Math.toRadians(g);
        Mat imagen1 =new Mat(image.rows(),image.cols(),image.type());
        double x1,y1=0;
        if(g<=90){
            x1=image.rows()-imagen1.rows()*0.5/1;
            y1=image.cols()-imagen1.cols()*0.5/0.5;
        }else if(g<=180){
            x1=image.rows()-imagen1.rows()*1/5;
            y1=image.cols()-imagen1.cols()*1.5/3;
        }else if(g<=270){
            x1=image.rows()-imagen1.rows()*0.5/1;
            y1=image.cols()-imagen1.cols()*1/5;
        }else{
            x1=image.rows()-imagen1.rows()*0.5/0.5;
            y1=image.cols()-imagen1.cols()*0.5/1;
        }
       for(int i=0;i<image.cols();i++){
            for(int j=0;j<image.rows();j++){
               double[] newSpec=image.get(j, i);
              double x=(i*Math.cos(r))-(j*Math.sin(r));
               x=x*e;
               x=x+x1;
               double y=(i*Math.sin(r))+(j*Math.cos(r));
               y=y*e;
               y=y+y1;
               imagen1.put((int)(y), (int)(x), newSpec);   
            }
        }
        return imagen1;
    }
    public static void histograma(Mat image){
        double[] b=new double[256];
        double[] g=new double[256];
        double[] r=new double[256];
        for(int i=0;i<image.rows();i++){
            for(int j=0;j<image.cols();j++){
               double[] newSpec=image.get(i, j);
               b[(int)(newSpec[0])]++;
               g[(int)(newSpec[1])]++;
               r[(int)(newSpec[2])]++;
            }
        }
        Clases.HistogramTest demo = new Clases.HistogramTest("Histograma",b,g,r);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
    public static Mat Sobel(Mat image) {
        Mat grayImage = new Mat();
        Mat detectedEdges = new Mat();
        int ddepth = CvType.CV_16S;
        Mat grad_x = new Mat();
        Mat grad_y = new Mat();
        Mat abs_grad_x = new Mat();
        Mat abs_grad_y = new Mat();
        Imgproc.cvtColor(image ,grayImage, Imgproc.COLOR_BGR2GRAY);
       // Gradient X
        Imgproc.Sobel(grayImage, grad_x, ddepth, 1, 0);
        Core.convertScaleAbs(grad_x, abs_grad_x);
        // Gradient Y
        Imgproc.Sobel(grayImage, grad_y, ddepth, 0, 1);
        Core.convertScaleAbs(grad_y, abs_grad_y);
        // Total Gradient (approximate)
        Core.addWeighted(abs_grad_x, 0.5, abs_grad_y, 0.5, 0, detectedEdges);
    
        return detectedEdges;

    }
    public static Mat Laplace(Mat image) {
       Mat laplacian = new Mat();
	Imgproc.Laplacian(image, laplacian, image.depth());
	Core.convertScaleAbs(laplacian, laplacian);
	return laplacian;

    }
    public static Mat Canny (Mat image) {
        Mat canny =new Mat();
        Imgproc.cvtColor (image, canny, Imgproc.COLOR_BGR2GRAY); 
        Imgproc.Canny (image, canny, 10, 100, 3,false); 
        return canny;

    }
    public static Mat transformada (Mat image) {
        Mat canny =new Mat();
        Imgproc.cvtColor (image, canny, Imgproc.COLOR_BGR2GRAY); 
        Mat tra=new Mat();
        canny.convertTo(tra,CvType.CV_32FC1);
        ArrayList <Mat> matList=new ArrayList<Mat>();
        matList.add(tra);
        Mat zeroMat =Mat.zeros(tra.size(), CvType.CV_32F);
        matList.add(zeroMat);
        Mat complexImage= new Mat();
        Core.merge(matList,complexImage);
        Core.dft(complexImage,complexImage);
        ArrayList <Mat>splitted = new ArrayList();
        Core.split(complexImage, splitted);
        Mat magnitude = new Mat();
        Core.magnitude(splitted.get(0),splitted.get(1), magnitude);
        Core.add(Mat.ones(magnitude.size(),CvType.CV_32F),magnitude, magnitude);
        Core.log(magnitude, magnitude);
        int cx=magnitude.cols()/2;
        int cy=magnitude.rows()/2;
       
        Mat q0=new Mat(magnitude,new Rect(0,0,cx,cy));
        Mat q1=new Mat (magnitude,new Rect(cx,0,cx,cy));
        Mat q2=new Mat (magnitude, new Rect(0,cy,cx,cy));
        Mat q3=new Mat (magnitude,new Rect (cx,cy,cx,cy));
        Mat tmp=new Mat();
        q0.copyTo(tmp);
        q3.copyTo(q0);
        tmp.copyTo(q3);
        q1.copyTo(tmp);
        q2.copyTo(q1);
        tmp.copyTo(q2);
        magnitude.convertTo(magnitude,CvType.CV_8UC1);
        Core.normalize(magnitude,magnitude,0,255,Core.NORM_MINMAX,CvType.CV_8UC1);
        return magnitude;
        

    }
}
