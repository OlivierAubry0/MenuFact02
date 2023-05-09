package menufact.observer.MVC;

import menufact.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class FactureVue implements Observer {
    private FactureControleur controleur;

    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;

    public FactureVue(FactureControleur controleur) {
        this.controleur = controleur;
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Facture");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
    }

    public void updateTextArea(String text) {
        textArea.setText(text);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }
    @Override
    public void actualiser(String message) {
        updateTextArea(message);
    }
}

