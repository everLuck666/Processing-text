package com.everyluck.serverI;

import java.util.ArrayList;
import java.util.List;

import com.everyluck.Entity.DataCount;
import com.everyluck.Util.Util;
import com.everyluck.server.Server;

public  class ServerI implements Server{

	@Override
	public int countWord(List list) {
		// TODO Auto-generated method stub
		int sum = 0;
		String regex = "[a-zA-Z]+";
		for(Object e:list) {
			String text = e.toString();
			if(!text.equals("")) {
				String[] count = text.split("\\s+");
				for(int i=0;i<count.length;i++) {
					if(count[i].matches(regex)) {
						sum++;
					}
				}
				
			}
		}
			
		return sum ;
	}

	@Override
	public int countRow(List list) {
		// TODO Auto-generated method stub
		 return list.size();
		
	}

	@Override
	public int countChar(List list) {
		
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<list.size();i++) {
			String text = list.get(i).toString();
			
			for(int j = 0;j<text.length();j++) {
				if(!sb.toString().contains(text.charAt(j)+"")) {
					if(text.charAt(j)>='A'&&text.charAt(j)<='z')
					sb.append(text.charAt(j));
					
				
				}
			}
		}
		return sb.length();
	}

	public int countBlank(List list) {
		int count = 0;
		for(Object e:list) {
			if(e.equals("")) {
				count++;
			}
		}
		return count;
	}
    public int countCodeRow(List list) {

    	int sum = 0;
    	for(Object e:list) {
			String text = e.toString();
			if(text.length()>1) {
				sum++;
			}
		}
    	return sum;
    }
    public int countNoteRow(List list) {
    	int sum = 0;
    	for(Object e:list) {
    		String text = e.toString();
    		if(text.contains("//")) {
    			sum++;

    		}
    	}
    	return sum;
    }
    public List<DataCount> batch(String path) {
    	List name = Util.returnFoldText(path);
    	List<DataCount> list2 = new ArrayList();
    	for(int i=0;i<name.size();i++) {
    		String foldName = path+"/"+name.get(i).toString();
    		List list = Util.readFunction(foldName);
    		DataCount dc = new DataCount();
    		dc.setBlankCount(countBlank(list));
    		dc.setCharCount(countChar(list));
    		dc.setCodeCount(countCodeRow(list));
    		dc.setNoteCount(countNoteRow(list));
    		dc.setRowCount(countRow(list));
    		dc.setWordCount(countWord(list));
    		dc.setName(foldName);
    		
            list2.add(dc);
    	}
    	return list2;
    }
    public DataCount onedispose(String path) {
    	List list = Util.readFunction(path);
    	DataCount dc = new DataCount();
		dc.setBlankCount(countBlank(list));
		dc.setCharCount(countChar(list));
		dc.setCodeCount(countCodeRow(list));
		dc.setNoteCount(countNoteRow(list));
		dc.setRowCount(countRow(list));
		dc.setWordCount(countWord(list));
		
		return dc;
    	
    }
}
