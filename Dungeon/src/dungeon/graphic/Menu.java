package dungeon.graphic;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel content;
	private CardLayout cl;
	
	//all buttons
	private JButton back = new JButton("Back");
	private JButton play= new JButton("Play");
	private JButton edit=new JButton("Level editor");
	
	
	//all panels
	private JPanel playPanel;
	private JPanel editPanel;
	private JPanel menu;
	
	//all labels
	
	
	
	public Menu() {
		super("Dungeon");
		this.setIconImage(new ImageIcon("rsc/icon.png").getImage());
		this.initMainPanel();
		this.getContentPane().add(content);
		this.setBounds(200,80,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void initMainPanel(){
		
		content=new JPanel();
		cl=new CardLayout();
		content.setLayout(cl);
		
		
		//initialize panels		
		playPanel=new JPanel();
		initPlayPanel();	
		editPanel=new JPanel();
		initEditPanel();
		content=new JPanel();
		initMenuPanel();
		
		
		//listeners
		play.addActionListener(this);
		back.addActionListener(this);
		edit.addActionListener(this);
		
		//layouts
		
		

	}
	
	public void initMenuPanel(){
		menu=new JPanel();
		menu.setLayout(new GridLayout(2,1));	
		menu.add(play);
		menu.add(edit);
		
		//content.add(menu,"menu");
		content.add(playPanel,"play");
		content.add(editPanel,"edit");
	}
	
	public void initPlayPanel(){
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(back,BorderLayout.SOUTH);
		
		playPanel.add(p);
	}
	
	public void initEditPanel(){
		editPanel.add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		 if (obj == back) {
			 cl.show(content,"menu");
		}
		else if (obj == play) {
			cl.show(content,"play");
		}
		else if (obj == edit) {
			cl.show(content,"edit");
		}
	}

}
