import java.awt.Desktop;
import java.net.URI;

public class WebBrowser {
    public static void openWebpage(String url) {
        try {
            // Проверяем, содержит ли строка разделитель "->"
            if (url.contains("->")) {
                url = url.split("->")[1].trim(); // Извлекаем только URL
            }

            // Создаём URI и открываем в браузере
            URI uri = new URI(url);
            Desktop desktop = Desktop.getDesktop();

            if (Desktop.isDesktopSupported()) {
                desktop.browse(uri); // Открываем URL в браузере
            } else {
                System.err.println("Desktop не поддерживается на этой системе.");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при обработке URL: " + e.getMessage());
        }
    }
}
