import javax.swing.*;
import java.awt.*;

public class NameGUI extends okPanel{
  GUI g;
  JTextField name;
  JLabel nameLabel;
  public NameGUI(GUI gu){
    super();
    g = gu;
    name = new JTextField(10);
    nameLabel = new JLabel("Attribute Name:"); 
  }  

  public void buildGUI(){
    super.buildGUI();
    this.getMainPanel().add(nameLabel);
    this.getMainPanel().add(name);
    this.repack();
  }

  public void ok(){
    g.start(name.getText()); 
    hide();
  }

  public void cancel(){
    System.exit(1);
  }
}
