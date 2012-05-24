package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Complex;

public class SpectrumView extends javax.swing.JFrame {

	Complex[][] results = null;
	int size;
	double highscores[][];
	double recordPoints[][];

	/**
	 * Creates a new instance of Java2DFrame
	 */
	public SpectrumView(Complex[][] results, int size, double highscores[][],
			double recordPoints[][]) {
		this.results = results;
		this.size = size;
		this.highscores = highscores;
		this.recordPoints = recordPoints;
		this.setLayout(new FlowLayout());
		this.setSize(400, 800);
	}

	/**
	 * This is the method where the String is drawn.
	 * 
	 * @param g
	 *            The graphics object
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		int blockSizeX = 2;
		int blockSizeY = 3;
		size = 500;
		for (int i = 0; i < results.length; i++) {
			int freq = 1;
			for (int line = 1; line < size; line++) {
				// To get the magnitude of the sound at a given frequency slice
				// get the abs() from the complex number.
				// In this case I use Math.log to get a more managable number
				// (used for color)
				double magnitude = Math.log(results[i][freq].abs() + 1);
				// The more blue in the color the more intensity for a given
				// frequency point:
				g2d.setColor(new Color(0, (int) magnitude * 10,
						(int) magnitude * 20));

//				if (freq < 300 /* && recordPoints[i][freq] == 1 */) {
//					g2d.setColor(Color.RED);
//				}

				// Fill:
				g2d.fillRect(i * blockSizeX, (size - line) * blockSizeY,
						blockSizeX, blockSizeY);

				// I used a improviced logarithmic scale and normal scale:
				if (/* logModeEnabled */false && (Math.log10(line) * Math
						.log10(line)) > 1) {
					freq += (int) (Math.log10(line) * Math.log10(line));
				} else {
					freq++;
				}
			}
		}
	}

}
