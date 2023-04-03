public class CompanyHardware {
    public final Input inputCompany;
    public final Streaming streamingCompany;
    public final Headsets headsetsCompany;
    public final Speakers speakersCompany;

    CompanyHardware(HardwareFactory factory) {
        inputCompany = factory.createInput();
        streamingCompany = factory.createStreaming();
        headsetsCompany = factory.createHeadsets();
        speakersCompany = factory.createSpeakers();

    }

}
