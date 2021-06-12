package pandemic.view;

import pandemic.Model;

import javax.swing.*;

public class View {
    private Model model;
    private JFrame frame;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();
    }

    public JFrame getFrame() {
        return frame;
    }
}
