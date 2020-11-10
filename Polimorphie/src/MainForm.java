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

                double height;
                double weight;
                int age;
                double bmi;
                DecimalFormat df2 = new DecimalFormat("#.##");

                if (mänclichRadioButton.isSelected() && weiblichRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Sie können nur eine geschlecht auswellen !!!");
                }

                if (mänclichRadioButton.isSelected() == false && weiblichRadioButton.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine geschlecht ausgewelt!");
                }


                if (ageTf.getText().isEmpty() && weightTf.getText().isEmpty() && heightTf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine Daten gegeben!");
                }

                if (ageTf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine Alter gegeben!");
                }
                if (weightTf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine Gewicht gegeben!");
                }
                if (heightTf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine Größe gegeben!");
                }

                if (mänclichRadioButton.isSelected()) {
                    age = Integer.parseInt(ageTf.getText());
                    weight = Double.parseDouble(weightTf.getText());
                    height = Double.parseDouble(heightTf.getText());

                    bmi = weight / ((height / 100) * (height / 100));

                    bmiNumber.setText(String.valueOf(df2.format(bmi)));

                }
            }
        });
    }

    public void bmiMenTitel(int age, int bmiN, String bmiStatus) {

        if (age >= 16) {
            if (bmiN <= 18) {
                bmiStatus = "Untergewicht";
            }
            if (bmiN >= 20 && bmiN <= 24) {
                bmiStatus = "Normalgewicht";
            }
            if (bmiN >= 25 && bmiN <= 28) {
                bmiStatus = "leichtes Übergewicht";
            }
            if (bmiN >= 29) {
                bmiStatus = "Übergewicht";
            }
        }
        if (age >= 17 && age <= 24) {
            if (bmiN <= 18) {
                bmiStatus = "Untergewicht";
            }
            if (bmiN == 19 && bmiN <= 24) {
                bmiStatus = "Normalgewicht";
            }
            if (bmiN == 25 && bmiN <= 28) {
                bmiStatus = "leichtes Übergewicht";
            }
            if (bmiN >= 29) {
                bmiStatus = "Übergewicht";
            }

            if (age >= 25 && age <= 34) {
                if (bmiN <= 19) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 20 && bmiN <= 25) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 26 && bmiN <= 29) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 30) {
                    bmiStatus = "Übergewicht";
                }
            }

            if (age >= 35 && age <= 44) {
                if (bmiN <= 21) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 22 && bmiN <= 27) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 28 && bmiN <= 31) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 32) {
                    bmiStatus = "Übergewicht";
                }
            }
            if (age >= 45 && age <= 54) {
                if (bmiN <= 22) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 23 && bmiN <= 28) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 29 && bmiN <= 32) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 33) {
                    bmiStatus = "Übergewicht";
                }
            }
            if (age >= 55 && age <= 64) {
                if (bmiN <= 23) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 24 && bmiN <= 29) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 30 && bmiN <= 33) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 34) {
                    bmiStatus = "Übergewicht";
                }
            }
            if (age >= 65 && age <= 90) {
                if (bmiN <= 24) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 25 && bmiN <= 30) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 31 && bmiN <= 34) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 35) {
                    bmiStatus = "Übergewicht";
                }
            }
        }
    }

    public void bmiWomanTitel(int age, int bmiN, String bmiStatus) {
        if (age >= 16 && age <= 24) {
            if (bmiN <= 18) {
                bmiStatus = "Untergewicht";
            }
            if (bmiN == 19 && bmiN <= 24) {
                bmiStatus = "Normalgewicht";
            }
            if (bmiN == 25 && bmiN <= 28) {
                bmiStatus = "leichtes Übergewicht";
            }
            if (bmiN >= 29) {
                bmiStatus = "Übergewicht";
            }

            if (age >= 25 && age <= 34) {
                if (bmiN <= 19) {
                    bmiStatus = "Untergewicht";
                }
                if (bmiN == 20 && bmiN <= 25) {
                    bmiStatus = "Normalgewicht";
                }
                if (bmiN == 26 && bmiN <= 29) {
                    bmiStatus = "leichtes Übergewicht";
                }
                if (bmiN >= 30) {
                    bmiStatus = "Übergewicht";
                }
            }
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

