import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
      
/**
* creates the primary GUI
* @author Chris Statham
*/
public class GUI implements ActionListener, KeyListener{

    Client c;
    public JMenuItem connectItem;
    JPanel panel;
    JScrollPane scroll;
    JEditorPane editor;
    JTextField text;
    JButton send;

    public void GUI() {

    }

    public void setClient(Client c){
      this.c = c;
    }


    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Create Components
        panel = new JPanel();
	editor = new JEditorPane();
        scroll = new JScrollPane(editor);
	send = new JButton("Send");
	text = new JTextField(50);

        scroll.setPreferredSize(new Dimension (575,390));	
	panel.setPreferredSize(new Dimension(600,455));
	editor.setEditable(false);

	send.addActionListener(this);
        text.addKeyListener(this);

	panel.add(scroll);
        panel.add(text);
        panel.add(send);
        
	frame.add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void updateText(String s){
      editor.setText(editor.getText() + "\n" + s);
    }

    public void actionPerformed(ActionEvent e){
      sendMessage();
    }

    private void sendMessage(){
        String message = new String("");
        String msg = text.getText();
        text.setText("");
        String[] words = msg.split("\\s");
	try{
		// if the message is a wisper
		if(words[0].equals("/w")){
		  for(int i=2;i<words.length;i++){
		    message = message + " " +words[i];
		  }
		  Message m = new Message(message,"wisper",words[1],c.getName());
		  c.sendMsg(m);
		  //broadcast
		} else if(words[0].equals("/broadcast")){
		  for(int i=1;i<words.length;i++){
		    message = message +" "+ words[i];
		  }
		  Message m = new Message(message,"broadcast",c.getRoom(),c.getName());
		  c.sendMsg(m);
		  // regular message 
		} else if(words[0].equals("/list")){
                  Message m = new Message("","list",c.getRoom(),c.getName());
		  c.sendMsg(m);
                } 
		
		else{        
		  Message m = new Message(msg,"normal",c.getRoom(),c.getName());
                  c.sendMsg(m);
		} 
                
        } catch(Exception exp){
	  updateText("Exception: " + exp);
        }
    }

    public void start(String name){
      try{
      Client c = new Client(name,"default",this);
      this.setClient(c);
      this.createAndShowGUI();
      } catch (Exception e){
   
      }
    }

    public void keyReleased (KeyEvent e){
        //updateText(e.getKeyCode() + " VS " + KeyEvent.VK_ENTER );
 	if( e.getKeyCode() == KeyEvent.VK_ENTER ){
          sendMessage();
        }
    }

    public void keyPressed (KeyEvent e){
	
    }

    public void keyTyped (KeyEvent e){

    }

    public static void main(String args[]) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.

     GUI gui = new GUI();
        
     gui.createAndShowGUI();
  
    }
}

