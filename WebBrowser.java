import java.awt.Desktop;
import java.net.URI;

public class WebBrowser {
    public static void openWebpage(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url)); // Открываем URL в браузере
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
