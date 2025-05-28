import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ValidadorEtapa4 {
    public static void main(String[] args) {
        // Pilha (Stack)
        Stack<Integer> pilha = new Stack<>();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        System.out.println("Pilha após push: " + pilha);
        int topo = pilha.pop();
        System.out.println("Pilha após pop: " + pilha + ", topo removido: " + topo);

        // Fila (Queue)
        Queue<Integer> fila = new LinkedList<>();
        fila.add(1);
        fila.add(2);
        fila.add(3);
        System.out.println("Fila após enqueue: " + fila);
        int primeiro = fila.poll();
        System.out.println("Fila após dequeue: " + fila + ", primeiro removido: " + primeiro);
    }
}
