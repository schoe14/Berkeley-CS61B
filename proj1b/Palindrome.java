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
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        return isPalindromeHelper(l);
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
//        palindrome.isPalindrome("racecar");
        System.out.println(palindrome.isPalindrome("racecar"));
    }

//    @Override
//    public void addFirst(T item) {
//    }
//
//    @Override
//    public void addLast(T item) {
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public void printDeque() {
//    }
//
//    @Override
//    public T removeFirst() {
//        return null;
//    }
//
//    @Override
//    public T removeLast() {
//        return null;
//    }
//
//    @Override
//    public T get(int index) {
//        return null;
//    }
}
