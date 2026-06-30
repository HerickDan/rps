class Palindrom {
    public boolean isPalindrome(int x) {
        String numToStr = Integer.toString(x);
        String reversed = new StringBuilder(numToStr).reverse().toString();
        return reversed.compareTo(numToStr) == 0;
    }
}