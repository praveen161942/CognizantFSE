public class RemoteControl {
    private Command command;
    public void setCommand(Command cmd) { this.command = cmd; }
    public void pressButton() { command.execute(); }
}