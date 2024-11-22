import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your request: ");
        String query = scan.nextLine(); // текст запроса пользователя
        scan.close();

        try {
            // Используем WikipediaAPI для получения данных
            String response = WikipediaAPI.search(query);

            // Парсим ответ и получаем URL статьи
            String articleUrl = JsonPars.parseArticleUrl(response);

            if (articleUrl != null) {
                // Открываем URL в браузере
                WebBrowser.openWebpage(articleUrl);
            } else {
                System.out.println("No results found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
