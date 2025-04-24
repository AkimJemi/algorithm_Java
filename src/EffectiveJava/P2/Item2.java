package EffectiveJava.P2;

public class Item2 {
    public static void main(String[] args) {
        NutritionFacts co = new NutritionFacts.Builder(240,8).calories(1).sodium(20).fat(2).carbohydrate(20).build();
        System.out.println(co);
    }
}