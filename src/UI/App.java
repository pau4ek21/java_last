package UI;

import java.util.Scanner;

import Configs.Config;
import Core.MVP.Presenter;

public class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter(new ConsoleView(), Config.pathDB);
        presenter.loadFromFile();

        String command;

        while (true) {

            command = prompt("""

            1 - Добавить игрушку к розыгрышу
            2 - Удалить игрушку из розыгрыша
            З - Произвести розыгрыш 
            4 - Показать игрушки для розыгрыша
            5 - Очистить все записи
            6 - Сохранить все записи в файл
            7 - Загрузить все записи из файла
            8 - Выход
            Сделайте свой выбор:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForDrawing();
                    case "2" -> presenter.deleteFromDrawing();
                    case "3" ->
                            presenter.getDrawing();
                    case "4" -> presenter.showAll();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.saveToFile();
                    case "7" -> presenter.loadFromFile();
                    default -> System.out.println("\n Command not found!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static void main(String[] args) {
        App.buttonClick();
    }
}