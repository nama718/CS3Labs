class Runner{
  public static void main(String[] args) {
    HuffmanTree t = new HuffmanTree("");
    t.compress("C:/Users/amanb/Documents/CS3-Labs/Lab17-HuffmanCoding/Text Files/short.txt");
    System.out.println("121\n" +
            "00\n" +
            "256\n" +
            "010\n" +
            "99\n" +
            "0110\n" +
            "120\n" +
            "0111\n" +
            "97\n" +
            "10\n" +
            "98\n" +
            "11");

  }
}