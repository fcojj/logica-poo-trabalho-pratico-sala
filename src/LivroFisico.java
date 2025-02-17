import java.time.LocalDate;

public final class LivroFisico extends Livro implements Emprestavel {
    private static final int DEFAULT_QUANTIDADE_EXEMPLARES = 1;
    private int quantidadeExemplares;
    private int quantidadeExemplaresEmprestados;

    public LivroFisico(String titulo,
                       Autor autor,
                       Categoria categoria,
                       LocalDate dataPublicacao,
                       String isbn,
                       int quantidadeExemplares) {

        super(titulo, autor, categoria, dataPublicacao, isbn);
        this.quantidadeExemplares = quantidadeExemplares;
        this.quantidadeExemplaresEmprestados = 0;
    }

    public LivroFisico(String titulo,
                       Autor autor,
                       Categoria categoria,
                       LocalDate dataPublicacao,
                       String isbn) {

        super(titulo, autor, categoria, dataPublicacao, isbn);
        this.quantidadeExemplares = DEFAULT_QUANTIDADE_EXEMPLARES;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();

        var detalhesTemplate = STR.""" 
                                Exempl: \{quantidadeExemplares} | Emp: \{quantidadeExemplaresEmprestados} | F
                                """;

        System.out.print(detalhesTemplate);
    }

    @Override
    public void emprestar() {
        if (quantidadeExemplaresEmprestados < quantidadeExemplares) {
            System.out.println("Livro emprestado.");
            quantidadeExemplaresEmprestados++;
        } else {
            System.err.println("Não há exemplares disponíveis para empréstimo.");
        }
    }

    @Override
    public void devolver() {
        if (quantidadeExemplaresEmprestados != 0) {
            quantidadeExemplaresEmprestados--;
            System.out.println("Livro devolvido.");
        } else {
            System.err.println("Todos os exemplares já foram devolvidos.");
        }
    }
}
