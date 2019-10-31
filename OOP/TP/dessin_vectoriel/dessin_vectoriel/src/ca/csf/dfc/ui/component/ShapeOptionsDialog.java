package ca.csf.dfc.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.csf.dfc.ui.UIWindow;

@SuppressWarnings("serial")
public class ShapeOptionsDialog extends JPopupMenu {
	private JMenuItem fillOption, strokeOption, weightOption;
	private JSlider sliderWidth, sliderHeight;
	private JLabel lblWidth = new JLabel("Shape Width", SwingConstants.CENTER);
	private JLabel lblHeight = new JLabel("Shape Height", SwingConstants.CENTER);
	public int widthDiff;
	public int heightDiff;
	public int strokeWeight;
	public Color strokeColor;
	public Color fillColor;
	
	public ShapeOptionsDialog() {
		JMenu sizeMenu = new JMenu("Shape Size");
		
		this.fillOption = new JMenuItem("Fill Color");
		this.strokeOption = new JMenuItem("Stroke Color");
		this.weightOption = new JMenuItem("Stroke Weight");
		sizeMenu.add(makeShapeSizePanel());
		
		ListenForMenuClick menuListener = new ListenForMenuClick();
		this.fillOption.addActionListener(menuListener);
		this.strokeOption.addActionListener(menuListener);
		this.weightOption.addActionListener(menuListener);
		
		SliderListener sliderListener = new SliderListener();
		this.sliderWidth.addChangeListener(sliderListener);
		this.sliderHeight.addChangeListener(sliderListener);
		
		this.add(this.fillOption);
		this.add(this.strokeOption);
		this.add(this.weightOption);
		this.add(sizeMenu);
	}
	
	private JPanel makeShapeSizePanel() {
	 	JPanel mainPan = new JPanel(new BorderLayout());
        JPanel northPan = new JPanel(new GridLayout(1,2));
        JPanel southPan = new JPanel(new GridLayout(1,2));

		this.sliderWidth = new JSlider(-2000, 2000, 0);
        this.sliderWidth.setMajorTickSpacing(250);
        this.sliderWidth.setPaintTicks(true);

		this.sliderHeight = new JSlider(-2000, 2000, 0);
        this.sliderHeight.setMajorTickSpacing(250);
        this.sliderHeight.setPaintTicks(true);

        northPan.add(this.lblWidth);
        northPan.add(this.lblHeight);
        southPan.add(this.sliderWidth);
        southPan.add(this.sliderHeight);

        mainPan.add(northPan, BorderLayout.NORTH);
        mainPan.add(southPan, BorderLayout.SOUTH);

        return mainPan;
	}
	
	private class ListenForMenuClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent p_e) {
			if(p_e.getSource() == fillOption) {
				Color tempCol = JColorChooser.showDialog(UIWindow.getInstance(), "Fill Color Chooser", Color.WHITE);
				
				if(tempCol != null) {
					fillColor = tempCol;
				}
			}
			
			if(p_e.getSource() == strokeOption) {
				Color tempCol = JColorChooser.showDialog(UIWindow.getInstance(), "Stroke Color Chooser", Color.BLACK);
				
				if(tempCol != null) {
					strokeColor = tempCol;
				}
			}
			
			if(p_e.getSource() == weightOption) {
				StrokeDialog strokeDialog = new StrokeDialog(UIWindow.getInstance());
				strokeDialog.setVisible(true);
				
				strokeWeight = strokeDialog.getStrokeValue();
			}

		}
	}
	
	private class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent p_e) {
			if(p_e.getSource() == sliderWidth) {
				widthDiff = sliderWidth.getValue();
			}
			
			if(p_e.getSource() == sliderHeight) {
				heightDiff = sliderHeight.getValue();
			}
		}
		
	}
}
