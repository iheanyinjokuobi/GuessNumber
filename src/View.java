import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements GuessView {
    JTextField textField;
    JButton play_button;
    JButton reset_button;
    JLabel label;
    Model model;


    public View() {
        super("Guess the Number");
        this.setLayout(new GridLayout(3, 1));

        // set up model
        this.model = new Model();
        model.addView(this);

        // set up JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);

        // set up controller
        GuessController controller = new GuessController(model);


        textField = new JTextField();
        this.add(textField);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));

        play_button = new JButton("Submit");
        play_button.addActionListener(e -> model.guess(Integer.parseInt(textField.getText())));
        play_button.setBackground(new Color(0, 128, 0, 1));
        panel.add(play_button);

        reset_button = new JButton("Reset");
        reset_button.setBackground(new Color(255, 0, 0, 1));
        reset_button.addActionListener(e -> model.generate_new_num());
        panel.add(reset_button);

        this.add(panel);

        label = new JLabel("No hint yet");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);

        this.add(label);

        this.setVisible(true);
    }

    @Override
    public void handleGuess(GuessEvent event) {
        textField.setText(event.getGuess());
        label.setText(event.getHint());
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
