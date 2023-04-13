package UI;

import java.util.List;
import java.util.Scanner;

import Configs.Config;
import Core.MVP.View;
import Core.Models.Toy;

public class ConsoleView implements View  {

    Scanner in;

    public ConsoleView(){
        in=new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("ID Игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void saveAll() {
        System.out.println("\nВсе записи сохранены в файл " + Config.pathDB);
    }

    @Override
    public void saveItem() {
        System.out.println("\nУспешно добавлено ");
    }

    @Override
    public void saveError() {
        System.out.println("\nНе удалось добавить");
    }

    @Override
    public void emptyList() {
        System.out.println("Список игрушек пуст!");
    }

    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nВсе игрушки для розыгрыша :");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    @Override
    public void clearAllRecords() {
        System.out.print("\nВсе записи удалены: ");
    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультат розыгрыша: ");
        System.out.println(toy);
    }

    @Override
    public void loadMsg() {
        System.out.println("\nФайл загружен");
    }

    @Override
    public int drawTimes() {
        System.out.print("Сколько раз провести розыгрышь ? : ");
        return Integer.parseInt(in.nextLine());
    }


}