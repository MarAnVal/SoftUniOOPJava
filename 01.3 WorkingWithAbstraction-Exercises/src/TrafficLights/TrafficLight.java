package TrafficLights;

public class TrafficLight {
    enum Signals {
        GREEN,
        RED,
        YELLOW
    }

    private Signals signal;

    public TrafficLight(Signals signal) {
        this.signal = signal;
    }

    public void update() {
        switch (this.signal) {
            case RED:
                this.signal = Signals.GREEN;
                break;
            case GREEN:
                this.signal = Signals.YELLOW;
                break;
            case YELLOW:
                this.signal = Signals.RED;
                break;
            default:
                throw new IllegalStateException("Unknown state" + this.signal);
        }
    }

    public String getSignal() {
        return signal.toString();
    }
}
