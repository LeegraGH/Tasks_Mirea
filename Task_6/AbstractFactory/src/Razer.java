public class Razer implements HardwareFactory {
    @Override
    public Input createInput() {
        return new RazerInput();
    }

    @Override
    public Streaming createStreaming() {
        return new RazerStreaming();
    }

    @Override
    public Headsets createHeadsets() {
        return new RazerHeadsets();
    }

    @Override
    public Speakers createSpeakers() {
        return new RazerSpeakers();
    }
}

class RazerInput implements Input {
}

class RazerStreaming implements Streaming {
}

class RazerHeadsets implements Headsets {
}

class RazerSpeakers implements Speakers {
}
