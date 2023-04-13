package Core.Models;

public class Toy implements Comparable<Toy> {
    public int id;
    public String name;
    public int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "ID игрушки: " + id + "; Название: " + name + "; Вес: " + weight;
    }

    public void setName(String name2) {
    }

    @Override
    public int compareTo(Toy o) {
        return o.getWeight() - this.getWeight();
    }

    public void setWeight(int weight2) {
    }

    public int getId() {
        return id;
    }
}