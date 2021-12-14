package ua.univer.lesson01;

public class Droid {
    private String name;
    private double damageLevel;
    private double energyLevel;
    private Shield shield;
    private static Engine engine;
    private Gun gun;

    public Droid(String name, double damageLevel, double energyLevel, Gun gun) {
        this.name = name;
        this.damageLevel = damageLevel;
        this.energyLevel = energyLevel;
        this.gun = gun;
        engine = new Engine("E1",100, Engine.TypeEngine.Electro);
    }

    public static void setEngine(Engine engine) {
        Droid.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(double damageLevel) {
        this.damageLevel = damageLevel;
    }

    public double getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(double energyLevel) {
        this.energyLevel = energyLevel;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", damageLevel=" + damageLevel +
                ", energyLevel=" + energyLevel +
                ", engine=" + engine +
                ", shield=" + shield +
                '}';
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public static class Engine {
        private String name;
        private double power;
        private TypeEngine typeEngine;

        public Engine(String name, double power, TypeEngine typeEngine) {
            this.name = name;
            this.power = power;
            this.typeEngine = typeEngine;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "name='" + name + '\'' +
                    ", power=" + power +
                    ", typeEngine=" + typeEngine +
                    '}';
        }

        public enum TypeEngine {
            Electro("E"), Diesil("D"), Gasoline("G");
            private String name;

             TypeEngine(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "TypeEngine{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
    }

    public class Shield {
        private String name;
        private double defence;

        public Shield(String name, double defence) {
            this.name = name;
            this.defence = defence;
        }
        public Shield(){
            this("S1",100);
        }

        @Override
        public String toString() {
            return "Shield{" +
                    "name='" + name + '\'' +
                    ", defence=" + defence +
                    '}';
        }
    }
}
