package top.stxkfzx.frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BaseFrame extends Frame {

    public void launchFrame() {
        setSize(100, 100);
        setLocation(200, 300);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class PaintThread extends Thread {

        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private Image offScreenImage = null;
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(0, 0);

        }
        Graphics gOff = offScreenImage.getGraphics();

        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
