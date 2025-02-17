import java.time.LocalDate;

public final class LivroDigital extends Livro {

    private final double tamanhoArquivoMB;
    private final String formato;

    public LivroDigital(String titulo,
                        Autor autor,
                        Categoria categoria,
                        LocalDate dataPublicacao,
                        String isbn,
                        double tamanhoArquivoMB,
                        String formato) {
        super(titulo, autor, categoria, dataPublicacao, isbn);
        this.tamanhoArquivoMB = tamanhoArquivoMB;
        this.formato = formato;
    }

    public double getTamanhoArquivoMB() {
        return tamanhoArquivoMB;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();

        var detalhesTemplate = STR."""
                               Tam. arquivo: \{tamanhoArquivoMB}MB | Formato: \{formato} | D
                               """;

        System.out.print(detalhesTemplate);
    }
}
