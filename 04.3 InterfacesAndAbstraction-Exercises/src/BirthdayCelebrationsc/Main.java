package BirthdayCelebrationsc;

public class Main {
    public static void main(String[] args) {
        String endCommand = "End";
        MainCommandHandler mainCommandHandler = new MainCommandHandler(endCommand);
        mainCommandHandler.readCommand();
        mainCommandHandler.processCommand();
        mainCommandHandler.executeCommand();
    }
}
