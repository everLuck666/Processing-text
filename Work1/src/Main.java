import java.util.List;
import java.util.Scanner;

import com.everyluck.Entity.DataCount;
import com.everyluck.Util.Util;
import com.everyluck.serverI.ServerI;

public class Main {
	
	public static void main(String[] args) {
		ServerI si = new ServerI();
		System.out.println("*******************");
		System.out.println("输入-c返回文件字符数");
		System.out.println("输入-w返回单词数");
		System.out.println("输入-l返回行数");
		System.out.println("输入-s递归处理目录下的文件");
		System.out.println("输入-a返回复杂数据");
		System.out.println("输入-x打开图形化窗口，开可更改路径");
		System.out.println("*****************************");
		Scanner sc = new Scanner(System.in);
		while(true) {
		String s = sc.next();
		List list = Util.readFunction("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		switch(s) {
		case "-c":System.out.println("文件字符数:"+si.countChar(list));
		break;
		case "-w":System.out.println("单词数:"+si.countWord(list));
		break;
		case "-l":System.out.println("行数："+si.countRow(list));
		break;
		case "-s":System.out.println("递归显示text文件下的所有统计");
		List<DataCount> list2 = si.batch("/Users/everyluck/eclipse-workspace/Work1/text/");
		for(int i=0;i<list2.size();i++) {
			DataCount dc = list2.get(i);
			System.out.println("文件名是"+dc.getName());
			System.out.println("单词数量"+dc.getWordCount());
			System.out.println("行数"+dc.getRowCount());
			System.out.println("空白行数"+dc.getBlankCount());
			System.out.println("注释数"+dc.getNoteCount());
			System.out.println("字符数"+dc.getCharCount());
			System.out.println("代码行"+dc.getCodeCount());
		}
		break;
		case "-a":
		DataCount dc = si.onedispose("/Users/everyluck/eclipse-workspace/Work1/text/Qs.txt");
		System.out.println("单词数量"+dc.getWordCount());
		System.out.println("行数"+dc.getRowCount());
		System.out.println("空白行数"+dc.getBlankCount());
		System.out.println("注释数"+dc.getNoteCount());
		System.out.println("字符数"+dc.getCharCount());
		System.out.println("代码行"+dc.getCodeCount());
		break;
		case "-x":
			JFilChooerTest frame = new JFilChooerTest();
			frame.setVisible(true);
		}
	}
	}

}
