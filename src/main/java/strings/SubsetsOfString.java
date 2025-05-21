package strings;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfString {

    private static void print(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0);
        String remaining = s.substring(1);
        print(remaining, ans);
        print(remaining, ans + ch);
    }


    private static void printAllSubsets(String s) {
        print(s, "");
    }

    private static List<String> printSubsetsIterative(String s){
        List<String> subsets = new ArrayList<>();
        subsets.add("");

        for(char ch : s.toCharArray()){
            int size = subsets.size();
            for(int i=0; i<size; i++){
                subsets.add(subsets.get(i) + ch);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        String s = "abc";  // a b c ab bc ac abc
        printAllSubsets(s);
        System.out.println(printSubsetsIterative(s));
    }
}
