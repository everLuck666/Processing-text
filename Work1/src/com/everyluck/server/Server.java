package com.everyluck.server;

import java.util.List;

import com.everyluck.Entity.DataCount;

public interface Server {
	
	
	public int countRow(List list);
	public int countChar(List text);
	public int countWord(List text);
	public int countBlank(List list);
	public int countCodeRow(List list);
	public int countNoteRow(List list);
	public List batch(String path);
	public DataCount onedispose(String path);
	

}
