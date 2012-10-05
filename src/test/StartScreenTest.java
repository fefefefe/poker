package test;

import gui.StartScreen;

/**
 * Class is to test the start screen.
 * Screen is buggy if GoSco Label was clicked.
 * Systems which do not support browse desktop action throw Exceptions. 
 * Therefore a Tooltip was added to GoSco Label which refers to the HTML link.
 * 
 * @author jan
 *
 */
public class StartScreenTest {

	public StartScreenTest() {
		
	}
	
	public static void main(String[] args) {		
		StartScreen sc = new StartScreen();
	}

}
