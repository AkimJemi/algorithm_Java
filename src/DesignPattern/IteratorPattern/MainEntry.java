package DesignPattern.IteratorPattern;

public class MainEntry {
    public static void main(String[] args) {
        Item[] items = {
                new Item("A", 1000),
                new Item("B", 2000),
                new Item("C", 3000),
                new Item("D", 4000)
        };
        Array array = new Array(items);
        Iterator it = array.iterator();
        while (it.next()) {
            Item item = (Item) it.current();
            System.out.println(item);

        }

    }
}



