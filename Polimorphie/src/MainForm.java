import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class MainForm {
    private JButton infoButton;
    private JPanel mainJPanel;
    private JTextField weightTf;
    private JTextField heightTf;
    private JButton calcButton;
    private JLabel bmiNumber;
    private JLabel bmiTitle;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField ageTf;
    private JTextPane infoTextPane;
    private JLabel resultTitleLabel;

    public MainForm() {
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LinkedList<sportData> sportDt = new LinkedList<>();

                sportDt.add(new Marathon("Markus", 5, 40, 12));
                sportDt.add(new SpearThrow("Daniel", 30.23));
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

                double height;
                double weight;
                int age;
                double bmi;
                String bmiStatus = "";
                DecimalFormat df2 = new DecimalFormat("#.##");

                if (ageTf.getText().isEmpty()) {
                    //Error that the user hasn't given his age
                    JOptionPane.showMessageDialog(null, "Sie haben keine Alter gegeben!");
                }
                if (weightTf.getText().isEmpty()) {
                    //Error that the user hasn't given his weight
                    JOptionPane.showMessageDialog(null, "Sie haben keine Gewicht gegeben!");
                }
                if (heightTf.getText().isEmpty()) {
                    //Error that the user hasn't given his height
                    JOptionPane.showMessageDialog(null, "Sie haben keine Größe gegeben!");
                }

                if (maleRadioButton.isSelected()) {
                    age = Integer.parseInt(ageTf.getText());
                    weight = Double.parseDouble(weightTf.getText());
                    height = Double.parseDouble(heightTf.getText());

                    bmi = weight / ((height / 100) * (height / 100));
                    bmiNumber.setText(String.valueOf(df2.format(bmi)));

                    bmiStatus = bmimenTitle(age, bmi, bmiStatus);
                    bmiTitle.setText(bmiStatus);

                    ageTf.setText("");
                    weightTf.setText("");
                    heightTf.setText("");
                }

                if (femaleRadioButton.isSelected()) {
                    age = Integer.parseInt(ageTf.getText());
                    weight = Double.parseDouble(weightTf.getText());
                    height = Double.parseDouble(heightTf.getText());

                    bmi = weight / ((height / 100) * (height / 100));
                    bmiNumber.setText(String.valueOf(df2.format(bmi)));

                    bmiStatus = bmiwomanTitle(age, bmi, bmiStatus);
                    bmiTitle.setText(bmiStatus);

                    ageTf.setText("");
                    weightTf.setText("");
                    heightTf.setText("");
                }
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (femaleRadioButton.isSelected()) {
                    maleRadioButton.setSelected(false);
                }
            }
        });
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (maleRadioButton.isSelected()) {
                    femaleRadioButton.setSelected(false);
                }
            }
        });
    }

    public String bmimenTitle(int age, double bmiN, String bmiStatus) {

        if (bmiN <= 18) {
            return bmiStatus = "Untergewicht";
        } else if (bmiN <= 25) {
            return bmiStatus = "Normalgewicht";
        } else if (bmiN <= 30) {
            return bmiStatus = "leichtes Übergewicht";
        } else {
            return bmiStatus = "Übergewicht";
        }
    }

    public String bmiwomanTitle(int tage, double tbmiN, String bmiStatus) {
        if (tbmiN <= 18 && tage <= 24) {
            return bmiStatus = "Untergewicht";
        } else if (tbmiN <= 25 && tage <= 34) {
            return bmiStatus = "Normalgewicht";
        } else if (tbmiN <= 30 && tage <= 64) {
            return bmiStatus = "leichtes Übergewicht";
        } else {
            return bmiStatus = "Übergewicht";
        }
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

