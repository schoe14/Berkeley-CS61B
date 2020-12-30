public class Palindrome {
    public Palindrome() {
        super();
    }

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> l = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            l.addLast(word.charAt(i));
        }
        return l;
    }

    private boolean isPalindromeHelper(Deque<Character> l) {
        if (l.size() == 0 || l.size() == 1) {
            return true;
        }
        Character a = l.removeFirst();
        Character b = l.removeLast();
        if (a == b && a != null && b != null) {
            return isPalindromeHelper(l);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> l = wordToDeque(word);
        return isPalindromeHelper(l);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> l = wordToDeque(word);
        while (l.size() > 1) {
            Character a = l.removeFirst();
            Character b = l.removeLast();
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }
}
