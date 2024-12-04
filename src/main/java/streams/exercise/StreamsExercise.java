package streams.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExercise {

    static List<Integer> listOfNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));

    // Step 1: Filter a list of numbers and only output the even numbers.
    static List<Integer> filteredEvenNumbers = listOfNumbers.stream()
            .filter(nums -> nums % 2 == 0)
            .collect(Collectors.toList());

    // Step 2: Use 'map' and double each number in the list.
    static List<Integer> doubleNumbers = listOfNumbers.stream()
            .map(num -> num * 2)
            .collect(Collectors.toList());

    // Step 3: Sort the list in ascending order.
    static List<Integer> ascendingOrder = listOfNumbers.stream()
            .sorted()
            .collect(Collectors.toList());

    // Step 4: Perform a 'reduce' operation to calculate the sum of all numbers in the list.
    static int sumofNums = listOfNumbers.stream()
        // Original Lambda ===> .reduce(0,(subtotal, num) -> subtotal + num);
        .reduce(0, Integer::sum);

    // Step 5: Use 'forEach' and output each processed number.
    static void printEachProcessedNumber() {
        listOfNumbers.stream()
                .filter(nums -> nums % 2 == 0)
                .map(num -> num * 2)
                .sorted()
                .forEach(System.out::println);
    }

    // Step 6: Collect the processed numbers into a new list using 'collect'.
    static List<Integer> collectedProcessedNumbers = listOfNumbers.stream()
            .filter(nums -> nums % 2 == 0)
            .map(num -> num * 2)
            .sorted()
            .collect(Collectors.toList());









}
