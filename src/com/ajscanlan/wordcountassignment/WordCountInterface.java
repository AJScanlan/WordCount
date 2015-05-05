package com.ajscanlan.wordcountassignment;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordCountInterface extends JPanel {


	private static final long serialVersionUID = -4240569203400735475L;
	/**
	 *  AUTHOR: ALEXANDER SCANLAN
	 */
	

	public WordCountInterface(){
		setBackground(Color.LIGHT_GRAY);
		initGUI(); //initalise all of the GUI in one method
	}



	private void initGUI() {
		setLayout(null);	 

		//set the look and feel to windows
		try {	
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e2) {	
			e2.printStackTrace();
		}

		//add the text area
		JTextArea enterTextArea = new JTextArea();
		enterTextArea.setWrapStyleWord(true);
		enterTextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		enterTextArea.setLineWrap(true);
		enterTextArea.setBounds(10, 24, 250, 210);
		add(enterTextArea);

		//add the textfields
		JTextField findWordField = new JTextField();
		findWordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		findWordField.setBounds(270, 23, 170, 26);
		add(findWordField);
		findWordField.setColumns(10);

		JTextField statusField = new JTextField();
		statusField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		statusField.setBackground(Color.LIGHT_GRAY);
		statusField.setEditable(false);
		statusField.setBounds(270, 74, 170, 26);
		add(statusField);
		statusField.setColumns(10);

		JTextField numWordsField = new JTextField();
		numWordsField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		numWordsField.setBackground(Color.LIGHT_GRAY);
		numWordsField.setEditable(false);
		numWordsField.setBounds(202, 262, 90, 26);
		add(numWordsField);
		numWordsField.setColumns(10);

		JTextField charIncSpacesField = new JTextField();
		charIncSpacesField.setBackground(Color.LIGHT_GRAY);
		charIncSpacesField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		charIncSpacesField.setEditable(false);
		charIncSpacesField.setBounds(202, 289, 90, 26);
		add(charIncSpacesField);
		charIncSpacesField.setColumns(10);

		JTextField charExcSpacesField = new JTextField();
		charExcSpacesField.setBackground(Color.LIGHT_GRAY);
		charExcSpacesField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		charExcSpacesField.setEditable(false);
		charExcSpacesField.setBounds(202, 316, 90, 26);
		add(charExcSpacesField);
		charExcSpacesField.setColumns(10);

		JTextField paragraphField = new JTextField();
		paragraphField.setBackground(Color.LIGHT_GRAY);
		paragraphField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paragraphField.setEditable(false);
		paragraphField.setBounds(202, 343, 90, 26);
		add(paragraphField);
		paragraphField.setColumns(10);

		//add the buttons
		JButton btnFindWord = new JButton("Find Word");
		btnFindWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordSearch(findWordField, statusField, enterTextArea); 	//pass in the necessary fields
			}

		});
		btnFindWord.setBackground(Color.LIGHT_GRAY);
		btnFindWord.setBounds(270, 139, 81, 41);
		add(btnFindWord);

		JButton wordCount = new JButton("Word Count");
		wordCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!enterTextArea.getText().equals("")){				//checking if text area is empty
					countWords(paragraphField, numWordsField, charExcSpacesField, charIncSpacesField, enterTextArea);	//pass in necessary fields
				}
			}
		});
		wordCount.setBackground(Color.LIGHT_GRAY);
		wordCount.setBounds(314, 289, 126, 57);
		add(wordCount);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enterTextArea.setText("");
				statusField.setText("");
				findWordField.setText("");
				numWordsField.setText("");
				charExcSpacesField.setText("");
				charIncSpacesField.setText("");
				paragraphField.setText("");
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(362, 139, 78, 41);
		add(btnClear);

		//add the labels
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(270, 60, 46, 14);
		add(lblStatus);

		JLabel lblEnterText = new JLabel("Enter text");
		lblEnterText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterText.setBounds(84, 11, 90, 14);
		add(lblEnterText);

		JLabel lblEnterWord = new JLabel("Enter word");
		lblEnterWord.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterWord.setBounds(270, 11, 70, 14);
		add(lblEnterWord);

		JLabel lblCountOfWords = new JLabel("Count of words and characters");
		lblCountOfWords.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCountOfWords.setBounds(49, 245, 205, 14);
		add(lblCountOfWords);

		JLabel lblNumberOfWords = new JLabel("Number of words");
		lblNumberOfWords.setBounds(10, 267, 106, 14);
		add(lblNumberOfWords);

		JLabel lblNumberOfCharacters = new JLabel("Number of characters including spaces");
		lblNumberOfCharacters.setBounds(10, 294, 205, 14);
		add(lblNumberOfCharacters);

		JLabel lblNumberOfCharacters_1 = new JLabel("Number of characters without spaces");
		lblNumberOfCharacters_1.setBounds(10, 322, 182, 14);
		add(lblNumberOfCharacters_1);

		JLabel lblNumberOfParagraphs = new JLabel("Number of paragraphs");
		lblNumberOfParagraphs.setBounds(10, 349, 164, 14);
		add(lblNumberOfParagraphs);

	}

	private void countWords(JTextField paragraphField, JTextField numWordsField, JTextField charExcSpacesField, JTextField charIncSpacesField, JTextArea enterTextArea) {
		//counting the words
		String enterText = enterTextArea.getText().trim();	//get text and trim any excess whitespace
		int words = enterText.split("\\s+").length;			//split the string around the spaces and get the length of the resulting array
		numWordsField.setText(Integer.toString(words));		//show the number of words

		//counting the number of paragraphs
		int paraCount = 0; //keep track of number of paragraphs
		for(int i = 0; i < enterText.length(); ++i){
			if(enterText.charAt(i) == '\n' && enterText.charAt(i + 1) != '\n'){
				paraCount++;
			}
		}
		paragraphField.setText(Integer.toString(paraCount + 1)); //add one to paraCount for the first paragraph

		//counting the characters including spaces
		enterText = enterText.replaceAll("\n", "");		//not including carriage return in count
		charIncSpacesField.setText(Integer.toString(enterText.length()));

		//counting characters excluding spaces
		enterText = enterText.replaceAll(" ", "");
		charExcSpacesField.setText(Integer.toString(enterText.length()));
	}

	private void wordSearch(JTextField findWordField, JTextField statusField, JTextArea enterTextArea) {
		String textArea = enterTextArea.getText(); //get text from text area
		String findWord = findWordField.getText(); //get text from find word field

		Highlighter highlight = enterTextArea.getHighlighter(); //setup highlighter
		HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
		highlight.removeAllHighlights();

		if(!textArea.equals("") && !findWord.equals("")){ //making sure field and text area are not blank
			int startIndex = textArea.indexOf(findWord); //getting index of the word to be found
			if(startIndex == -1){			//if word is not found
				statusField.setForeground(Color.red);
				statusField.setText("Word not found");
			} else {
				try {
					highlight.addHighlight(startIndex, startIndex + findWord.length(), painter); //highlight found word
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				statusField.setForeground(Color.BLUE);
				statusField.setText("Word found at: " + (startIndex + 1)); //add one to offset index starting at 0
			}
		}
	}
}
