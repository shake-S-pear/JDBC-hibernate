package HWorks.Lesson2.task2.entity;

public class Vegetable {

    private int id;
    private String name;
    private int price;
    private int calories;

    public Vegetable(String name, int price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getCalories() { return calories; }

    public void setCalories(int calories) { this.calories = calories; }
}
