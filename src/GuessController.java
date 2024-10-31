import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessController implements ActionListener {
    private Model model;
    public GuessController(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String guess = e.getActionCommand();
        model.guess(Integer.parseInt(guess));
    }
}
