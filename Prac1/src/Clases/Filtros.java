/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.opencv.core.Mat;

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
}
