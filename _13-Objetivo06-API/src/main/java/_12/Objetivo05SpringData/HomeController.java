package _12.Objetivo05SpringData;

import _12.Objetivo05SpringData.alunos.AlunoController;
import _12.Objetivo05SpringData.alunos.AlunoService;
import _12.Objetivo05SpringData.emprestimos.Emprestimo;
import _12.Objetivo05SpringData.emprestimos.EmprestimoController;
import _12.Objetivo05SpringData.exemplares.ExemplarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class HomeController {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n-------  Home -------\n");
            System.out.print(
                    """
                        1. Menu de Alunos
                        2. Menu da Biblioteca
                        3. Menu de Emprestimos
                        Opção (Zero p/sair):\s""");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (opcao) {
                case 1 -> {
                    AlunoController.main(null);
                }
                case 2 -> {
                    ExemplarController.main(null);
                }
                case 3 -> {
                    EmprestimoController.main(null);
                }
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!\n");
        scanner.close();
    }
}
