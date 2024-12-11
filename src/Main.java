import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your request: ");
        String query = scan.nextLine(); // текст запроса пользователя


        try {
            // Используем WikipediaAPI для получения данных
            String response = WikipediaAPI.search(query);

            // Парсим ответ и получаем URL статьи
            List<String> articleUrls = JsonPars.parseArticleUrls(response.toString());

            // Выводим результаты в консоль
            if (articleUrls.isEmpty()) {
                System.out.println("Ничего не найдено!");
                return;
            }
            System.out.println("Найдено " + articleUrls.size() + " результатов:");
            for(int i=0;i<articleUrls.size();i++){
                System.out.print((i+1)+ ". " +  articleUrls.get(i)+"\n");
            }

            System.out.print("Введите номер интересующего результата: ");
            int choice = scan.nextInt();

            if (choice < 1 || choice > articleUrls.size()) {
                System.out.println("Неверный выбор.");
            }

            if (articleUrls.get(choice - 1) != null) {
                // Открываем URL в браузере
                WebBrowser.openWebpage( articleUrls.get(choice - 1));
            }
            else {
                System.out.println("No results found.");
            }
            scan.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
