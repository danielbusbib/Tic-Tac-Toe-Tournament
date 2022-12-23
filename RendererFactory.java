/**
 * Renderer Factory.
 */
public class RendererFactory {
    /**
     * Factory of Renderer
     * @param type renderer type
     * @return matching Renderer object
     */
    public Renderer buildRenderer(String type, int size){
        switch (type){
            case "console":
                return new ConsoleRenderer(size);
            case "none":
                return new VoidRenderer();
            default:
                return null;
        }
    }
}
