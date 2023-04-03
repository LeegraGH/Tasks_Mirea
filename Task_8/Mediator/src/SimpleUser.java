public class SimpleUser implements User {

    private Chat chat;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleUser(Chat chat, String name) {
        this.name = name;
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Message from: "+this.name);
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Message to " + this.name + ": " + message);
    }
}
