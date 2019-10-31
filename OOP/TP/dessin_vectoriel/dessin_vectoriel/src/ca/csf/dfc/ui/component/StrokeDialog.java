package ca.csf.dfc.ui.component;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author J. Mainguy
 */
public class StrokeDialog extends JDialog {
    JSlider strokeSlider;
    private int strokeValue = Controls.getStrokeValue();
    JButton btnOk = new JButton("Ok");
    JButton btnCancel= new JButton("Cancel");
    JLabel label =  new JLabel();

    public StrokeDialog(JFrame p_Parent){
        super(p_Parent, "Épaisseur du trait", true);
        this.label.setText("  Valeur : " + this.strokeValue);

        this.strokeSlider = new JSlider(1, 20, Controls.getStrokeValue());
        this.strokeSlider.setPaintTicks(true);
        this.strokeSlider.setMajorTickSpacing(5);
        this.strokeSlider.setMinorTickSpacing(2);
        this.strokeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("  Valeur : " + strokeSlider.getValue());
            }
        });
        this.add(this.label, BorderLayout.NORTH);
        this.add(this.strokeSlider, BorderLayout.CENTER);

        ButtonManager mgr = new ButtonManager();
        this.btnOk.addActionListener(mgr);
        this.btnCancel.addActionListener(mgr);

        JPanel southPan = new JPanel(new FlowLayout());
        southPan.add(btnOk);
        southPan.add(btnCancel);

        this.add(southPan, BorderLayout.SOUTH);
        this.setLocationRelativeTo(p_Parent);
        this.setSize(250,200);
    }

    public int getStrokeValue(){
        return this.strokeValue;
    }

    private class ButtonManager implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StrokeDialog.this.setVisible(false);

            if (e.getSource() == btnOk){
                strokeValue = strokeSlider.getValue();
                Controls.setStrokeValue(strokeValue);
            }
        }
    }


}
