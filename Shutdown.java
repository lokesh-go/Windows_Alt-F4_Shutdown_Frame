import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shutdown extends JFrame implements ActionListener, ItemListener 
{
	Image img1,img2;
	MediaTracker med;
	Toolkit tk;
	JButton b1,b2,b3;
	JComboBox c1;
	String option[]={"","Shut down","Restart","Hibernate","Sign out"};
	Label l1;
	String s;


	Shutdown()
	{
		l1=new Label("What do you want the computer to do ?");
		l1.setBounds(90,110,230,20);
		add(l1);
		c1=new JComboBox(option);
		c1.setBounds(90,140,350,20);
		add(c1);

		b1=new JButton("OK");
		b1.setBounds(200,200,80,25);
		b1.setBackground(Color.white);
		add(b1);
		b2=new JButton("Cancel");
		b2.setBounds(300,200,80,25);
		b2.setBackground(Color.white);
		add(b2);
		b3=new JButton("Help");
		b3.setBounds(400,200,80,25);
		b3.setBackground(Color.white);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		c1.addItemListener(this);
		
		med=new MediaTracker(this);
		tk=tk.getDefaultToolkit();
		img1=tk.getImage("w1.png");
		img2=tk.getImage("w2.png");

		
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		
		setSize(540,300);
		setLayout(null);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e2)
	{
		 s=c1.getSelectedItem().toString();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(s=="Shut down")
			{
				try
				{
					Runtime run=Runtime.getRuntime();
					Process proc=run.exec("shutdown -s -t 0");
					System.exit(0);
	
				}
				catch (Exception e1)
				{
				}
			}
			if(s=="Restart")
			{
				try
				{
					Runtime run=Runtime.getRuntime();
					Process proc=run.exec("shutdown -r -t 0");
					System.exit(0);
	
				}
				catch (Exception e1)
				{
				}
			}
			if(s=="Hibernate")
			{
				try
				{
					Runtime run=Runtime.getRuntime();
					Process proc=run.exec("shutdown -h -t 0");
					System.exit(0);
	
				}
				catch (Exception e1)
				{
				}
			}
			if(s=="Sign out")
			{
				try
				{
					Runtime run=Runtime.getRuntime();
					Process proc=run.exec("shutdown -l");
					System.exit(0);
	
				}
				catch (Exception e1)
				{
				}
			}
		}


		if(e.getSource()==b2)
		{
			dispose();
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
	//	g2.drawImage(img1,110,50,this);
		g2.drawImage(img1,110,40,this);
		g2.drawImage(img2,35,147,this);
	}
	public static void main(String[] args) 
	{
		new Shutdown();
	}
}
