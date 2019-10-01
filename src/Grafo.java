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

    public void addVertice() {

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

