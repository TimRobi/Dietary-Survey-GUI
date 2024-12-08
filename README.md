# Dietary-Survey-GUI

# Dietary Survey GUI Application

## Description

This Java application provides a graphical user interface (GUI) for conducting a dietary survey. The survey collects information such as personal details (name, contact), gender, dietary habits, physical activity, and weight. The responses are stored in a CSV file (`survey_results.csv`), which can be later analyzed or used for research purposes.

The application uses Java Swing components like text fields, radio buttons, checkboxes, spinners, sliders, and combo boxes to create a user-friendly interface. Data submission is processed and saved into a CSV file, with a timestamp for each entry.

## Features

- **Personal Information**: Collects first name, last name, phone number, and email address.
- **Gender Selection**: User selects their gender (Male, Female, Prefer not to say).
- **Dietary Habits**: Users input their average water intake, number of meals per day, and checkboxes for common dietary ingredients (wheat, sugar, dairy).
- **Physical Activity**: A dropdown menu for tracking daily walking distance and a field for weight input.
- **Form Management**: Includes buttons for clearing the form and submitting data.
- **CSV File Generation**: Survey results are saved in a CSV file (`survey_results.csv`) with a timestamp for each entry.

## Components

### Main Classes
1. **Project4**: This is the main class that runs the GUI application.
2. **FileHandler**: Handles the reading and writing of survey results to a CSV file.
3. **CustomJFrame**: Manages the GUI components and user interactions for the dietary survey.

### GUI Components
- **Labels**: For instructions and field names (e.g., First Name, Last Name, Gender).
- **Text Fields**: To enter personal information such as name, phone number, and email.
- **Radio Buttons**: For gender selection.
- **Spinners and Sliders**: For tracking water intake and number of meals per day.
- **Checkboxes**: To track dietary habits like wheat, sugar, and dairy consumption.
- **Combo Box**: For selecting average daily walking distance.
- **Buttons**: For clearing the form and submitting survey data.
- **Formatted Text Field**: For entering the user's weight.

## Requirements

- **Java Version**: 8 or higher.
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE that supports Java Swing.

## Installation

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Ensure that your Java development environment is set up correctly (Java 8 or higher).
4. Run the `Project4` class to launch the survey form.

```bash
git clone https://github.com/yourusername/dietary-survey.git
cd dietary-survey
```

## Usage

1. When the application starts, the dietary survey form will be displayed.
2. Fill in your personal information, select dietary preferences, and provide your physical activity details.
3. Once all fields are completed, click the **Submit** button to save the data in the CSV file.
4. You can use the **Clear** button to reset the form and enter new information.

## CSV Output

The survey results will be stored in `survey_results.csv` with the following columns:

- **DateTime**: The date and time when the survey was submitted.
- **FirstName**: The first name of the participant.
- **LastName**: The last name of the participant.
- **PhoneNumber**: The phone number of the participant.
- **Email**: The email address of the participant.
- **Sex**: The gender selected (Male, Female, Prefer not to say).
- **Water**: The average cups of water consumed per day.
- **Meals**: The average number of meals consumed per day.
- **Wheat**: Whether wheat is consumed regularly (True/False).
- **Sugar**: Whether sugar is consumed regularly (True/False).
- **Dairy**: Whether dairy is consumed regularly (True/False).
- **Miles**: The average daily walking distance.
- **Weight**: The weight of the participant.

## Example CSV

```csv
DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight
12/07/2024 14:30:45,John,Doe,123-456-7890,john.doe@example.com,Male,20,3,FALSE,FALSE,TRUE,2,180
```

