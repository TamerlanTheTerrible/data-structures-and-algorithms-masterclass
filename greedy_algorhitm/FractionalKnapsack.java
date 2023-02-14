package greedy_algorhitm;

import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class FractionalKnapsack {

    public static void main(String[] args) {
        ArrayList<KnapsackItem> items = new ArrayList<KnapsackItem> (List.of(
                new KnapsackItem(0, 100, 20),
                new KnapsackItem(1, 120, 30),
                new KnapsackItem(2, 60, 10)
        ));

        knapSack(items, 50);
    }

    public static void knapSack(ArrayList<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = (o1, o2) -> o2.ratio > o1.ratio ? 1 : -1;
        items.sort(comparator);
        int usedCapacity = 0;
        double totalValue = 0;
        int index = 0;
        int leftCapacity = capacity;
        while (usedCapacity < capacity) {
            KnapsackItem item = items.get(index);
            leftCapacity = capacity - usedCapacity;
            if (leftCapacity >= item.weight) {
                totalValue = totalValue + (double) item.value;
                usedCapacity = usedCapacity + item.weight;
                System.out.println(item);
            } else if ((double) (leftCapacity) >= item.ratio) {
                totalValue = totalValue + leftCapacity * item.ratio;
                usedCapacity = usedCapacity + leftCapacity;
                System.out.println("Item index=" + item.index + ", weight=" + leftCapacity + ", value=" + leftCapacity * item.ratio);
            }
            index++;
        }
    }

    public static class KnapsackItem {
        private int index;
        private int value;
        private int weight;
        private double ratio;

        public KnapsackItem(int index, int value, int weight) {
            this.index = index;
            this.value = value;
            this.weight = weight;
            ratio = value * 1.0 / weight;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }

        @Override
        public String toString() {
            return "Item index=" + index + ", value=" + value + ", weight=" + weight + ", ratio=" + ratio;
        }
    }
}
