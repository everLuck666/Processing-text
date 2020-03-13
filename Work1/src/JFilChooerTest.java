import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.everyluck.Entity.Path;

public class JFilChooerTest extends JFrame{
	public static void main(String[] args) {
		JFilChooerTest frame = new JFilChooerTest();
		frame.setVisible(true);
		
	}
	
	public JFilChooerTest(){
		super();
		setTitle("文件选择对话框");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel,BorderLayout.NORTH);
		JLabel label = new JLabel();
		label.setText("文件");
		panel.add(label);
		JButton button = new JButton();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = fileChooser.showOpenDialog(getContentPane());
				
				
					File selectedFile = fileChooser.getSelectedFile();
					Path.setPath(selectedFile.getAbsolutePath());
					
					dispose();
					new JListTest();
				
				
			}
		});
		button.setText("选择文件");
		panel.add(button);
	}
	

}
