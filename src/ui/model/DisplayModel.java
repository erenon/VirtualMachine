package ui.model;

import javax.swing.JTextArea;


public class DisplayModel {
	private JTextArea textArea;
	
	public void setTextarea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public void putWord(String word) {
		textArea.append(word);
	}
}
