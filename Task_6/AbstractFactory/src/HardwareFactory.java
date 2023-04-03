public interface HardwareFactory {
    Input createInput();

    Streaming createStreaming();

    Headsets createHeadsets();

    Speakers createSpeakers();

}

interface Input {
};

interface Streaming {
};

interface Headsets {
};

interface Speakers {
};