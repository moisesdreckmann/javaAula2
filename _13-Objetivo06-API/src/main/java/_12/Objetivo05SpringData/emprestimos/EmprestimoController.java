package _12.Objetivo05SpringData.emprestimos;

import _12.Objetivo05SpringData.alunos.Aluno;
import _12.Objetivo05SpringData.alunos.AlunoService;
import _12.Objetivo05SpringData.exemplares.Exemplar;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Controller
public class EmprestimoController {

    private static EmprestimoService emprestimoService;

    private static AlunoService alunoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        EmprestimoController.emprestimoService = emprestimoService;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] args) {
            int opcao;
            do {
                System.out.print(
                        """
                                \n-------  MENU Aluno ------- \n
                                 1. Realizar Emprestimo
                                 2. Buscar por Emprestimos por Aluno
                                 Opção (Zero p/sair):\s""");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1 -> realizarEmprestimo();
                    case 2 -> buscarEmprestimo();
                    default -> {
                        if (opcao != 0) System.out.println("Opção inválida.");
                    }
                }
            } while (opcao != 0);
        }

    private static void realizarEmprestimo() {
        Emprestimo emprestimo = new Emprestimo();
        System.out.println("Digite a data inicial do empréstimo (no formato dd/MM/yyyy):");
        String dataEmprestimo = scanner.nextLine();
        LocalDate dataEmprestimoFormatada = LocalDate.parse(dataEmprestimo, formatter);
        emprestimo.setDataEmprestimo(dataEmprestimoFormatada);

        LocalDate dataDevolucao = dataEmprestimoFormatada.plusDays(7);
        emprestimo.setDataDevolucao(dataDevolucao);

        System.out.println("Digite o código do aluno:");
        Long codigoAluno = scanner.nextLong();
        scanner.nextLine();
        Aluno alunoEmprestimo = emprestimoService.buscarAluno(codigoAluno);
        emprestimo.setAluno(alunoEmprestimo);


        System.out.println("Digite o código do exemplar:");
        Long codigoExemplar = scanner.nextLong();
        scanner.nextLine();
        Exemplar exemplarEmprestimo = emprestimoService.buscarExemplar(codigoExemplar);
        emprestimo.setExemplar(exemplarEmprestimo);

        emprestimoService.realizarEmprestimo(emprestimo);
        System.out.println("Empréstimo realizado com sucesso.");
    }

    private static void buscarEmprestimo() {
        System.out.println("Digite o código do aluno:");
        Long codigoAluno = scanner.nextLong();
        scanner.nextLine();

        List<Emprestimo> emprestimos = emprestimoService.buscarEmprestimos(codigoAluno);

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado para o aluno com o código: " + codigoAluno);
        } else {
            System.out.println("Empréstimos encontrados para o aluno com o código '" + codigoAluno + "':");
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Nome do exemplar" + emprestimo.getExemplar().getNome());
                System.out.println("Data do emprestimo" + emprestimo.getDataEmprestimo());
                System.out.println("Data da devolução" + emprestimo.getDataDevolucao() + "\n");
            }
        }
    }


}

