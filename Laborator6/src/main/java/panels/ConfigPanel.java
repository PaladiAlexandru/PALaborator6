package panels;

import frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorOfShape;

    public ConfigPanel( MainFrame frame) {
        this.frame = frame;
        init();

    }
    private void init(){
        label = new JLabel("Number of slides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        String[] colors = {"Random","Black"};
        colorOfShape = new JComboBox(colors);
        add(label);
        add(sidesField);
        add(colorOfShape);
    }
}
