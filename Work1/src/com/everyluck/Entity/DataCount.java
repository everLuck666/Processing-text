package com.everyluck.Entity;

public class DataCount {
	private  int rowCount = 0;
	private  int wordCount = 0;
	private  int charCount = 0;
	private  int blankCount = 0;
	private int noteCount = 0;
	private int codeCount = 0;
	private String name = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  int getBlankCount() {
		return blankCount;
	}
	public  void setBlankCount(int blankCount) {
		blankCount = blankCount;
	}
	public int getNoteCount() {
		return noteCount;
	}
	public void setNoteCount(int noteCount) {
		this.noteCount = noteCount;
	}
	public int getCodeCount() {
		return codeCount;
	}
	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getWordCount() {
		return wordCount;
	}
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	public int getCharCount() {
		return charCount;
	}
	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}

}
