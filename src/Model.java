import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private Random rand;
    private int num;
    private List<GuessView> views;

    public Model(){
        this.rand = new Random();
        rand.setSeed(rand.nextInt());
        this.num = rand.nextInt(100);
        this.views = new ArrayList<GuessView>();
    }

    public void generate_new_num(){
        this.num = rand.nextInt(100);
    }

    public void addView(View view){this.views.add(view);}

    public void removeView(View view){this.views.remove(view);}

    public String evaluate_guess(int guess){
        if (guess > num){
            return "Lower";
        }else if (guess < num){
            return "Higher";
        }
        return "You found the number!";
    }

    public void guess(int guess){
        String hint = evaluate_guess(guess);
        for (GuessView view : views){
            view.handleGuess(new GuessEvent(this, guess, hint));
        }

    }
}
