package Calculator;

public class MemorySaveOperation implements Operation {
    private int lastSaved;
    private Memory memory;
    private boolean isCompleted;

    public MemorySaveOperation(Memory memory) {

        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.lastSaved = operand;
        this.memory.save(operand);
        this.isCompleted = true;
    }

    @Override
    public boolean isCompleted() {
        return this.isCompleted;
    }

    @Override
    public int getResult() {
        return this.lastSaved;
    }
}
