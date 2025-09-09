package practica1.ejercicio9;
import java.util.Stack;
public class TestBalanceo {
	public static boolean estaBalanceado(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c:s.toCharArray()) {
			switch(c) {
			case '(': case '[': case '{':
                stack.push(c);
                break;
            case ')':
                if (stack.isEmpty() || stack.pop() != '(') return false;
                break;
            case ']':
                if (stack.isEmpty() || stack.pop() != '[') return false;
                break;
            case '}':
                if (stack.isEmpty() || stack.pop() != '{') return false;
                break;
            default:
                // Ignorar cualquier otro carácter si lo hubiera
                break;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
        // Ejemplos de prueba
        String s1 = "{()[()]}";
        String s2 = "([)]";
        String s3 = "";
        String s4 = "({[()]})";

        System.out.println("s1 está balanceado? " + estaBalanceado(s1)); // true
        System.out.println("s2 está balanceado? " + estaBalanceado(s2)); // false
        System.out.println("s3 está balanceado? " + estaBalanceado(s3)); // true
        System.out.println("s4 está balanceado? " + estaBalanceado(s4)); // true
    }
}
