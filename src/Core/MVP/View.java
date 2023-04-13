package Core.MVP;

import java.util.List;
import Core.Models.Toy;

public interface View {
    int getToyId();
    String getToyNaming();
    int getToyWeight();
    void saveAll();
    void saveItem();
    void saveError();
    void emptyList();
    void showAll(List<Toy> toys);
    void clearAllRecords();
    void showGetToy(Toy toy);
    void loadMsg();
    int drawTimes();
}