package _12.Objetivo05SpringData.exemplares;

import _12.Objetivo05SpringData.exemplares.artigos.ArtigoController;
import _12.Objetivo05SpringData.exemplares.livros.LivroController;
import _12.Objetivo05SpringData.exemplares.periodicos.PeriodicoController;

import java.util.Scanner;

public class ExemplarController {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print(
                    """
                            \n-------  MENU Biblioteca ------- \n
                            Livro:
                            1. Inserir um livro
                            2. Editar um livro
                            3. Deletar um livro
                            4. Buscar um livro pelo nome
                            Artigo:
                            5. Inserir um artigo
                            6. Editar um artigo
                            7. Deletar um artigo
                            8. Buscar um artigo pelo nome
                            Periodico:
                            9. Inserir um periodico
                            10. Editar um periodico
                            11. Deletar um periodico
                            12. Buscar um periodico pelo nome
                             Opção (Zero p/sair):\s""");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> LivroController.inserir();
                case 2 -> LivroController.editar();
                case 3 -> LivroController.excluir();
                case 4 -> LivroController.buscar();
                case 5 -> ArtigoController.inserir();
                case 6 -> ArtigoController.editar();
                case 7 -> ArtigoController.deletar();
                case 8 -> ArtigoController.buscar();
                case 9 -> PeriodicoController.inserir();
                case 10 -> PeriodicoController.editar();
                case 11 -> PeriodicoController.deletar();
                case 12 -> PeriodicoController.buscar();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
}
