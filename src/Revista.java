import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Revista implements Emprestavel, ItemAcervo {
    private String titulo;
    private String issn;
    private LocalDate dataPublicacao;
    private boolean emprestado;

    public Revista(String titulo, String issn, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.issn = issn;
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public void emprestar() {
        if (!emprestado) {
            System.out.println("Revista emprestada.");
            emprestado = true;
        } else {
            System.err.println("Revista já emprestada.");
        }
    }

    @Override
    public void devolver() {
        if (emprestado) {
            emprestado = false;
        } else {
            System.err.println("Revista já devolvida.");
        }
    }

    @Override
    public void exibirDetalhes() {
        var dataFormatada = dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var emprestadoStr = emprestado ? "Sim" : "Não";

        var detalhesTemplate = STR."""
        Título: \{titulo} | ISSN: \{issn} | Data de publicação: \{dataFormatada} | Emprestado: \{emprestadoStr} | R
        """;

        System.out.print(detalhesTemplate);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public String getIssn() {
        return issn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }
}
