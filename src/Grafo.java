import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertice;
    private ArrayList<Aresta> aresta;
    private Boolean dirigido;

    Grafo(final Boolean dirigido) {
        this.vertice = new ArrayList<>();
        this.aresta = new ArrayList<>();
        this.dirigido = dirigido;
    }

    public void addVertice(final Vertice vertice) {
        this.vertice.add(vertice);
    }

    public void removeVertice(final Vertice vertice) {
        if (!this.vertice.contains(vertice)) {
            System.err.println("Vértice não existe!");
        }

        this.getVerticesAdjacentes(vertice).forEach(verticeAdjacente -> {

        });
        this.vertice.remove(vertice);
    }

    public ArrayList<Vertice> getVerticesAdjacentes(Vertice vertice) {
        ArrayList<Vertice> verticesAdjacentes = new ArrayList<>();
        for (Aresta a : this.aresta) {
            if (a.vInicial.equals(vertice))
                verticesAdjacentes.add(a.vFinal);

            if (a.vFinal.equals(vertice))
                verticesAdjacentes.add(a.vInicial);
        }
        return verticesAdjacentes;
    }

    public void addAresta(Aresta aresta) {
        this.validarAresta(aresta);
        this.aresta.add(aresta);

    }

    public void removeAresta(Aresta aresta) {
        this.validarAresta(aresta);
        this.aresta.remove(aresta);
    }

    private void validarAresta(Aresta aresta) {
        try {
            if (!this.vertice.contains(aresta.getVInicial())) {
                throw new Exception("Vértice inicial não existe no grafo!");
            }

            if (!this.vertice.contains(aresta.getVFinal())) {
                throw new Exception("Vértice final não existe no grafo!");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

