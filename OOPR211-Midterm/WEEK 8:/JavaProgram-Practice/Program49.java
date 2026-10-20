// Program to capitalize first letter of each word in string
public class Program49 {
    public static void main(String[] args) {
        String str = "welcome to candid java program";
        StringBuilder result = new StringBuilder(str.length());
        String words[] = str.split("\\ ");
        for (int i = 0; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");
        }

        System.out.println(result);
    }
}
