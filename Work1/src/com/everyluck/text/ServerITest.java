package com.everyluck.text;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.everyluck.Entity.DataCount;
import com.everyluck.Util.Util;
import com.everyluck.serverI.ServerI;

class ServerITest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void ServerIRowTest() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		System.out.println("行数是："+si.countRow(list));
		
	}
	@Test
	void countWordTest() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		int count = si.countWord(list);
		System.out.println("单词数"+count);
	}
	@Test
	void countCharTest() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		int count = si.countChar(list);
		System.out.println("字符数"+count);
	}
	@Test 
	void countBlankTest() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		System.out.println("空白行是"+si.countBlank(list));
	}
	@Test
	void countCodeRow() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		System.out.println("代码行是"+si.countCodeRow(list));
	}
	@Test 
	void countNoteRowTest() {
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		ServerI si = new ServerI();
		System.out.println("注释行是"+si.countNoteRow(list));
	}
	@Test
	void batchTest() {
		
		ServerI si = new ServerI();
		List<DataCount> list = si.batch("/Users/everyluck/eclipse-workspace/Work1/text/");
		for(int i=0;i<list.size();i++) {
			DataCount dc = list.get(i);
			System.out.println("文件名"+dc.getName());
			System.out.println("单词数"+dc.getWordCount());
		}
	}
	
	@Test
	void oneDispose() {
		ServerI si = new ServerI();;
		DataCount dc = si.onedispose("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		System.out.println(dc.getWordCount());
	}

}
