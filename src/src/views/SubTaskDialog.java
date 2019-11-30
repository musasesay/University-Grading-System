package views;

import javax.swing.*;
import java.awt.*;

public class SubTaskDialog extends JDialog {


            JLabel nameLabel;
            JTextField nameTf;
            JLabel docLabel;
            JTextField docTf;

            JLabel dataDueLabel;
            JTextField dateDueTf;
            JLabel maxScoreLabel;
            JTextField maxScoreTf;


            JLabel weightLabel;
            JTextField weightTf;
            JLabel bonusLabel;
            JTextField bonusTf;


            String name;
            String doc;
            String dateDue;
            double maxScore;
            double weight;
            double bonusPoints;
            JLabel other;
            JLabel group;
            JCheckBox groupCheck;


            JButton gradeButton;
            JButton deleteButton;
            JButton cancelButton;
            JButton saveButton;

            SubTaskDialog(JFrame parent) {

                super(parent, "Details", false);
                setAttributes();
                setSize(400, 700);

                setLayout(new GridBagLayout());

                GridBagConstraints gc = new GridBagConstraints();
                gc.gridx = 0;
                gc.gridy = 0;
                gc.weightx = 1;
                gc.weighty = 1;
                gc.fill = GridBagConstraints.NONE;


                nameLabel = new JLabel("Subtask's name: ");
                nameTf = new JTextField(name);

                docLabel = new JLabel("Date of Creation: ");
                docTf = new JTextField(doc);

                dataDueLabel = new JLabel("Date Due: ");
                dateDueTf = new JTextField(dateDue);

                maxScoreLabel = new JLabel("Max Score: ");
                maxScoreTf = new JTextField(Double.toString(maxScore));

                weightLabel = new JLabel("Weight between subtasks: ");
                weightTf = new JTextField(Double.toString(weight));

                bonusLabel = new JLabel("Number of available bonus points: ");
                bonusTf = new JTextField(Double.toString(bonusPoints));

                other = new JLabel("Other useful information: ");

                groupCheck = new JCheckBox();
                group = new JLabel("Group Project");




                saveButton = new JButton("Save changes");
                deleteButton = new JButton("Delete this Subtask");
                cancelButton = new JButton("Cancel");
                gradeButton = new JButton("Grades");

                add(nameLabel, gc);
                gc.gridx = 1;
                add(nameTf, gc);
                gc.gridy = 1;
                gc.gridx = 0;
                add(docLabel, gc);
                gc.gridy = 1;
                gc.gridx = 1;
                add(docTf, gc);
                gc.gridy = 2;
                gc.gridx = 0;
                add(dataDueLabel, gc);
                gc.gridy = 2;
                gc.gridx = 1;
                add(dateDueTf, gc);
                gc.gridy = 3;
                gc.gridx = 0;
                add(maxScoreLabel, gc);
                gc.gridy = 3;
                gc.gridx = 1;
                add(maxScoreTf, gc);
                gc.gridy = 4;
                gc.gridx = 0;
                add(weightLabel, gc);
                gc.gridy = 4;
                gc.gridx = 1;
                add(weightTf, gc);
                gc.gridy = 5;
                gc.gridx = 0;
                add(bonusLabel, gc);
                gc.gridy = 5;
                gc.gridx = 1;
                add(bonusTf, gc);
                gc.gridy = 6;
                gc.gridx = 0;
                add(other, gc);
                gc.gridy = 7;
                JPanel comboPanel = new JPanel();
                comboPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                comboPanel.add(groupCheck);
                comboPanel.add(group);
                add(comboPanel, gc);
                gc.gridy = 8;
                add(gradeButton, gc);
                gc.gridy = 9;
                add(saveButton, gc);
                gc.gridy = 10;
                add(deleteButton, gc);
                gc.gridy = 11;
                add(cancelButton, gc);



            }

            public void setNameLabel(String name) {
                this.nameLabel = new JLabel(name);
            }

            public void setWeightLabel(String weight) {
                this.weightLabel = new JLabel("Weight of this task in final grade: " + weight);
            }

            public void setAttributes() {
                 name = "Home work";
                 doc = "05/11/2019";
                 dateDue = "10/11/2019";
                 maxScore = 100;
                 weight = 0.3;
                 bonusPoints = 10;
            }
        }

