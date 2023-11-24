package _12.Objetivo05SpringData.exemplares.artigos;

import _12.Objetivo05SpringData.exemplares.livros.Livro;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ArtigoController {

    private static ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        ArtigoController.artigoService = artigoService;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void inserir() {
        Artigo artigo = new Artigo();
        System.out.println("Digite o nome: ");
        artigo.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        artigo.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o autor: ");
        artigo.setAutor(scanner.nextLine());

        artigoService.cadastrarArtigo(artigo);
        System.out.println("Artigo salvo com sucesso");
    }

    public static void editar() {
        Artigo artigo = new Artigo();
        System.out.println("Digite o nome: ");
        artigo.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        artigo.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o autor: ");
        artigo.setAutor(scanner.nextLine());

        System.out.println("Digite o codigo do artigo: ");
        artigo.setCodigo((long) scanner.nextInt());
        scanner.nextLine();
        String resultado = artigoService.editarArtigo(artigo.getCodigo(), artigo);
        System.out.println(resultado);
    }

    public static void deletar() {
        Artigo artigo = new Artigo();
        System.out.println("Digite o codigo do artigo: ");
        artigo.setCodigo((long) scanner.nextInt());
        scanner.nextLine();
        String resultado = artigoService.deletarArtigo(artigo.getCodigo());
        System.out.println(resultado);
    }

    public static void buscar() {
        Artigo artigo = new Artigo();
        System.out.println("digite o nome do artigo que deseja buscar: ");
        artigo.setNome(scanner.nextLine());
        List<Artigo> artigos = artigoService.getByNome(artigo.getNome());

        if (artigos.isEmpty()) {
            System.out.println("Nenhum artigo encontrado com o nome: " + artigo.getNome());
        } else {
            System.out.println("Artigo encontrados com o nome '" + artigo.getNome() + "':");
            for (Artigo artigo1 : artigos) {
                System.out.println("Código: " + artigo1.getCodigo());
                System.out.println("Nome: " + artigo1.getNome());
                System.out.println("\n");
            }
        }
    }
}
