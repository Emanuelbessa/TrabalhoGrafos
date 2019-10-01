import java.util.Objects;

public class Aresta {
    Vertice vInicial;
    Vertice vFinal;
    String nomeAresta;

    Vertice getVInicial() {
        return vInicial;
    }

    Vertice getVFinal() {
        return vFinal;
    }

    String getNomeAresta() {
        return nomeAresta;
    }

    public void setVInicial(Vertice vInicial) {
        this.vInicial = vInicial;
    }

    public void setVFinal(Vertice vFinal) {
        this.vFinal = vFinal;
    }

    public void setNomeAresta(String nomeAresta) {
        this.nomeAresta = nomeAresta;
    }

    public Boolean equals(final Aresta outraAresta) {
        return Objects.equals(this.vInicial, outraAresta.vInicial) &&
                Objects.equals(this.vFinal, outraAresta.vFinal) &&
                Objects.equals(this.nomeAresta, outraAresta.nomeAresta);
    }
}
