package _12.Objetivo05SpringData.exemplares.periodicos;

import _12.Objetivo05SpringData.exemplares.artigos.Artigo;
import _12.Objetivo05SpringData.exemplares.periodicos.Periodico;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class PeriodicoController {
    private static PeriodicoService periodicoService;

    public PeriodicoController(PeriodicoService periodicoService) {
        PeriodicoController.periodicoService = periodicoService;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static void inserir() {
        Periodico periodico = new Periodico();
        System.out.println("Digite o nome: ");
        periodico.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        periodico.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o nome da editora: ");
        periodico.setEditora(scanner.nextLine());

        periodicoService.cadastrarPeriodico(periodico);
        System.out.println("Periodico salvo com sucesso");
    }

    public static void editar() {
        Periodico periodico = new Periodico();
        System.out.println("Digite o nome: ");
        periodico.setNome(scanner.nextLine());
        System.out.println("Digite o tipo do exemplar (1.livro 2.artigo 3.periodico):");
        periodico.setTipoExemplar(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o nome da editora: ");
        periodico.setEditora(scanner.nextLine());

        System.out.println("Digite o codigo do periodico: ");
        periodico.setCodigo((long) scanner.nextInt());
        scanner.nextLine();

        String resultado = periodicoService.editarPeriodico(periodico.getCodigo(), periodico);
        System.out.println(resultado);

    }

    public static void deletar() {
        Periodico periodico = new Periodico();

        System.out.println("Digite o codigo do periodico: ");
        periodico.setCodigo((long) scanner.nextInt());
        scanner.nextLine();

        String resultado = periodicoService.deletarPeriodico(periodico.getCodigo());
        System.out.println(resultado);
    }

    public static void buscar() {
        Periodico periodico = new Periodico();

        System.out.println("digite o nome do periodico que deseja buscar: ");
        periodico.setNome(scanner.nextLine());
        List<Periodico> periodicos = periodicoService.getByNome(periodico.getNome());

        if (periodicos.isEmpty()) {
            System.out.println("Nenhum periodico encontrado com o nome: " + periodico.getNome());
        } else {
            System.out.println("Periodico encontrados com o nome '" + periodico.getNome() + "':");
            for (Periodico periodico1 : periodicos) {
                System.out.println("Código: " + periodico1.getCodigo());
                System.out.println("Nome: " + periodico1.getNome());
                System.out.println("\n");
            }
        }
    }

    public static void buscarTodos() {
        List<Periodico> resultado = periodicoService.buscarTodos();
        System.out.println(resultado);
    }
}
