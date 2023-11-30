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
                            5. Buscar Todos os Livros
                            Artigo:
                            6. Inserir um artigo
                            7. Editar um artigo
                            8. Deletar um artigo
                            9. Buscar um artigo pelo nome
                            10. Buscar Todos os Artigos
                            Periodico:
                            11. Inserir um periodico
                            12. Editar um periodico
                            13. Deletar um periodico
                            14. Buscar um periodico pelo nome
                            15. Buscar Todos os periodicos
                             Opção (Zero p/sair):\s""");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> LivroController.inserir();
                case 2 -> LivroController.editar();
                case 3 -> LivroController.excluir();
                case 4 -> LivroController.buscar();
                case 5 -> LivroController.buscarTodos();
                case 6 -> ArtigoController.inserir();
                case 7 -> ArtigoController.editar();
                case 8 -> ArtigoController.deletar();
                case 9 -> ArtigoController.buscar();
                case 10 -> ArtigoController.buscarTodos();
                case 11 -> PeriodicoController.inserir();
                case 12 -> PeriodicoController.editar();
                case 13 -> PeriodicoController.deletar();
                case 14 -> PeriodicoController.buscar();
                case 15 -> PeriodicoController.buscarTodos();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
}
