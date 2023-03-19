public class VarParameterExercise {
    public static void main(String[] args) {
        HsMethod hsMethod = new HsMethod();
        hsMethod.showScore("hs", 28, 90, 100);
    }
}

class HsMethod {

    public String showScore(String name, double... scores) {
        double totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }

        return name + " " + totalScore;
    }
}