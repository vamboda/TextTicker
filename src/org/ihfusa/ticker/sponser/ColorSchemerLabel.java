package org.ihfusa.ticker.sponser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ColorSchemerLabel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ColorSchemerLabel ex = new ColorSchemerLabel();
				ex.setVisible(true);
			}
		});
	}

	public ColorSchemerLabel() {

		JPanel panel = new JPanel(new GridLayout(1, 5));

		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(new Color(6, 104, 131));

		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(new Color(12, 129, 148));

		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(new Color(68, 161, 167));

		JLabel label4 = new JLabel();
		label4.setOpaque(true);
		label4.setBackground(new Color(88, 175, 183));

		JLabel label5 = new JLabel();
		label5.setOpaque(true);
		label5.setBackground(new Color(98, 206, 213));

		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		getContentPane().add(panel);
		setUndecorated(true);
		pack();
		
		this.setSize(new Dimension(100,20));
		setVisible(true);

	}

}
