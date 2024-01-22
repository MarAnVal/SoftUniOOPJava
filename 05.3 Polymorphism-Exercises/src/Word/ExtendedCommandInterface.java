package Word;

import java.util.List;

public class ExtendedCommandInterface extends CommandImpl {
    Clipboard clipboard;

    public ExtendedCommandInterface(StringBuilder text) {
        super(text);
        this.clipboard = new Clipboard();
    }

    class Clipboard {
        String current;

        public Clipboard() {
            this.current = "";
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }
    }

    class CutTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            clipboard.setCurrent(text.substring(startIndex, endIndex));
            text.replace(startIndex, endIndex, "");
        }
    }

    class PasteTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            text.replace(startIndex, endIndex, clipboard.getCurrent());
        }
    }

    @Override
    protected List<Command> initCommands() {
        List<Command> commands = super.initCommands();
        commands.add(new Command("cut", new CutTransform()));
        commands.add(new Command("paste", new PasteTransform()));

        return commands;
    }
}
