import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo graph = new Grafo(false);

        while (true) {
            System.out.println("Escolha uma opção: \n" +
                    "1 - Add Vértice\n" +
                    "2 - Remover Vértice\n" +
                    "3 - Add Aresta\n" +
                    "4 - Remover Aresta\n" +
                    "5 - Matriz\n" +
                    "6 - Exibir vértices adjacentes");
            switch (scanner.nextInt()){
                case 1:
                    System.out.print("Digite o nome do vértice a ser adicionado: ");
                    graph.addVertice(new Vertice(scanner.next()));
                    break;
                case 2:
                    System.out.print("Digite o nome do vértice a ser excluído: ");
                    graph.removeVertice(graph.getVerticePorNome(scanner.next()));
                    break;
            }
        }
    }
}
