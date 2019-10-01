import java.util.Objects;

public class Vertice {
    private String nomeVertice;

    Vertice(final String nomeVertice){
        this.nomeVertice = nomeVertice;
    }

    public String getNomeVertice() {
        return nomeVertice;
    }

    public Boolean equals(final Vertice outroVertice) {
        return Objects.equals(this.nomeVertice, outroVertice.nomeVertice);
    }
}