package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.SimpleChatbot;
import java.util.HashMap;
import java.util.Map;

public class SimpleChatbotTest {

    @Test
    public void testExactMatch() {
        Map<String, String> questionAnswerPairs = new HashMap<>();
        questionAnswerPairs.put("What is your name?", "My name is Chatbot.");
        questionAnswerPairs.put("How can I help you?", "I can assist you with your queries.");
        questionAnswerPairs.put("What is the weather today?", "The weather is sunny.");

        String userInput = "What is your name?";
        String expectedAnswer = "My name is Chatbot.";

        assertEquals(expectedAnswer, SimpleChatbot.getAnswer(userInput, questionAnswerPairs));
    }

    @Test
    public void testClosestMatch() {
        Map<String, String> questionAnswerPairs = new HashMap<>();
        questionAnswerPairs.put("What is your name?", "My name is Chatbot.");
        questionAnswerPairs.put("How can I help you?", "I can assist you with your queries.");
        questionAnswerPairs.put("What is the weather today?", "The weather is sunny.");

        String userInput = "What's the weather like today?";
        String expectedAnswer = "The weather is sunny.";  // Closest match to "What is the weather today?"

        assertEquals(expectedAnswer, SimpleChatbot.getAnswer(userInput, questionAnswerPairs));
    }

    @Test
    public void testNoMatch() {
        Map<String, String> questionAnswerPairs = new HashMap<>();
        questionAnswerPairs.put("What is your name?", "My name is Chatbot.");
        questionAnswerPairs.put("How can I help you?", "I can assist you with your queries.");

        String userInput = "How old are you?";
        String expectedAnswer = "I'm sorry, I don't understand the question.";

        assertEquals(expectedAnswer, SimpleChatbot.getAnswer(userInput, questionAnswerPairs));
    }
}
