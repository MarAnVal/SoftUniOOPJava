package Calculator;

public class ExtendedInputInterpreter extends InputInterpreter {
    private Memory memory = new Memory();
    public ExtendedInputInterpreter(CalculationEngine engine) {
        super(engine);
        this.memory = new Memory();
    }

    @Override
    public Operation getOperation(String operation) {
        Operation operationName = super.getOperation(operation);
        if (operationName != null) {
            return operationName;
        }
        if (operation.equals("/")) {
            return new DivisionOperation();
        }
        else if (operation.equals("ms")) {
            return new MemorySaveOperation(memory);
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(memory);
        }
        return null;
    }
}
