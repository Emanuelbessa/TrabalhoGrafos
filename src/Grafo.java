import java.util.ArrayList;
import java.util.StringJoiner;

public class Grafo {
    private ArrayList<Vertice> vertice;
    private ArrayList<Aresta> aresta;
    private Boolean dirigido;

    Grafo(final Boolean dirigido) {
        this.vertice = new ArrayList<>();
        this.aresta = new ArrayList<>();
        this.dirigido = dirigido;
    }

    void addVertice(final Vertice vertice) {
        this.vertice.add(vertice);
    }

    void removeVertice(final Vertice vertice) {
        if (!this.vertice.contains(vertice)) {
            System.err.println("Vértice não existe!");
        }

        this.getVerticesAdjacentes(vertice).forEach(verticeAdjacente -> {
            for (Aresta a : this.aresta) {
                if (a.vInicial.equals(verticeAdjacente))
                    this.aresta.remove(a);

                if (a.vFinal.equals(verticeAdjacente))
                    this.aresta.remove(a);
            }
        });
        this.vertice.remove(vertice);
    }

    Vertice getVerticePorNome(String nomeVertice) {
        Vertice vNome = null;
        for (Vertice v : this.vertice) {
            if (v.getNomeVertice().equalsIgnoreCase(nomeVertice))
                vNome = v;
        }
        return vNome;
    }

    ArrayList<Vertice> getVerticesAdjacentes(Vertice vertice) {
        ArrayList<Vertice> verticesAdjacentes = new ArrayList<>();
        for (Aresta a : this.aresta) {
            if (a.vInicial.equals(vertice))
                verticesAdjacentes.add(a.vFinal);

            if (a.vFinal.equals(vertice))
                verticesAdjacentes.add(a.vInicial);
        }
        return verticesAdjacentes;
    }

    void addAresta(Aresta aresta) {
        this.validarAresta(aresta);
        this.aresta.add(aresta);
    }

    void removeAresta(Aresta aresta) {
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

    Aresta getArestaPorNome(String nomeAresta) {
        Aresta aNome = null;
        for (Aresta a : this.aresta) {
            if (a.getNomeAresta().equalsIgnoreCase(nomeAresta))
                aNome = a;
        }
        return aNome;
    }

    ArrayList<Aresta> getArestasVertice(Vertice vertice) {
        ArrayList<Aresta> arestas = new ArrayList<>();
        for (Aresta a : this.aresta) {
            if (a.vInicial.equals(vertice))
                arestas.add(a);

            if (a.vFinal.equals(vertice))
                arestas.add(a);
        }
        return arestas;
    }

    void showMatrizAdjacente() {
        StringJoiner matriz = new StringJoiner(System.lineSeparator());
        StringBuilder string = new StringBuilder("  ");
        this.vertice.forEach(v -> string.append(v.getNomeVertice()).append(" "));
        matriz.add(string);

        for (Vertice vLinha: this.vertice) {
            StringBuilder linha = new StringBuilder(vLinha.getNomeVertice() + " ");
            ArrayList<Aresta> arestasVertice = getArestasVertice(vLinha);

            for (Vertice vColuna: this.vertice) {
                arestasVertice.forEach(a -> {
                    if(Boolean.TRUE.equals(a.vInicial.equals(vLinha) && a.vFinal.equals(vColuna) ||
                            a.vFinal.equals(vLinha) && a.vInicial.equals(vColuna))) {
                        linha.append("1 ");
                    }
                    else {
                        linha.append("0 ");
                    }
                });
            }
            matriz.add(linha);
        }
        System.out.println(matriz);
    }
}

