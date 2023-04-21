package org.example.Screen;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class imgShow extends JFrame {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("Version: " + Core.VERSION);
    }

    public static void main(String[] args) {
        JFrame windows = new JFrame();
        JLabel screen = new JLabel();
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setVisible(true);
        Mat img = Imgcodecs.imread("src/main/resources/1563747428145774466.jpg");

        Mat imgEmpty = new Mat(img.size(), img.type());

        Mat kernel = new Mat(20, 20, CvType.CV_8UC1, new Scalar(1.0));
        Imgproc.dilate(img, imgEmpty, kernel);
        Imgproc.erode(img, imgEmpty, kernel);
        Imgproc.cvtColor(img,imgEmpty,Imgproc.COLOR_BayerBG2BGR_EA);


        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", img, buf);
        ImageIcon imegeicon = new ImageIcon(buf.toArray());
        screen.setIcon(imegeicon);
        windows.getContentPane().add(screen);
        windows.pack();


    }
}
