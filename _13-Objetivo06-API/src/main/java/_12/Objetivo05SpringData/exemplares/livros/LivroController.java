package _12.Objetivo05SpringData.exemplares.livros;

import _12.Objetivo05SpringData.exemplares.livros.Livro;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class LivroController {

    private static LivroService livroService;

    public LivroController(LivroService livroService) {
        LivroController.livroService = livroService;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void inserir() {
        Livro livro = new Livro();
        System.out.println("Digite o nome: ");
        livro.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        livro.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o autor: ");
        livro.setAutor(scanner.nextLine());
        System.out.println("Digite a editora: ");
        livro.setEditora(scanner.nextLine());
        System.out.println("Digite a edição: ");
        livro.setEdicao(scanner.nextInt());
        scanner.nextLine();
        livroService.cadastrarLivro(livro);
        System.out.println("Livro salvo com sucesso");
    }

    public static void editar() {
        Livro livro = new Livro();
        System.out.println("Digite o nome: ");
        livro.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        livro.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o autor: ");
        livro.setAutor(scanner.nextLine());
        System.out.println("Digite a editora: ");
        livro.setEditora(scanner.nextLine());
        System.out.println("Digite a edição: ");
        livro.setEdicao(scanner.nextInt());

        System.out.println("Digite o codigo do livro: ");
        livro.setCodigo((long) scanner.nextInt());
        scanner.nextLine();
        String resultado = livroService.editarLivro(livro.getCodigo(), livro);
        System.out.println(resultado);
    }

    public static void excluir() {
        Livro livro = new Livro();
        System.out.println("Digite o codigo do livro para excluir: ");
        livro.setCodigo((long) scanner.nextInt());
        scanner.nextLine();
        String resultado = livroService.deletarLivro(livro.getCodigo());
        System.out.println(resultado);
    }

    public static void buscar() {
        Livro livro = new Livro();
        System.out.println("digite o nome do livro que deseja buscar: ");
        livro.setNome(scanner.nextLine());
        List<Livro> livros = livroService.getByNome(livro.getNome());

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o nome: " + livro.getNome());
        } else {
            System.out.println("Livros encontrados com o nome '" + livro.getNome() + "':");
            for (Livro livro1 : livros) {
                System.out.println("Código: " + livro1.getCodigo());
                System.out.println("Nome: " + livro1.getNome());
                System.out.println("\n");
            }
        }
    }
}
