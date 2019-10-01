import java.util.Objects;

public class Vertice {
    public String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean equals(final Vertice outroVertice) {
        return Objects.equals(this.nome, outroVertice.nome);
    }
}
