package ocean.simulation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Bradersh
 */
public class GUI extends JFrame {

    public static boolean run = false;
    //GUI compoenents
    private final JTextField PlanktonProb = new JTextField(5);
    private final JTextField SharkProb = new JTextField(5);
    private final JTextField SardineProb = new JTextField(5);
    private final JTextField PlanktonBreedProb = new JTextField(5);
    private final JTextField SharkBreedProb = new JTextField(5);
    private final JTextField SardineBreedProb = new JTextField(5);
    private final JTextField PlanktonNValue = new JTextField(5);
    private final JTextField SardineNValue = new JTextField(5);
    private final JTextField SharkMaxAge = new JTextField(5);
    private final JTextField PlanktonMaxAge = new JTextField(5);
    private final JTextField SardineMaxAge = new JTextField(5);
    private final JTextField SharkMinBreedAge = new JTextField(5);
    private final JTextField PlanktonMinBreedAge = new JTextField(5);
    private final JTextField SardineMinBreedAge = new JTextField(5);
    private final JTextField Seed = new JTextField(5);
    private final JTextField Depth = new JTextField(5);
    private final JTextField Width = new JTextField(5);
    private final JTextField Simulation = new JTextField(5);
    private final JLabel Shark;
    private final JLabel Sardine;
    private final JLabel Plankton;
    private final JLabel ProbLabel;
    private final JLabel BreedProbLabel;
    private final JLabel NValueLabel;
    private final JLabel MaxAgeLabel;
    private final JLabel MinBreedAgeLabel;
    private final JLabel SeedLabel;
    private final JLabel DepthLabel;
    private final JLabel WidthLabel;
    private final JLabel SimulationLabel;
    private final JButton Button;

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

        //Step 2 Set Properties
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

        //Step 3 Specify Layout manager
        setLayout(new GridLayout(6, 5, 10, 10));

        //Step 4 Add components to container 
        add(new JLabel());
        add(ProbLabel);
        add(BreedProbLabel);
        add(MaxAgeLabel);
        add(MinBreedAgeLabel);
        add(NValueLabel);

        add(Plankton);
        add(PlanktonProb);
        add(PlanktonBreedProb);
        add(PlanktonMaxAge);
        add(PlanktonMinBreedAge);
        add(PlanktonNValue);

        add(Sardine);
        add(SardineProb);
        add(SardineBreedProb);
        add(SardineMaxAge);
        add(SardineMinBreedAge);
        add(SardineNValue);

        add(Shark);
        add(SharkProb);
        add(SharkBreedProb);
        add(SharkMaxAge);
        add(SharkMinBreedAge);
        add(new JLabel());

        add(new JLabel());
        add(SeedLabel);
        add(DepthLabel);
        add(WidthLabel);
        add(SimulationLabel);
        add(new JLabel());
        add(new JLabel());
        add(Seed);
        add(Depth);
        add(Width);
        add(Simulation);
        add(Button);

        //Step 5 handle events
        Button.addActionListener((ActionEvent e) -> {
            setConstants();
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Step 6 display GUI
        pack();
        setVisible(true);
    }

    public static boolean isRun() {
        return run;
    }

    //Sets the model constants values from the gui interface, sets run to true so the simulation can run and hides the gui
    public void setConstants() {
        ModelConstants.SetConstants(Integer.parseInt(Depth.getText()), Integer.parseInt(Width.getText()), Integer.parseInt(PlanktonProb.getText()), Integer.parseInt(SardineProb.getText()), Integer.parseInt(SharkProb.getText()), Integer.parseInt(SharkMaxAge.getText()), Integer.parseInt(SardineMaxAge.getText()), Integer.parseInt(PlanktonMaxAge.getText()), Integer.parseInt(PlanktonNValue.getText()), Integer.parseInt(SardineNValue.getText()), Integer.parseInt(Seed.getText()), Integer.parseInt(SharkBreedProb.getText()), Integer.parseInt(SardineBreedProb.getText()), Integer.parseInt(PlanktonBreedProb.getText()), Integer.parseInt(SharkMinBreedAge.getText()), Integer.parseInt(SardineMinBreedAge.getText()), Integer.parseInt(PlanktonMinBreedAge.getText()), Integer.parseInt(Simulation.getText()));
        run = true;
        setVisible(false);
    }
}
