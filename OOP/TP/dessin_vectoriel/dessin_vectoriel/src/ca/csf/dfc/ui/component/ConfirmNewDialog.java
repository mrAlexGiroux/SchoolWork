package ca.csf.dfc.ui.component;

import ca.csf.dfc.ui.UIWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author J. Mainguy
 */
public class ConfirmNewDialog extends JDialog {

    private JButton btnAccept = new JButton("Accept");
    private JButton btnCancel = new JButton("Cancel");
    String m_Action = "cancel";

    public ConfirmNewDialog(JFrame p_Parent){
        super(p_Parent, "Start New Canvas", true);
        JPanel mainPan = new JPanel(new BorderLayout());
        JPanel southPan = new JPanel(new GridLayout(1,2));
        JPanel msgPan = new JPanel();

        ButtonManager btnMgr = new ButtonManager();
        this.btnAccept.addActionListener(btnMgr);
        this.btnCancel.addActionListener(btnMgr);

        southPan.add(btnAccept);
        southPan.add(btnCancel);
        msgPan.add(new JLabel("Current canvas not empty, are you sure you want to proceed?"), SwingConstants.CENTER);

        mainPan.add(southPan, BorderLayout.SOUTH);
        mainPan.add(msgPan, BorderLayout.CENTER);

        this.add(mainPan);
        this.setSize(400,100);
        this.setLocationRelativeTo(p_Parent);
    }

    public String getAction(){
        return this.m_Action;
    }

    private class ButtonManager implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ConfirmNewDialog.this.setVisible(false);
            if(e.getSource() == btnAccept){
                m_Action = "accept";
            }
            else if(e.getSource() == btnCancel){
                m_Action = "cancel";
            }
        }
    }
}
