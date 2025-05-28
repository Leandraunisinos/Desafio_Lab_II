public class Labirinto {
    private static final char PAREDE = 'X';
    private static final char CAMINHO = ' ';
    private static final char DESTINO = 'D';
    private static final char CAMINHO_MARCADO = '.';

    public static void main(String[] args) {
        char[][] labirinto = {
            {' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', ' ', ' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', ' ', ' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D'}
        };

        System.out.println("Labirinto inicial:");
        imprimirLabirinto(labirinto);

        if (resolverLabirinto(labirinto, 0, 0)) {
            System.out.println("\nLabirinto com caminho encontrado (marcado com '.'):");    
            imprimirLabirinto(labirinto);
        } else {
            System.out.println("\nNenhum caminho encontrado até o destino.");
        }
    }

    private static void imprimirLabirinto(char[][] labirinto) {
        for (char[] linha : labirinto) {
            System.out.println(linha);
        }
    }

    private static boolean resolverLabirinto(char[][] labirinto, int x, int y) {
        // Verifica se está fora dos limites
        if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[0].length) {
            return false;
        }
        // Se achou destino
        if (labirinto[x][y] == DESTINO) {
            return true;
        }
        // Se não pode passar (parede ou já visitado)
        if (labirinto[x][y] != CAMINHO) {
            return false;
        }

        // Marca como parte do caminho tentado
        labirinto[x][y] = CAMINHO_MARCADO;

        // Tenta os 4 movimentos possíveis: cima, baixo, esquerda, direita
        if (resolverLabirinto(labirinto, x - 1, y) || // cima
            resolverLabirinto(labirinto, x + 1, y) || // baixo
            resolverLabirinto(labirinto, x, y - 1) || // esquerda
            resolverLabirinto(labirinto, x, y + 1)) { // direita
            return true;
        }

        // Desmarca caminho errado (backtrack)
        labirinto[x][y] = CAMINHO;
        return false;
    }
}  
