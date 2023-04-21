package org.example.Video;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class videoShow {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        JFrame window=new JFrame();
        JLabel screen=new JLabel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        VideoCapture cap=new VideoCapture("src/main/resources/videoplayback.mp4");

        Mat frame=new Mat();
        MatOfByte buf=new MatOfByte();
        ImageIcon ic;

        while (cap.grab()){
            cap.read(frame);

            Imgcodecs.imencode(".png",frame,buf);
            ic=new ImageIcon(buf.toArray());
            screen.setIcon(ic);
            window.setContentPane(screen);
            window.pack();
        }
        cap.release();
        window.dispatchEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSED));


    }
}
