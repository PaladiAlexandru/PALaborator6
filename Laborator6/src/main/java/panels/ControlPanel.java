package panels;

import frames.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    final JFileChooser fc = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
    }

    private void load(ActionEvent actionEvent) {
        int returnVal = fc.showOpenDialog(this);
        File file = new File("");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        BufferedImage imageBuf = null;
        try {
            imageBuf = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        this.frame.getDrawingPanel().image = imageBuf;
        this.frame.repaint();

    }

    private void save(ActionEvent e) {
        int returnVal = fc.showSaveDialog(this);
        File file = new File("");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        try {
            ImageIO.write(frame.getDrawingPanel().image, "PNG", file);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void reset(ActionEvent e) {
       this.frame.getDrawingPanel().createOffscreenImage();
        this.frame.repaint();


    }

}
