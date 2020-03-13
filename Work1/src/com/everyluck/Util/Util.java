package com.everyluck.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everyluck.Entity.DataCount;

public class Util {
	
	
	public static List readFunction(String path) {
		StringBuffer sb = new StringBuffer();
		List list = new ArrayList();
		DataCount dc = new DataCount();
		if(path != null) {
		File file = new File(path);
		FileReader fr = null;
		if(file.length() == 0) {
			System.out.println("这是空的文件");
		}else {
			try {
				fr = new FileReader(file);
				BufferedReader bf = new BufferedReader(fr);
				String s = null;
				
				try {
					while((s = bf.readLine()) != null) {

						list.add(s);
					}
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("读取失败");
			}
			
			
		}
		
		
	}
		return list;
	}
	
	public static List returnFoldText(String path) {
		File file = new File(path);
		String[] name = null;
		String[] textName = null;
		List list = null;
		if(file.isDirectory()) {
			 name = file.list();
			 list = new ArrayList();
		}
		for(Object e:name) {
		if(e.toString().contains("txt")) {
		list.add(e);
		 }
		}
		return list;
	}

	
	
}
