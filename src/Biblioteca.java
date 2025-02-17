
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Biblioteca {

    private static final String MENU_OPCOES = """
            %nBem-vindo à biblioteca!
            1 - Adicionar item ao acervo
            2 - Remover item do acervo
            3 - Listar acervo
            4 - Buscar item por título
            5 - Emprestar um item do acervo
            6 - Devolver um item do acervo
            7 - Sair
            Digite a opção desejada:
            """;
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<ItemAcervo> acervo = new ArrayList<>();

    private void loadAcervo() {
        acervo.addAll(BibliotecaUtils.loadItensAcervo());
    }

    public Biblioteca() {
        loadAcervo();
    }

    public void iniciarMenu(){
        var opcao = "";
        do {
            try {
                System.out.printf(MENU_OPCOES);
                opcao = scanner.nextLine();

                switch (opcao) {
                    case "1" -> adicionarItemAcervo();
                    case "2" -> removerItemAcervo();
                    case "3" -> listarAcervo();
                    case "4" -> buscarItemAcervo();
                    case "5" -> emprestarItemAcervo();
                    case "6" -> devolverItemAcervo();
                    case "7" -> System.out.println("Até mais!");
                    default -> System.err.println("Opção inválida!");
                }

                Thread.sleep(100);

            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        } while (!"7".equals(opcao));

        scanner.close();
    }

    public void devolverItemAcervo() {
        System.out.println("Digite o título do item que deseja devolver:");
        String titulo = scanner.nextLine();

        for (ItemAcervo item : acervo) {
            var itemDevolver = item.buscar(titulo);
            if (itemDevolver != null) {

                if (itemDevolver instanceof Emprestavel itemAcervo) {
                    itemAcervo.devolver();
                } else {
                    System.err.println("Item não é devolvivel");
                }

                break;
            }
        }
    }

    public void emprestarItemAcervo() {
        System.out.print("Digite o título do item que deseja emprestar: ");
        String titulo = scanner.nextLine().trim().toLowerCase();

        Optional<ItemAcervo> itemEncontrado = acervo.stream()
                .map(item -> item.buscar(titulo))
                .filter(Objects::nonNull)
                .findFirst();

        if (itemEncontrado.isPresent()) {
            ItemAcervo item = itemEncontrado.get();

            if (item instanceof Emprestavel emprestavel) {
                emprestavel.emprestar();
                System.out.println("Item emprestado com sucesso!");
            } else {
                System.err.println("Este item não pode ser emprestado.");
            }
        } else {
            System.err.println("Item não encontrado no acervo.");
        }
    }

    public void buscarItemAcervo() {
        System.out.println("Digite o título do item que deseja buscar:");
        String titulo = scanner.nextLine();
        for (ItemAcervo item : acervo) {
            var itemEncontrado = item.buscar(titulo);
            if (itemEncontrado != null) {
                itemEncontrado.exibirDetalhes();
                break;
            }
        }
    }

    public void listarAcervo() {
        System.out.println("Listar acervo");
        for (ItemAcervo item : acervo) {
            item.exibirDetalhes();
        }
    }

    public void removerItemAcervo() {
        System.out.println("Remover item do acervo");
        System.out.println("Digite o título do item para remover:");
        String titulo = scanner.nextLine();
        for (ItemAcervo item : acervo) {
            var itemRemover = item.buscar(titulo);
            if (itemRemover != null) {
                acervo.remove(itemRemover);
                break;
            }
        }
    }

    public void adicionarItemAcervo() {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o nome do autor:");
        String nomeAutor = scanner.nextLine();
        System.out.println("Digite o email do autor:");
        String emailAutor = scanner.nextLine();
        System.out.println("Digite data de publicação(dd/MM/yyyy):");
        LocalDate dataPublicacao = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Digite a categoria:");
        String nomeCategoria = scanner.nextLine();
        System.out.println("Digite a descrição da categoria:");
        String descricaoCategoria = scanner.nextLine();
        System.out.println("Digite o ISBN:");
        String isbn = scanner.nextLine();

        Autor autor = new Autor(nomeAutor, emailAutor);
        Categoria categoria = new Categoria(nomeCategoria, descricaoCategoria);
        ItemAcervo livro = new LivroFisico(titulo, autor, categoria, dataPublicacao, isbn);
        acervo.add(livro);
    }
}
