import java.util.EventObject;

public class GuessEvent extends EventObject {
    int guess;
    String hint;
    public GuessEvent(Model model, int guess, String hint) {
        super(model);
        this.guess = guess;
        this.hint = hint;
    }

    public String getGuess() {return String.valueOf(guess);}

    public String getHint() {return hint;}
}
