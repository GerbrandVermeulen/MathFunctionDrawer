
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Gerbrand Vermeulen
 */
public class GraphDisplay extends JPanel {
	private static final long serialVersionUID = -8493783413105118036L;
	
	private int CARTESIAN_X;
	private int CARTESIAN_Y;
	private int DISPLAY_X;
	private int DISPLAY_Y;
	
	/**
	 * Creates the Cartesian graph and draws the function.
	 * @param display
	 * 			Size of the panel, i.e. display = 500, panel size: 500 x 500
	 * @param cx
	 * 			The max x value of the Cartesian graph, 10 recommended
	 * @param cy
	 * 			The max y value of the Cartesian graph, 10 recommended
	 */
	public GraphDisplay(int display, int cx, int cy) {
		DISPLAY_X = display;
		DISPLAY_Y = display;
		CARTESIAN_X = cx;
		CARTESIAN_Y = cy;
		setSize(DISPLAY_X, DISPLAY_Y);
		setLayout(null);
	}

	/**
	 * Draws the graph display and the function
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		
		// Setup x and y axis
		g.drawLine(0, DISPLAY_Y/2, DISPLAY_X, DISPLAY_Y/2);
		g.drawLine(DISPLAY_X/2, 0, DISPLAY_X/2, DISPLAY_Y);
		g.drawString("0", DISPLAY_X/2 + 2, DISPLAY_Y/2 - 2);
		
		for (int x = -CARTESIAN_X; x <= CARTESIAN_X; x++) {
			if (x != 0) {
				g.drawString(Integer.toString(x), convertDisplayCoord(x, 0)[0] - 2, DISPLAY_Y/2 - 4);
				g.drawLine(convertDisplayCoord(x, 0)[0], DISPLAY_Y/2 - 2, convertDisplayCoord(x, 0)[0], DISPLAY_Y/2 + 2);
			}
		}
		
		for (int y = -CARTESIAN_Y; y <= CARTESIAN_Y; y++) {
			if (y != 0) {
				g.drawString(Integer.toString(y), DISPLAY_X/2 + 5, convertDisplayCoord(0, y)[1] + 4);
				g.drawLine(DISPLAY_X/2 - 2, convertDisplayCoord(0, y)[1], DISPLAY_X/2 + 2, convertDisplayCoord(0, y)[1]);
			}
		}
		
		// Draw the function
		double x = -CARTESIAN_X;
		
		while (x < CARTESIAN_X) {
			g.drawOval(convertDisplayCoord(x, 0)[0], convertDisplayCoord(0, function(x))[1], 2, 2);
			x += 0.0001;
		}
	}
	
	/**
	 * The function that the program will draw on the display
	 * @param x
	 * 			The given x value
	 * @return
	 * 			The resultant y value
	 */
	public double function(double x) {
//		double value = 2 * Math.pow(x, 2) - 6 * x + 1;
				
		double value = 2 * Math.pow(x, 6) - 13 * Math.pow(x, 5) + 26 * Math.pow(x, 4) - 7 * Math.pow(x, 3) - 28 * Math.pow(x, 2) + 20 * x;
		return value;
	}
	
	/**
	 * Converts Cartesian coordinates to pixel coordinates on the display
	 * @param x
	 * 			Cartesian x value
	 * @param y
	 * 			Cartesian y value
	 * @return
	 * 			Integer array with the x and y coordinates
	 */
	private int[] convertDisplayCoord(double x, double y) {
		int[] coordinates = new int[2];
		double actualX = (double) (x + CARTESIAN_X) / (double) (CARTESIAN_X * 2);
		double actualY = (double) ((-1 * y) + CARTESIAN_Y) / (double) (CARTESIAN_Y * 2);
		
		coordinates[0] = (int) (DISPLAY_X * actualX);
		coordinates[1] = (int) (DISPLAY_Y * actualY);
		
		return coordinates;
	}
}
