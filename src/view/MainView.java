package view;

import java.awt.*;
import javax.swing.*;

public class MainView {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AudioRecognizerWindow audioWindow = new AudioRecognizerWindow(
				"Audio Recognizer");
		audioWindow.createWindow();
	}

}
