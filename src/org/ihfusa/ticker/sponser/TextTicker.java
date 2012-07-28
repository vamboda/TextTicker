package org.ihfusa.ticker.sponser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// import statements
// Check if window closes automatically. Otherwise add suitable code
public class TextTicker extends JFrame {
	/**
     *
     */
	private static final long serialVersionUID = 1L;
	MyJLabel jlbHelloWorld = null;
	private static Point point = new Point();

	public TextTicker frame = this;
	public static final String MAHA_MANTRA = "Hare Krishna! Hare Krishna! Krishna Krishna! Hare Hare! Hare Rama! Hare Rama! Rama Rama! Hare Hare!";
	Timer timer;

	public static void main(String args[]) {
		System.out.println(new File("images").exists());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TextTicker ex = new TextTicker();
				ex.setVisible(true);
			}
		});
	}

	TextTicker() {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel(new GridLayout(2, 1)) {
			public void paintComponent(Graphics grafica) {
				Image imgFondo;
				try {
					imgFondo = javax.imageio.ImageIO.read(new File(
							"src/org/ihfusa/ticker/sponser/main_bg-2.png"));
					grafica.drawImage(imgFondo, 0, 0, this.getWidth(),
							this.getHeight(), null); // no need for
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ImageObserver
				// here
			}
		};
		JPanel headerPanel = new JPanel(new GridLayout(2, 1)) {
			public void paintComponent(Graphics grafica) {
				Image imgFondo;
				try {
					imgFondo = javax.imageio.ImageIO
							.read(new File(
									"src/org/ihfusa/ticker/sponser/header_panel_bg.png"));
					grafica.drawImage(imgFondo, 0, 0, this.getWidth(),
							this.getHeight(), null); // no need for
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ImageObserver
				// here
			}
		};
		// headerPanel.setLayout(null);
		JLabel headerLabel = new JLabel("Today's Feast Sponsers",
				SwingConstants.RIGHT);
		// headerLabel.setBounds(1170, 52, (int) headerLabel.getBounds()
		// .getWidth(), (int) headerLabel.getBounds().getHeight());

		headerLabel.setFont(new Font("Arial", Font.ITALIC, 25));

		JPanel headerDividerPanel = new JPanel(new GridLayout(1, 5));
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
		// headerDividerPanel.add(label1);
		// headerDividerPanel.add(label2);
		// headerDividerPanel.add(label3);
		// headerDividerPanel.add(label4);
		// headerDividerPanel.add(label5);
		// headerPanel.add(headerDividerPanel);
		headerPanel.add(new JLabel());
		headerPanel.add(headerLabel);
		mainPanel.add(headerPanel);
		FilePlayer.createFilePlayer(frame);
		getContentPane().add(mainPanel);
		this.setBackground(Color.gray);
		jlbHelloWorld = new MyJLabel(MAHA_MANTRA);
		mainPanel.add(jlbHelloWorld);
		this.setUndecorated(true);

		mainPanel.addMouseListener(new PopClickListener());
		mainPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
				System.out.println(point.x + "," + point.y);
			}
		});
		mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = frame.getLocation();
				frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY()
						- point.y);
			}
		});
		pack();
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(new Dimension(dim.width, 200));
		// jlbHelloWorld.setSize(frame.getSize());
		System.out.println(frame.getWidth() + ":" + mainPanel.getWidth() + ":"
				+ jlbHelloWorld.getWidth() + jlbHelloWorld.getHeight());
		setFontSize();

		/*
		 * timer = new Timer(1000, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("Hi!");
		 * 
		 * } }); timer.start(); }
		 */

		// System.out.println(jlbHelloWorld.getBounds());
	}

	private void setFontSize() {
		Font f = new Font("Arial", Font.PLAIN, 45); // make a new font object
		jlbHelloWorld.setForeground(new Color(Integer.valueOf("21BDDF", 16)));
		jlbHelloWorld.setFont(f);

		// get metrics from the graphics
		FontMetrics metrics = jlbHelloWorld.getFontMetrics(f);
		// get the height of a line of text in this
		// font and render context
		int hgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(jlbHelloWorld.getText());
		// calculate the size of a box to hold the
		// text with some padding.
		final Dimension size = new Dimension(adv + 2, hgt + 2);

		// Font labelFont = jlbHelloWorld.getFont();
		// String labelText = jlbHelloWorld.getText();
		// int stringWidth =
		// jlbHelloWorld.getFontMetrics(labelFont)..stringWidth(
		// labelText);
		// int componentWidth = jlbHelloWorld.getWidth();

		// Find out how much the font can grow in width.
		// double widthRatio = (double) componentWidth / (double) stringWidth;

		// int newFontSize = (int) (labelFont.getSize() * widthRatio);
		// int componentHeight = jlbHelloWorld.getHeight();

		// componentHeight = Math.min(componentHeight, 100);
		// Pick a new font size so it will not be larger than the height of
		// label.
		// int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		// jlbHelloWorld.setFont(new Font(f.getName(), Font.PLAIN,
		// fontSizeToUse));

		jlbHelloWorld.setPreferredSize(size);
		jlbHelloWorld.setMinimumSize(size);
		System.out.println(size);
		System.out.println(jlbHelloWorld.getSize());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if ((int) size.getWidth() < dim.width)
			frame.setSize((int) dim.width, frame.getHeight());
		else
			frame.setSize((int) size.getWidth(), frame.getHeight());

	}

	public void setMainLabelText(String text) {
		jlbHelloWorld.setText(text);
		setFontSize();

	}
}

class PopUpDemo extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;

	public PopUpDemo() {
		JMenuItem fileMenuItem = new JMenuItem("Choose File...");
		add(fileMenuItem);
		fileMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FilePlayer.getInstance().playFile();

			}
		});
		JMenuItem resetMenuItem = new JMenuItem("Reset");
		resetMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilePlayer.getInstance().resetDisplay();
			}
		});
		add(resetMenuItem);
		JMenuItem closeMenuItem = new JMenuItem("Close");
		closeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilePlayer.getInstance().frame.dispose();
				System.exit(0);
			}
		});

		add(closeMenuItem);
	}
}

class PopClickListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {
		PopUpDemo menu = new PopUpDemo();
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}
