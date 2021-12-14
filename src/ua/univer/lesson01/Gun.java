package ua.univer.lesson01;

public class Gun {
    private String name;
    private double damage;

    public Gun(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Gun{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }
}
