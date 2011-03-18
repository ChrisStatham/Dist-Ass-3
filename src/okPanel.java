import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class okPanel implements ActionListener{
	private JFrame frame;
	public JPanel mainPanel;
	public JButton okButton;
	private JButton cancelButton;
	private JPanel bottomBar;
	private JPanel pane;
	int x;
	int y;

	public okPanel(){
		frame = new JFrame();
		mainPanel = new JPanel();
		okButton = new JButton ("OK");
		cancelButton = new JButton ("Cancel");
		x = 300;
		y = 200;
		frame.setResizable(false);

	}

	public void buildGUI(){
		pane = new JPanel();

		pane.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();

		con.gridy = 0;
		con.gridwidth = 3;
		con.gridheight = 5;
		mainPanel.setPreferredSize(new Dimension(x,y));
		pane.add(mainPanel,con);

		con = resetConstraints();

		con.insets = new Insets(0,20,7,0);
		con.gridy = 5;
		okButton.addActionListener(this);
		pane.add(okButton,con);


		con.insets = new Insets(0,0,7,20);
		con.gridx = 2;
		con.anchor = GridBagConstraints.LINE_END;
		cancelButton.addActionListener(this);
		pane.add(cancelButton,con);

		frame.add(pane);
		center();
		frame.setVisible(true);
	}

	public void buildSingleGUI(){
			pane = new JPanel();

			pane.setLayout(new GridBagLayout());
			GridBagConstraints con = new GridBagConstraints();

			con.gridy = 0;
			con.gridwidth = 3;
			con.gridheight = 5;
			mainPanel.setPreferredSize(new Dimension(x,y));
			pane.add(mainPanel,con);

			con = resetConstraints();

			con.insets = new Insets(0,20,7,0);
			con.gridy = 6;
			okButton.addActionListener(this);
			pane.add(okButton,con);

			frame.add(pane);
			center();
			frame.setVisible(true);
	}

	public void setOKButton(String text){
		okButton.setText(text);
	}

	public void setCancelButton(String text){
    	cancelButton.setText(text);
	}

	public void setSize(int newX, int newY){
		x = newX;
		y = newY;
	}

	public void show(){
		frame.setVisible(true);
	}

	public JFrame getFrame(){
		return frame;
	}

	public void hide(){
			frame.setVisible(false);
	}

	public JPanel getMainPanel(){
		return mainPanel;
	}

	public void repack(){
		frame.pack();
	}

	private GridBagConstraints resetConstraints(){
			return new GridBagConstraints();
	}

	public void errorMessage(String message){
		JOptionPane.showMessageDialog(frame, message);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(okButton)){
			ok();
		}

		if(e.getSource().equals(cancelButton)){
			cancel();
		}
	}



	public void center(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setSize(screenWidth / 4, screenHeight / 4);
		frame.setLocation(screenWidth / 3, screenHeight / 3);
    }

	public abstract void ok();
	public abstract void cancel();
}
