package Core.MVP;

import Configs.Config;
import Core.Models.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Presenter {
    private final Model model;
    private final View view;

    public Presenter(View view, String pathDB) {
        this.view = view;
        model = new Model(pathDB);
    }

    public void loadFromFile() {
        model.load();
    }

    public void putForDrawing() {
        if (model.DrawingService().putForDrawing(
                new Toy(view.getToyId(), view.getToyNaming(), view.getToyWeight())))
            view.saveItem();
        else
            view.saveError();
    }

    public void deleteFromDrawing() {
        if (model.DrawingService.getToys().size() == 0)
            view.emptyList();
        else
            model.DrawingService().remove(view.getToyId());
    }

    public void saveToFile() {
        model.save();
        view.saveAll();
    }

    public void showAll() {
        if (model.DrawingService.getToys().size() == 0)
            view.emptyList();
        else
            view.showAll(model.DrawingService.getToys());
    }

    public void clearAll() {
        if (model.DrawingService.getToys().size() == 0)
            view.emptyList();
        else {
            model.DrawingService.getToys().clear();
            view.clearAllRecords();
        }
    }


    public void getDrawing() {
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
        Toy drawnToy;
        List<Toy> drawnToys = new ArrayList<>();
        if (model.DrawingService.getToys().size() != 0) {
            int times = view.drawTimes();
            priorityQueue.addAll(model.DrawingService().getToys());
            while (priorityQueue.size() < times) {
                priorityQueue.addAll(model.DrawingService().getToys());
            }
            for (int i = 0; i < times; i++) {
                drawnToy = priorityQueue.remove();
                view.showGetToy(drawnToy);
                drawnToys.add(drawnToy);
            }
            model.saveResult(Config.pathResult, drawnToys);
        } else
            view.emptyList();


    }
}