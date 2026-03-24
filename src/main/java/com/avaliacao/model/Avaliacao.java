import java.util.HashMap;
import java.util.Map;

public class Avaliacao implements Avaliavel {
    private Map<String, Double> evaluations;

    public Avaliacao() {
        this.evaluations = new HashMap<>();
    }

    public void addEvaluation(String studentName, double grade) {
        evaluations.put(studentName, grade);
    }

    public double calculateAverageGrade() {
        double total = 0;
        for (double grade : evaluations.values()) {
            total += grade;
        }
        return evaluations.isEmpty() ? 0 : total / evaluations.size();
    }
}
