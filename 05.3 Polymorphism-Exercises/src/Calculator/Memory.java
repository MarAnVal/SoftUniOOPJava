package Calculator;

import java.util.Stack;

public class Memory {
    private Stack<Integer> memory = new Stack<>();

    public void save(int operand) {
        this.memory.push(operand);
    }

    public int recall() {
        if (memory.isEmpty()){
            return 0;
        }
        return this.memory.pop();
    }
}
