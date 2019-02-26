package src;

public class Item {

    String name;
    double weight;

    public Item(String name, double weight){

        this.name = name;
        this.weight = weight;

    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
