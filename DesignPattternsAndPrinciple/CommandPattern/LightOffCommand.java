public class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light l) { this.light = l; }
    public void execute() { light.off(); }
}