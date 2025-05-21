package strings;

public class PermutationOfString {

    private static void printPermutations(String s, String ans){

        if(s.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            String lpart = s.substring(0, i);
            String rpart = s.substring(i+1);
            String ansAsOfNow = lpart + rpart;
            printPermutations(ansAsOfNow, ans + ch);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        printPermutations(s, "");
    }
}
