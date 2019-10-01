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
        if(!this.vertice.contains(vertice)){
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

            if(a.vFinal.equals(vertice))
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
        if (aresta == null) {
            throw new GrafoException("");
        }

        if (!this.vertice.containsKey(aresta.getVInicial())) {
            throw new GrafoException("");
        }

        if (!this.vertice.containsKey(aresta.getVFinal())) {
            throw new GrafoException("");
        }
    }

    Aresta getArestaPorNome(String nomeAresta) {
        return this.getAllArestas().stream().filter(aresta -> aresta.getNomeAresta().equals(nomeAresta)).findFirst().orElse(null);
    }

    String getAllArestasString() {
        StringJoiner strJoiner = new StringJoiner(" | ");
        this.getAllArestas().forEach(aresta -> strJoiner.add(aresta.getNomeAresta()));
        return sstrJoiner.toString();
    }

    private Set<Aresta> getAllArestas() {
        return this.grafo.values().stream().flatMap(List::stream).collect(Collectors.toSet());
    }



}

