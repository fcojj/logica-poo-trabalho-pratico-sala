import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class BibliotecaUtils {

    private BibliotecaUtils() {
        throw new IllegalStateException("Classe utilitária. Não deve ser instanciada.");
    }

    public static List<ItemAcervo> loadItensAcervo() {
        Categoria categoria1 = new Categoria("Fantasia", "Livros de fantasia");
        Categoria categoria2 = new Categoria("Ficção", "Livros de ficção");
        Categoria categoria3 = new Categoria("Terror", "Livros de terror");


        Autor autor1 = new Autor("J. R. R. Tolkien", "jrr@email.com");
        Autor autor2 = new Autor("George R. R. Martin", "george@email.com");
        Autor autor3 = new Autor("Stephen King", "sk@rmail.com");

        ItemAcervo livro1 = new LivroFisico("O Senhor dos Anéis", autor1, categoria1, LocalDate.of(1954, 7, 29), "978-0-395-19395-2");
        ItemAcervo livro2 = new LivroFisico("A Guerra dos Tronos", autor2, categoria2, LocalDate.of(1996, 8, 6), "978-0-553-57340-4");
        ItemAcervo livro3 = new LivroFisico("It: A Coisa", autor3, categoria3, LocalDate.of(1986, 9, 15), "978-0-670-81302-8");
        ItemAcervo livro4 = new Revista("Revista de Ficção", "12321312", LocalDate.of(2025, 2, 1));
        ItemAcervo livro5 = new LivroDigital("O Senhor dos Anéis", autor1, categoria1, LocalDate.of(1954, 7, 29), "978-0-395-19395-2", 50.3,"PDF");


        List<ItemAcervo> acervo = new ArrayList<>();

        acervo.add(livro1);
        acervo.add(livro2);
        acervo.add(livro3);
        acervo.add(livro4);
        acervo.add(livro5);

        return acervo;
    }
}
