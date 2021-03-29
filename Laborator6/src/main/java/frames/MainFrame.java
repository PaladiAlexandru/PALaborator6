package frames;

import panels.ConfigPanel;
import panels.ControlPanel;
import panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame(){
        super("Draw app");
        init();
    }

    private void init(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        add(configPanel,BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(drawingPanel,BorderLayout.CENTER);
        
    }

    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
