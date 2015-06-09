import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestFrame2 implements ActionListener {
     
   private JFrame frame;    
   private JList genreList;
   private JLabel genreLabel;
   private JButton next;
      
   public TestFrame2() {
      frame = new JFrame("Story Generator");
      //frame.setForeground(Color.RED);
      frame.setSize(new Dimension(300, 300));
      frame.setLocation(new Point(100, 150));
      
      //components 
      genreLabel= new JLabel ("What genre do you want?");
      String[] genres = {"Sci-fi", "Mystery", "Fantasy", "Realistic", "Historical", "Superhero" ,"Any"};
      genreList = new JList(genres);
      next = new JButton("Next >");
      next.addActionListener(this);
      
      //layout
      //frame = new JFrame("Story Generator");
      frame.setLayout(new FlowLayout());
      frame.add(genreLabel);
      frame.add(genreList);
      frame.add(next);
      
      
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent event) {
      int index = genreList.getSelectedIndex();
   }
   
   public static void main (String[] args) {
      new TestFrame2();
   }

}