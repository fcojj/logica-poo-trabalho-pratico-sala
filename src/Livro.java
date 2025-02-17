import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract sealed class Livro implements ItemAcervo permits LivroFisico,LivroDigital {

    private final String titulo;
    private final Autor autor;
    private final Categoria categoria;
    private final LocalDate dataPublicacao;
    private final String isbn;

    public Livro(String titulo, Autor autor, Categoria categoria, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void exibirDetalhes() {
        var detalhesTemplate = STR."""
                                Titulo: \{titulo} | Autor: \{autor.nome()} | Categoria: \{categoria.nome()} | Data de Publicacao: \{dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))} | ISBN: \{isbn}
                                """;

        System.out.print(detalhesTemplate);
    }

}