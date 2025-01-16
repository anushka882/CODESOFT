
    import java.util.*;

    public class QuizApplication {
        private static class Question {
            String question;
            String[] options;
            int correctOption;

            public Question(String question, String[] options, int correctOption) {
                this.question = question;
                this.options = options;
                this.correctOption = correctOption;
            }

            public boolean isCorrect(int answer) {
                return answer == correctOption;
            }
        }

        private List<Question> questions;
        private int score;

        public QuizApplication() {
            questions = new ArrayList<>();
            score = 0;
            loadQuestions();
        }

        private void loadQuestions() {
            questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
            questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2));
            questions.add(new Question("Who wrote 'Romeo and Juliet'?", new String[]{"1. Charles Dickens", "2. Mark Twain", "3. William Shakespeare", "4. Jane Austen"}, 3));
        }

        public void startQuiz() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                System.out.println("Question " + (i + 1) + ": " + question.question);
                for (String option : question.options) {
                    System.out.println(option);
                }

                System.out.print("Enter your answer (1-4): ");
                long startTime = System.currentTimeMillis();
                int answer = -1;
                boolean answeredInTime = false;

                // Timer logic
                while ((System.currentTimeMillis() - startTime) < 10000) { // 10 seconds limit
                    if (scanner.hasNextInt()) {
                        answer = scanner.nextInt();
                        answeredInTime = true;
                        break;
                    }
                }

                if (!answeredInTime) {
                    System.out.println("Time's up! Moving to the next question.");
                    continue;
                }

                if (question.isCorrect(answer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong. The correct answer was: " + question.correctOption);
                }
            }

            System.out.println("\nQuiz Over!");
            System.out.println("Your score: " + score + " out of " + questions.size());
        }

        public static void main(String[] args) {
            QuizApplication quiz = new QuizApplication();
            quiz.startQuiz();
        }
    }


