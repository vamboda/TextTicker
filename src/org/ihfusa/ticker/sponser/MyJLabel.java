package org.ihfusa.ticker.sponser;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyJLabel extends JLabel {
	public static final int MARQUEE_SPEED_DIV = 30;
	public static final int REPAINT_WITHIN_MS = 30;

	/**
     * 
     */
	private static final long serialVersionUID = -7737312573505856484L;

	/**
     * 
     */
	public MyJLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param image
	 * @param horizontalAlignment
	 */
	public MyJLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param image
	 */
	public MyJLabel(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param icon
	 * @param horizontalAlignment
	 */
	public MyJLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param horizontalAlignment
	 */
	public MyJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 */
	public MyJLabel(String text) {
		super(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {

		// This is for anti-clock wise direction

		/*
		 * g.translate((int) (((getWidth()) - System.currentTimeMillis() /
		 * (MARQUEE_SPEED_DIV)) % (getWidth() * 2)), 0);
		 * System.out.println((int) (((getWidth() * 2) - System
		 * .currentTimeMillis() / (MARQUEE_SPEED_DIV)) % (getWidth())) + "\t" +
		 * 0);
		 */

		// This is for clock wise direction
		int x = (int) (System.currentTimeMillis() / (MARQUEE_SPEED_DIV))
				% (getWidth() * 2) - (getWidth());
		g.translate(-x, 0);
//		System.out
//				.println((int) (System.currentTimeMillis() / (MARQUEE_SPEED_DIV))
//						% (getWidth() * 2) - (getWidth()) + "\t" + 0);

		super.paintComponent(g);
		repaint(REPAINT_WITHIN_MS);
		// System.out.println(this.getSize());
	}
}
