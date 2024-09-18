public class RendererFactory {
    public Renderer getRenderer(String type) {
        if (type.equals("none")) {
            return new VoidRender();

        }
        else {
            return new ConsoleRenderer();
        }
    }
}
