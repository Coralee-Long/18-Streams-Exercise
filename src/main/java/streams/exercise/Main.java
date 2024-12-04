package streams.exercise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Output only even numbers: " + StreamsExercise.filteredEvenNumbers);
        System.out.println("Double each number: " + StreamsExercise.doubleNumbers);
        System.out.println("Sort ascending order: " + StreamsExercise.ascendingOrder);
        System.out.println("Reduce to sum of nums: " + StreamsExercise.sumofNums);
        System.out.println("Print each processed number:");
        StreamsExercise.printEachProcessedNumber();
        System.out.println("Collected processed numbers: " + StreamsExercise.collectedProcessedNumbers);
    }
}