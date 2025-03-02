public class Main {
    public static void main(String[] args) {
        String[] message = { "hi", "how", "are", "you" };
        String separator = "";  // first, no space
        for (String word : message) {
            System.out.print(separator);
            System.out.print(word);
            separator = " ";    // after first iteration, a space between the words
    }
        }
        
    }
