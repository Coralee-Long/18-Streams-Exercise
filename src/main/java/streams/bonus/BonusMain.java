package streams.bonus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BonusMain {
    // Define the Student record
    public record Student(int id, String name, String postalCode, int age) {}

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Path.of("students.csv"))) {
            List<Student> students = lines
                    .skip(1) // Skip the header
                    .map(BonusMain::convertLineToStudent) // Parse lines into Student records
                    .filter(BonusMain::isValidStudent) // Remove invalid students
                    .distinct() // Remove duplicates
                    .collect(Collectors.toList()); // Collect into a List

            // Print all valid students
            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parse a line into a Student record
    private static Student convertLineToStudent(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) {
            return null;
        }
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        String postalCode = parts[2].trim();
        int age = Integer.parseInt(parts[3].trim());
        return new Student(id, name, postalCode, age);
    }

    // Validate a Student record
    private static boolean isValidStudent(Student student) {
        if (student == null) {
            return false;
        }
        return student.id() > 0
                && student.name() != null && !student.name().isEmpty()
                && student.postalCode() != null && !student.postalCode().isEmpty()
                && student.age() > 0 && student.age() < 120;
    }
}
