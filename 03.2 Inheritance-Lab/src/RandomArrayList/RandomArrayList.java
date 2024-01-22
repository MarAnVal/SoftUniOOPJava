package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList<T> extends ArrayList<T> {
    private Random random;
    public RandomArrayList() {
        super();
    }
    public Object getRandomElement(){
        Object element;
        this.random = new Random();
        int randomIndex = random.nextInt(super.size());
        element = this.get(randomIndex);
        this.remove(randomIndex);
        return element;
    }
}
