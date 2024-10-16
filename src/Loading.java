import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame {
    JProgressBar progess;
    Loading() {
        setTitle("Loading");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 200, 400, 130);

        progess = new JProgressBar(0, 100);
        progess.setBounds(50, 20, 300, 40);
        progess.setBackground(Color.BLACK);
        progess.setForeground(Color.red);
        progess.setStringPainted(true);

        setLayout(null);
        add(progess);
        setVisible(true);
        fill();
        progess.setString("DONE!!!!!");
        dispose();
    }
    private void fill()
    {
        for(int i=0; i<=100; i++)
        {
            progess.setValue(i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
}
