// Count no. of words in a sentence

public class Ques6 {
    public static void main(String[] args) {
        int words = 1;
	      Scanner xyz = new Scanner(System.in);
	      String s = xyz.nextLine();
        xyz.close();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ')
                words++;
        }
        System.out.println("No. of words in the line are : " + words);
    }
}
