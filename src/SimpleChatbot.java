// src/SimpleChatbot.java

import java.util.*;

public class SimpleChatbot {
    private static Map<String, String> questionAnswerMap = new HashMap<>();

    static {
        questionAnswerMap.put("What is your name?", "My name is Chatbot.");
        questionAnswerMap.put("How can I help you?", "I can assist you with your queries.");
        questionAnswerMap.put("What is the weather today?", "The weather is sunny.");
    }

    public static String getResponse(String userQuestion) {
        for (String question : questionAnswerMap.keySet()) {
            if (isSimilar(userQuestion, question)) {
                return questionAnswerMap.get(question);
            }
        }
        return "Sorry, I don't understand your question.";
    }

    // A basic similarity check by comparing words
    private static boolean isSimilar(String userQuestion, String predefinedQuestion) {
        return userQuestion.toLowerCase().contains(predefinedQuestion.toLowerCase().split(" ")[0]);
    }

    public static void main(String[] args) {
        String userInput = "What's the weather like today?";
        System.out.println(getResponse(userInput)); // Output: "The weather is sunny."
    }
}
