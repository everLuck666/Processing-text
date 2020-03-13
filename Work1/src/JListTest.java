import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.LayoutQueue;

import com.everyluck.Entity.DataCount;
import com.everyluck.Entity.Path;
import com.everyluck.Util.*;
import com.everyluck.serverI.ServerI;
public class JListTest extends JFrame{
	public static void main(String[] args) {
        new JListTest();
	}
	public JListTest() {
		super();
		Container cp = getContentPane();
		cp.setLayout(null);
		String[] tableValues = (String[]) Util.returnFoldText("/Users/everyluck/eclipse-workspace/Work1/text/").toArray(new String[2]);
		JList jl = new JList(tableValues);
		
		jl.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				String path = Path.getPath()+"/"+jl.getSelectedValue();
				System.out.println("我是path"+path);
				ServerI si = new ServerI();
				DataCount dc = si.onedispose(path);
				
				    StringBuffer sb = new StringBuffer();
					
					
					sb.append("单词数量"+dc.getWordCount());
					sb.append("\n");
					sb.append("行数"+dc.getRowCount());
					sb.append("\n");
					sb.append("空白行数"+dc.getBlankCount());
					sb.append("\n");
					sb.append("注释数"+dc.getNoteCount());
					sb.append("\n");
					sb.append("字符数"+dc.getCharCount());
					sb.append("\n");
					sb.append("代码行"+dc.getCodeCount());
					sb.append("\n");
					
				
				JOptionPane.showMessageDialog(getContentPane(),sb.toString(), "系统信息", JOptionPane.QUESTION_MESSAGE);
			
			}
			
			
		});
		
		JScrollPane js = new JScrollPane(jl);
		js.setBounds(10, 10, 300, 300);
		cp.add(js);
		JButton jb = new JButton("批量统计");
		jb.setBounds(400, 96, 71, 23);
		cp.add(jb);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ServerI si = new ServerI(); 
				List<DataCount> list= si.batch(Path.getPath());
				StringBuffer sb = new StringBuffer();
				for(int i = 0;i<list.size();i++) {
					sb.append("文件名是"+list.get(i).getName());
					sb.append("\n");
					sb.append("单词数量"+list.get(i).getWordCount());
					sb.append("\n");
					sb.append("行数"+list.get(i).getRowCount());
					sb.append("\n");
					sb.append("空白行数"+list.get(i).getBlankCount());
					sb.append("\n");
					sb.append("注释数"+list.get(i).getNoteCount());
					sb.append("\n");
					sb.append("字符数"+list.get(i).getCharCount());
					sb.append("\n");
					sb.append("代码行"+list.get(i).getCodeCount());
					sb.append("\n");
					
				}
				JOptionPane.showMessageDialog(getContentPane(),sb.toString(), "系统信息", JOptionPane.QUESTION_MESSAGE);
			}
			
		});
		setTitle("统计文件");
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
	}

}
