import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        for(int i = 0; i < count;i++){
            char[] expression = scn.next().toCharArray();
            generateRPN(expression);
        }
    }

    static void generateRPN(char[] expression){
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> spec = new ArrayList<Character>();
        spec.add('*');
        spec.add('+');
        spec.add('/');
        spec.add('-');
        spec.add('^');
        for(int i = 0; i <expression.length;i++){
            if(')' == expression[i]){
                sb.append(stack.pop());
            }else if(spec.contains(expression[i])){
                stack.push(String.valueOf(expression[i]));
            }else if ('(' != expression[i]){
                sb.append(expression[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
