public class Logitech implements HardwareFactory {
    @Override
    public Input createInput() {
        return new LogitechInput();
    }

    @Override
    public Streaming createStreaming() {
        return new LogitechStreaming();
    }

    @Override
    public Headsets createHeadsets() {
        return new LogitechHeadsets();
    }

    @Override
    public Speakers createSpeakers() {
        return new LogitechSpeakers();
    }
}

class LogitechInput implements Input {
}

class LogitechStreaming implements Streaming {
}

class LogitechHeadsets implements Headsets {
}

class LogitechSpeakers implements Speakers {
}
