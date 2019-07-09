/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import javax.swing.JFileChooser;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Lucero Reyes
 */
public class Detection {
    public Mat  loadCascade(Mat img) {
        JFileChooser chooser = new JFileChooser();
        chooser.showDialog(null, null);

        File selectedFile = chooser.getSelectedFile();

        String cascadePath = selectedFile.getPath();
        CascadeClassifier objectDetector = new CascadeClassifier(cascadePath);
        
        img = detectAndDrawFace(img, objectDetector);
        return img;
    }

    private Mat detectAndDrawFace(Mat image,CascadeClassifier objectDetector) {
        MatOfRect obectDetections = new MatOfRect();
        objectDetector.detectMultiScale(image, obectDetections);
        for (Rect rect : obectDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x+ rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        
        return image;
    }
}
