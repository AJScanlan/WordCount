package com.ajscanlan.wordcountassignment;

import javax.swing.JApplet;

public class WordCount extends JApplet {
	
	/**
	 *  AUTHOR: ALEXANDER SCANLAN
	 */
	private static final long serialVersionUID = 2667425645612699517L;

	public WordCount(){
		setContentPane(new WordCountInterface());
	}
	
	public void init() {
		setSize(450, 380);
	}
	
}
