import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Custom JFrame for the dietary survey application.
 * This JFrame contains various components to capture user input and submit data to a CSV file.
 * It includes labels, text fields, radio buttons, spinners, checkboxes, combo boxes, buttons, and more.
 *
 * @author Your Name
 * @version 1.0
 * @since 2024-12-07
 */
public class CustomJFrame extends JFrame {
    // Labels
	// Labels
	/** The label for the heading of the survey form. */
	private JLabel headingLabel;
	/** The label for the first name input field. */
	private JLabel firstNameLabel;
	/** The label for the last name input field. */
	private JLabel lastNameLabel;
	/** The label for the phone number input field. */
	private JLabel phoneNumberLabel;
	/** The label for the email input field. */
	private JLabel emailLabel;
	/** The label for the gender selection. */
	private JLabel genderLabel;
	/** The label for the water intake question. */
	private JLabel waterLabel;
	/** The label for the meals per day question. */
	private JLabel mealsLabel;
	/** The label for dietary question checkboxes. */
	private JLabel checkBoxLabel;
	/** The label for the walk distance question. */
	private JLabel walkLabel;
	/** The label for the weight input field. */
	private JLabel weightLabel;

	// Text Fields
	/** The text field for the first name input. */
	private JTextField firstNameTextField;
	/** The text field for the last name input. */
	private JTextField lastNameTextField;
	/** The text field for the phone number input. */
	private JTextField phoneNumberTextField;
	/** The text field for the email input. */
	private JTextField emailTextField;

	// Radio Buttons
	/** Radio button for selecting male gender. */
	private JRadioButton maleRadioButton;
	/** Radio button for selecting female gender. */
	private JRadioButton femaleRadioButton;
	/** Radio button for selecting prefer not to say option. */
	private JRadioButton preferRadioButton;
	/** Button group for grouping gender radio buttons. */
	private ButtonGroup radioButtonGroup;

	// Spinner, Slider
	/** Spinner for selecting average water intake. */
	private JSpinner waterIntakeSpinner;
	/** Slider for selecting average number of meals per day. */
	private JSlider mealSlider;

	// Checkboxes
	/** Checkbox for indicating whether the diet contains wheat. */
	private JCheckBox wheatCheckBox;
	/** Checkbox for indicating whether the diet contains sugar. */
	private JCheckBox sugarCheckBox;
	/** Checkbox for indicating whether the diet contains dairy. */
	private JCheckBox dairyCheckBox;

	// Combo Box
	/** Combo box for selecting average walking distance. */
	private JComboBox<String> walkComboBox;
	/** Options for the walk distance selection. */
	private String[] walkOptions = {
	    "Less than 1 Mile",
	    "More than 1 mile but less than 2 miles",
	    "More than 2 miles but less than 3 miles",
	    "More than 3 miles"
	};

	// Formatted Text Field
	/** Formatted text field for entering weight. */
	private JFormattedTextField weightFormattedTextField;

	// Buttons
	/** Button to clear the form fields. */
	private JButton clearButton;
	/** Button to submit the form data. */
	private JButton submitButton;

	// File Handler
	/** The file handler instance for managing file operations. */
	private FileHandler fileHandler;


    /**
     * Constructor to set up the JFrame and initialize all components.
     */
    public CustomJFrame() {
        // Set up JFrame
        super("Dietary Survey");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);

        // Initialize components
        headingLabel = new JLabel("Dietary Survey");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        phoneNumberLabel = new JLabel("Phone Number:");
        emailLabel = new JLabel("Email:");
        genderLabel = new JLabel("Sex:");
        waterLabel = new JLabel("How many cups of water on average do you drink a day?");
        mealsLabel = new JLabel("How many meals on average do you eat a day?");
        checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
        walkLabel = new JLabel("On average how many miles do you walk in a day?");
        weightLabel = new JLabel("How much do you weigh?");

        firstNameTextField = new JTextField(20);
        lastNameTextField = new JTextField(20);
        phoneNumberTextField = new JTextField(20);
        emailTextField = new JTextField(20);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintLabels(true);

        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");
        dairyCheckBox = new JCheckBox("Dairy");

        walkComboBox = new JComboBox<>(walkOptions);

        weightFormattedTextField = new JFormattedTextField();
        weightFormattedTextField.setColumns(10);

        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.YELLOW);
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN);

        fileHandler = new FileHandler();

        // Add Action Listeners
        InnerActionListener actionListener = new InnerActionListener();
        clearButton.addActionListener(actionListener);
        submitButton.addActionListener(actionListener);

        // Add components to frame
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expand components horizontally
        addComponentsToFrame(gbc);

        // Final setup
        pack();
        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    /**
     * Adds a label and its associated component to the JFrame using GridBagLayout and constraints.
     *
     * @param label The label to be displayed.
     * @param component The component (e.g., JTextField, JSpinner, etc.) to be added.
     * @param gbc GridBagConstraints used to position the component.
     * @param row The row in the layout where the component will be placed.
     */
    private void addComponent(JLabel label, JComponent component, GridBagConstraints gbc, int row) {
        gbc.gridwidth = 1;

        // Add the label to the frame
        gbc.gridx = 0;
        gbc.gridy = row;
        add(label, gbc);

        // Add the component to the frame
        gbc.gridx = 1;
        add(component, gbc);
    }

    /**
     * Adds various sections and components to the JFrame using GridBagConstraints.
     *
     * @param gbc GridBagConstraints used to position the components.
     */
    private void addComponentsToFrame(GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.WEST; // Left-align components

        // Heading Label
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        headingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel, gbc);

        // Personal Information Section
        addSectionLabel("Personal Information", gbc, 1);

        addComponent(firstNameLabel, firstNameTextField, gbc, 2);
        addComponent(lastNameLabel, lastNameTextField, gbc, 3);
        addComponent(phoneNumberLabel, phoneNumberTextField, gbc, 4);
        addComponent(emailLabel, emailTextField, gbc, 5);

        // Gender Section
        addSectionLabel("Sex:", gbc, 6);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(createRadioPanel(), gbc);

        // Dietary Questions Section
        addSectionLabel("Dietary Questions", gbc, 8);

        addComponent(waterLabel, waterIntakeSpinner, gbc, 9);
        addComponent(mealsLabel, mealSlider, gbc, 10);

        addComponent(checkBoxLabel, createCheckBoxPanel(), gbc, 11);
        addComponent(walkLabel, walkComboBox, gbc, 12);
        addComponent(weightLabel, weightFormattedTextField, gbc, 13);

        // Buttons Section
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 14;
        add(clearButton, gbc);

        gbc.gridx = 1;
        add(submitButton, gbc);
    }

    /**
     * Adds a section label to the frame.
     *
     * @param text The text to be displayed as the section label.
     * @param gbc GridBagConstraints used to position the label.
     * @param row The row in the layout where the label will be placed.
     */
    private void addSectionLabel(String text, GridBagConstraints gbc, int row) {
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel sectionLabel = new JLabel(text);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 12));
        add(sectionLabel, gbc);
    }

    /**
     * Creates a panel containing gender radio buttons.
     *
     * @return A JPanel containing the radio buttons for gender selection.
     */
    private JPanel createRadioPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(preferRadioButton);
        return panel;
    }

    /**
     * Creates a panel containing the dietary checkboxes.
     *
     * @return A JPanel containing the checkboxes for dietary options.
     */
    private JPanel createCheckBoxPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(dairyCheckBox);
        panel.add(wheatCheckBox);
        panel.add(sugarCheckBox);
        return panel;
    }

    // Inner Action Listener
    private class InnerActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                clearForm();
            } else if (e.getSource() == submitButton) {
                submitForm();
                clearForm();
            }
        }

        /**
         * Clears all the form fields to their default values.
         */
        private void clearForm() {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");
            radioButtonGroup.clearSelection();
            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);
            dairyCheckBox.setSelected(false);
            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setValue(null);
        }

        /**
         * Submits the form data and writes it to the CSV file.
         */
        private void submitForm() {
            String surveyData = String.join(",",
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    phoneNumberTextField.getText(),
                    emailTextField.getText(),
                    getSelectedRadioButton(),
                    waterIntakeSpinner.getValue().toString(),
                    String.valueOf(mealSlider.getValue()),
                    formatCheckBox(wheatCheckBox),
                    formatCheckBox(sugarCheckBox),
                    formatCheckBox(dairyCheckBox),
                    (String) walkComboBox.getSelectedItem(),
                    getWeight()
            );
            fileHandler.writeResults(surveyData);
        }

        /**
         * Gets the selected gender from the radio buttons.
         *
         * @return The selected gender as a string.
         */
        private String getSelectedRadioButton() {
            if (maleRadioButton.isSelected()) return "Male";
            if (femaleRadioButton.isSelected()) return "Female";
            if (preferRadioButton.isSelected()) return "Prefer Not to Say";
            return "null";
        }

        /**
         * Formats the checkbox selection as "TRUE" or "FALSE".
         *
         * @param checkBox The checkbox to check.
         * @return "TRUE" if the checkbox is selected, otherwise "FALSE".
         */
        private String formatCheckBox(JCheckBox checkBox) {
            return checkBox.isSelected() ? "TRUE" : "FALSE";
        }

        /**
         * Gets the weight input by the user.
         *
         * @return The weight as a string, or "null" if not entered.
         */
        private String getWeight() {
            String weight = weightFormattedTextField.getText();
            return (weight == null || weight.isEmpty()) ? "null" : weight;
        }
    }
}
