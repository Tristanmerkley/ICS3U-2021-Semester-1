package week9;

public class HiddenWord {
    public static void main(String[] args) {
        HiddenWord puzzle = new HiddenWord("HARPS");
        System.out.println(puzzle.getHint("HELLO"));
    }

    private String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String input) {
        String hint = "";
        for (int i = 0; i < input.length(); i++) {
            String temp = input.substring(i, i + 1);
            if (temp.equals(word.substring(i, i + 1))) {
                hint += temp;
            } else if (word.indexOf(temp) >= 0) {
                hint += "+";
            } else {
                hint += "*";
            }
        }

        return hint;
    }
}
