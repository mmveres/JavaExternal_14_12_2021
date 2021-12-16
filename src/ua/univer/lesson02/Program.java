package ua.univer.lesson02;

import java.util.*;

class Ship{
    private String name;
    private int x;
    private int y;

    public Ship(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public Ship() {
        this("A", 1,1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return x == ship.x && y == ship.y && Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", hash=" + hashCode() +
                '}';
    }
}

class ListShip implements Iterable<Ship>{
    Node head;

    @Override
    public Iterator<Ship> iterator() {
        return new Iterator<Ship>() {
            Node curr = head;
            @Override
            public boolean hasNext() {
                return curr!=null;
            }

            @Override
            public Ship next() {
                Ship ship = curr.data;
                curr= curr.next;
                return ship;
            }
        };
    }

    class Node{
        Ship data;
        Node next;

        public Node(Ship data) {
            this.data = data;
            this.next = null;
        }
    }
    public void add(Ship ship){
        Node node = new Node(ship);
        if(head == null) head = node;
        else{
            node.next = head;
            head = node;
        }
    }
}

public class Program {
    public static void main(String[] args) {
    //    testList();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(17, "c");
        map.put(-36, "d");
        map.put(5, "e");
        System.out.println(map);
        System.out.println(map.get(17));

        Map<Ship, Integer> mapShip = new HashMap<>();
        mapShip.put(new Ship("A",1,2), 100);
        mapShip.put(new Ship("B",2,3), 200);
        mapShip.put(new Ship("C",4,5), 300);
        mapShip.put(new Ship(), 300);
        mapShip.put(new Ship(), 300);
        System.out.println(mapShip);
        System.out.println(mapShip.get(new Ship("A",1,2)));

        ListShip listShip = new ListShip();
        listShip.add(new Ship("A1",1,2));
        listShip.add(new Ship("A2",1,2));
        listShip.add(new Ship("A3",1,2));
        listShip.add(new Ship("A4",1,2));

        for (Ship ship: listShip) {
            System.out.println(ship);
        }

        Iterator<Ship> iter = listShip.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }

    private static void testList() {
        Object [] objects = {"Hi", 1, 2.2, new Object(), new Program(), new Ship()};
        System.out.println(Arrays.toString(objects));
        for (var obj: objects) {
            System.out.println(obj.getClass().getName());
        }
        objects = Arrays.copyOf(objects, objects.length*2);
        System.out.println(objects.length);
        objects[7] = 9;
        System.out.println(Arrays.toString(objects));

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list.get(0));
        Object[] objs= list.toArray();
        System.out.println(Arrays.toString(objs));
        String[] strs = list.toArray(new String[2]);
        System.out.println(Arrays.toString(strs));
        //  Integer[] ints = list.toArray(new Integer[2]);
        //  System.out.println(Arrays.toString(ints));
    }
}
