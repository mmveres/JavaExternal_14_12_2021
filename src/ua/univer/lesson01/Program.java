package ua.univer.lesson01;

public class Program {
    public static void main(String[] args) {
        Droid d1 = new Droid("R2D1", 100, 100, new Gun("Pistol", 10));
        System.out.println(d1);
        Droid.Shield shield1 = d1. new Shield();
        Droid.Engine.TypeEngine typeEngine1= Droid.Engine.TypeEngine.Electro;
        Droid.Engine.TypeEngine typeEngine2= Droid.Engine.TypeEngine.Diesil;

        Droid [] droids = {
                new Droid("R2D1", 100, 100, new Gun("Pistol", 10)),
                new Droid("R2D2", 100, 100, new Gun("Pistol", 10)),
                new Droid("R2D3", 100, 100, new Gun("Pistol", 10))
        };
        int i =0;
        Droid.setEngine(new Droid.Engine("D1",90, Droid.Engine.TypeEngine.Diesil));
        for (var d: droids) {
            d.setShield(d.new Shield("S"+(i++), 100));
            System.out.println(d);

        }
    }
}
