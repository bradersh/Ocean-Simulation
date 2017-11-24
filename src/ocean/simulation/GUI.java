package ocean.simulation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Bradersh
 */
public class GUI {

    private JFrame parameter;
    private JTextField PlanktonProb = new JTextField(5);
    private JTextField SharkProb = new JTextField(5);
    private JTextField SardineProb = new JTextField(5);
    private JTextField PlanktonBreedProb = new JTextField(5);
    private JTextField SharkBreedProb = new JTextField(5);
    private JTextField SardineBreedProb = new JTextField(5);
    private JTextField PlanktonNValue = new JTextField(5);
    private JTextField SardineNValue = new JTextField(5);
    private JTextField SharkMaxAge = new JTextField(5);
    private JTextField PlanktonMaxAge = new JTextField(5);
    private JTextField SardineMaxAge = new JTextField(5);
    private JTextField SharkMinBreedAge = new JTextField(5);
    private JTextField PlanktonMinBreedAge = new JTextField(5);
    private JTextField SardineMinBreedAge = new JTextField(5);
    private JTextField Seed = new JTextField(5);
    private JTextField Depth = new JTextField(5);
    private JTextField Width = new JTextField(5);
    private JTextField Simulation = new JTextField(5);
    private JLabel Shark;
    private JLabel Sardine;
    private JLabel Plankton;
    private JLabel ProbLabel;
    private JLabel BreedProbLabel;
    private JLabel NValueLabel;
    private JLabel MaxAgeLabel;
    private JLabel MinBreedAgeLabel;
    private JLabel SeedLabel;
    private JLabel DepthLabel;
    private JLabel WidthLabel;
    private JLabel SimulationLabel;
    private JButton Button;

    public GUI() {
        //Step 1 Create Components
        Shark = new JLabel("Shark", SwingConstants.RIGHT);
        Sardine = new JLabel("Sardine", SwingConstants.RIGHT);
        Plankton = new JLabel("Plankton", SwingConstants.RIGHT);
        ProbLabel = new JLabel("Creation Probability", SwingConstants.CENTER);
        BreedProbLabel = new JLabel("Breeding Probability", SwingConstants.CENTER);
        NValueLabel = new JLabel("Nutritional Value", SwingConstants.CENTER);
        MaxAgeLabel = new JLabel("Maximum Age", SwingConstants.CENTER);
        MinBreedAgeLabel = new JLabel("Minimum Breeding Age", SwingConstants.CENTER);
        SeedLabel = new JLabel("Seed", SwingConstants.CENTER);
        DepthLabel = new JLabel("Depth", SwingConstants.CENTER);
        WidthLabel = new JLabel("Width", SwingConstants.CENTER);
        SimulationLabel = new JLabel("Simulation Length", SwingConstants.CENTER);
        Button = new JButton("Run");

        //Set Properties
        PlanktonProb.setText("" + ModelConstants.p);
        SharkProb.setText("" + ModelConstants.sh);
        SardineProb.setText("" + ModelConstants.sa);
        PlanktonBreedProb.setText("" + ModelConstants.BREEDING_PROBABILITY_PLANKTON);
        SharkBreedProb.setText("" + ModelConstants.BREEDING_PROBABILITY_SHARK);
        SardineBreedProb.setText("" + ModelConstants.BREEDING_PROBABILITY_SARDINE);
        PlanktonNValue.setText("" + ModelConstants.PLANKTON_FOOD_VALUE);
        SardineNValue.setText("" + ModelConstants.SARDINE_FOOD_VALUE);
        SharkMaxAge.setText("" + ModelConstants.SHARK_MAX_AGE);
        PlanktonMaxAge.setText("" + ModelConstants.PLANKTON_MAX_AGE);
        SardineMaxAge.setText("" + ModelConstants.SARDINE_MAX_AGE);
        SharkMinBreedAge.setText("" + ModelConstants.BREEDING_AGE_SHARK);
        PlanktonMinBreedAge.setText("" + ModelConstants.BREEDING_AGE_PLANKTON);
        SardineMinBreedAge.setText("" + ModelConstants.BREEDING_AGE_SARDINE);
        Seed.setText("" + ModelConstants.RANDOM_SEED);
        Depth.setText("" + ModelConstants.DEFAULT_DEPTH);
        Width.setText("" + ModelConstants.DEFAULT_WIDTH);
        Simulation.setText("" + ModelConstants.STEPS);

        //Create Containers
        parameter = new JFrame("Set Parameters");
        //Specify Layout manager
        parameter.setLayout(new GridLayout(6, 5, 10, 10));
        //Add components to container 
        parameter.add(new JLabel());
        parameter.add(ProbLabel);
        parameter.add(BreedProbLabel);
        parameter.add(MaxAgeLabel);
        parameter.add(MinBreedAgeLabel);
        parameter.add(NValueLabel);

        parameter.add(Plankton);
        parameter.add(PlanktonProb);
        parameter.add(PlanktonBreedProb);
        parameter.add(PlanktonMaxAge);
        parameter.add(PlanktonMinBreedAge);
        parameter.add(PlanktonNValue);

        parameter.add(Sardine);
        parameter.add(SardineProb);
        parameter.add(SardineBreedProb);
        parameter.add(SardineMaxAge);
        parameter.add(SardineMinBreedAge);
        parameter.add(SardineNValue);

        parameter.add(Shark);
        parameter.add(SharkProb);
        parameter.add(SharkBreedProb);
        parameter.add(SharkMaxAge);
        parameter.add(SharkMinBreedAge);
        parameter.add(new JLabel());

        parameter.add(new JLabel());
        parameter.add(SeedLabel);
        parameter.add(DepthLabel);
        parameter.add(WidthLabel);
        parameter.add(SimulationLabel);
        parameter.add(new JLabel());
        parameter.add(new JLabel());
        parameter.add(Seed);
        parameter.add(Depth);
        parameter.add(Width);
        parameter.add(Simulation);
        parameter.add(Button);

        //handle events
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runSimulation();
            }
        });

        //display GUI
        parameter.pack();
        parameter.setVisible(true);
    }

    public void runSimulation() {
        ModelConstants.SetConstants(Integer.parseInt(Depth.getText()), Integer.parseInt(Width.getText()), Integer.parseInt(PlanktonProb.getText()), Integer.parseInt(SardineProb.getText()), Integer.parseInt(SharkProb.getText()), Integer.parseInt(SharkMaxAge.getText()), Integer.parseInt(SardineMaxAge.getText()), Integer.parseInt(PlanktonMaxAge.getText()), Integer.parseInt(PlanktonNValue.getText()), Integer.parseInt(SardineNValue.getText()), Integer.parseInt(Seed.getText()), Integer.parseInt(SharkBreedProb.getText()), Integer.parseInt(SardineBreedProb.getText()), Integer.parseInt(PlanktonBreedProb.getText()), Integer.parseInt(SharkMinBreedAge.getText()), Integer.parseInt(SardineMinBreedAge.getText()), Integer.parseInt(PlanktonMinBreedAge.getText()), Integer.parseInt(Simulation.getText()));
        parameter.setVisible(false);
        OceanSimulation.run();
        parameter.setVisible(true);
    }

    public static void main(String args[]) {
        GUI gui = new GUI();
    }
}
