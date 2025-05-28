import java.util.Stack;
public class ValidadorEtapa3 {
    public static void main(String[] args) {
        // Exemplo de uso
        String expressao = "a + b * (c - d)";
        boolean resultado = validarExpressao(expressao);
        System.out.println("A expressão é válida? " + resultado);
    }

    public static boolean validarExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();
        for (char c : expressao.toCharArray()) {
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isEmpty() || pilha.pop() != '(') {
                    return false; // Parênteses desbalanceados
                }
            }
        }
        return pilha.isEmpty(); // Verifica se todos os parênteses foram fechados
    }
}
