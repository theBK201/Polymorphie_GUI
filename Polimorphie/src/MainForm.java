import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MainForm {
    private JButton infoButton;
    private JPanel mainJPanel;
    private JTextField weightTf;
    private JTextField hightTf;
    private JButton calcButton;
    private JLabel bmiNumber;
    private JLabel bmiTitel;
    private JRadioButton mänclichRadioButton;
    private JRadioButton weiblichRadioButton;
    private JTextField ageTf;
    private JTextPane infoTextPane;

    public MainForm() {
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LinkedList<sportDaten> sportDt = new LinkedList<>();

                sportDt.add(new Marathon("Markus", 5, 40, 12));
                sportDt.add(new SpeerWurf("Daniel", 30.23));
                sportDt.add(new Sprint100m("Max", 9, 45));
                String result = "";
                for (int i = 0; i < sportDt.size(); i++) {
                    result = result + sportDt.get(i).display();
                    //System.out.println(sportDt.get(i).line);
                }
                infoTextPane.setText(result);
                infoTextPane.setPreferredSize(new Dimension(500, 300));
            }
        });

        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int height;
                int weight;
                int age;
                double bmi;

                if (mänclichRadioButton.isSelected() && weiblichRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Sie können nur eine geschlecht auswellen !!!");
                }

                if(mänclichRadioButton.isSelected() == false && weiblichRadioButton.isSelected() == false){
                    JOptionPane.showMessageDialog(null,"Sie haben keine geschlecht ausgewelt!");
                }

                if(ageTf.getText().isEmpty() && weightTf.getText().isEmpty() && hightTf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Sie haben keine Daten gegeben!");
                }

                if (mänclichRadioButton.isSelected()) {
                    age = Integer.parseInt(ageTf.getText());
                    weight = Integer.parseInt(weightTf.getText());
                    height = Integer.parseInt(hightTf.getText());

                    bmi= weight * (height * 2);

                    bmiNumber.setText(String.valueOf(bmi));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("App for Sport results Information");
                frame.setPreferredSize(new Dimension(700, 300));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(new MainForm().mainJPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
