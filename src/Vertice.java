import java.util.Objects;

public class Vertice {
    public String nomeVertice;

    public String getNomeVertice() {
        return nomeVertice;
    }

    public void setNomeVertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;
    }

    public Boolean equals(final Vertice outroVertice) {
        return Objects.equals(this.nomeVertice, outroVertice.nomeVertice);
    }
}