package FunctionLayer.Objekter;

/**
 * Svg klassens formål er lave en veiwbox og div. tegninger som kundernes carporte skal bestå af, denne tegning skal
 * vises på hjemmesiden. Klassen består af en række templates og en konstruktor.
 */
public class Svg {

    private int width;
    private int height;
    private String view_box;
    private int x;
    private int y;
    private StringBuilder svg = new StringBuilder();

    /**
     * header_Template dette er en veiwbox.
     * rect_Template dette er en firkant med 1 coordinat og en længde og bredde.
     * kryds_Template dette er en stiplet line med 2 coordinater.
     * textRotatedTemplate dette er en text som kan roteres med en rotation.
     * textTemplate dette er en text som bliver sat fast på 1 coordinat.
     * pilTemplate dette er en line med 2 coordinater.
     * pilspidsTemplate dette er spidsen af pilene på tegningen.
     */
    private final String header_Template = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
            "width=\"%s\" height=\"%s\" x=\"%d\" y=\"%d\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String rect_Template = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String kryds_Template = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; stroke-dasharray: 5 5;\" />";
    private final String textRotatedTemplate = "<text style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(-90)\">%s</text>";
    private final String textTemplate = "<text style=\"text-anchor: middle\" x=\"%d\" y=\"%d\">%s</text>";
    private final String pilTemplate = "<line x1=\"%d\"  y1=\"%d\" x2=\"%d\" y2=\"%d\" \n" + "\tstyle=\"stroke: #006600;\n" +
            "\tmarker-start: url(#beginArrow);\n" + "\tmarker-end: url(#endArrow);\"/>";
    private final String pilspidsTemplate = "<defs>\n" + " <marker \n" + " \tid=\"beginArrow\" \n" + " \tmarkerWidth=\"12\" \n" +
            "\tmarkerHeight=\"12\" \n" + " \trefX=\"0\" \n" + "\trefY=\"6\" \n" + "\torient=\"auto\">\n" +
            "<path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" + "</marker>\n" + "<marker \n" +
            "\tid=\"endArrow\" \n" + " \tmarkerWidth=\"12\" \n" + "\tmarkerHeight=\"12\" \n" + "\trefX=\"12\" \n" +
            "\trefY=\"6\" \n" + "\torient=\"auto\">\n" + "<path d=\"M0,0 L12,6 L0,12 L0,0 \"style=\"fill: #000000;\" />\n" +
            "</marker>\n" + "</defs>";

    public Svg(int width, int height, String viewbox, int x, int y) {
        this.width = width;
        this.height = height;
        this.view_box = viewbox;
        this.x = x;
        this.y = y;
        svg.append(String.format(header_Template, height, width, x, y, viewbox));
    }

    public void add_text_Rotated(int x, int y, String cm) {
        svg.append(String.format(textRotatedTemplate, x, y, cm));
    }

    public void add_text(int x, int y, String cm) {
        svg.append(String.format(textTemplate, x, y, cm));
    }

    public void add_pil(int x, int y, int x2, int y2) { svg.append(String.format(pilTemplate, x, y ,x2, y2)); }

    public void add_pilspids() { svg.append(String.format(pilspidsTemplate)); }

    public void add_Rect(int x, int y, int height, int width) {
        svg.append(String.format(rect_Template, x, y, height, width));
    }

    public void add_Kryds(int x, int y, int height, int width) {
        svg.append(String.format(kryds_Template, x, y, height, width));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getView_box() {
        return view_box;
    }

    public void setView_box(String view_box) {
        this.view_box = view_box;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return svg.toString() + "</svg>";
    }
}
