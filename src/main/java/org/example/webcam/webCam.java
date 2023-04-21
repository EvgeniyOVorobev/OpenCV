package org.example.webcam;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class webCam {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        JFrame window=new JFrame();
        JLabel screen=new JLabel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        VideoCapture cap=new VideoCapture(0);
        VideoWriter writer=new VideoWriter("src/main/resources/saveVideo.mpg",VideoWriter.fourcc('m','j','p','g'),30,new Size(640,480));

        Mat frame=new Mat();
        MatOfByte buf=new MatOfByte();
        ImageIcon ic;

        while (cap.grab()){
            cap.read(frame);
            writer.write(frame);

            Imgcodecs.imencode(".png",frame,buf);
            ic=new ImageIcon(buf.toArray());
            screen.setIcon(ic);
            window.setContentPane(screen);
            window.pack();
        }
        cap.release();
        writer.release();
        window.dispatchEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSED));


    }
}
