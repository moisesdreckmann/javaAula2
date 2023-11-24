package _12.Objetivo05SpringData.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Controller
public class AlunoController {

    private static AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        AlunoController.alunoService = alunoService;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print(
                    """
                            \n-------  MENU Aluno ------- \n
                             1. Inserir novo aluno
                             2. Atualizar um aluno
                             3. Excluir um aluno
                             4. Procurar um aluno por Id
                             5. Procurar um aluno pelo nome
                             Opção (Zero p/sair):\s""");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> procurarPorId();
                case 5 -> procurarPorNome();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Aluno aluno = new Aluno();
        System.out.println("Digite os dados de aluno \n");
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        aluno.setDataNascimento(LocalDate.parse(dataNascimentoStr, formatter));
        System.out.println("Digite o telefone: ");
        aluno.setTelefone(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o email: ");
        aluno.setEmail(scanner.nextLine());
        System.out.println("\nDigite os dados de endereço do aluno \n");
        Endereco endereco = new Endereco();
        System.out.println("Digite a rua: ");
        endereco.setRua(scanner.nextLine());
        System.out.println("Digite o numero: ");
        endereco.setNumero(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o cep: ");
        endereco.setCep(scanner.nextLine());
        aluno.setEndereco(endereco);

        alunoService.cadastrarAluno(aluno);
        System.out.println("Aluno salvo com sucesso");
    }

    private static void atualizar() {
        Aluno aluno = new Aluno();
        System.out.println("Digite os dados de aluno \n");
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        aluno.setDataNascimento(LocalDate.parse(dataNascimentoStr, formatter));
        System.out.println("Digite o telefone: ");
        aluno.setTelefone(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o email: ");
        aluno.setEmail(scanner.nextLine());
        System.out.println("\nDigite os dados de endereço do aluno \n");
        Endereco endereco = new Endereco();
        System.out.println("Digite a rua: ");
        endereco.setRua(scanner.nextLine());
        System.out.println("Digite o numero: ");
        endereco.setNumero(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o cep: ");
        endereco.setCep(scanner.nextLine());
        aluno.setEndereco(endereco);

        System.out.println("Digite o seu codigo/id/matricula: ");
        aluno.setCodigo((long) scanner.nextInt());

        String resultado = alunoService.editarAlunoPorId(aluno.getCodigo(), aluno);
        System.out.println(resultado);
    }

    private static void excluir() {
        Aluno aluno = new Aluno();
        System.out.println("Digite o seu codigo/id/matricula para excluir: ");
        aluno.setCodigo((long) scanner.nextInt());

        String resultado = alunoService.deletarAlunoPorId(aluno.getCodigo());
        System.out.println(resultado);
    }

    private static void procurarPorId() {
        Aluno aluno = new Aluno();
        System.out.println("Digite o seu codigo/id/matricula: ");
        aluno.setCodigo((long) scanner.nextInt());

        String resultado = alunoService.getAlunoById(aluno.getCodigo());
        System.out.println(resultado);
    }

    private static void procurarPorNome() {
        Aluno aluno = new Aluno();
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(scanner.nextLine());

        List<Aluno> alunos = alunoService.getAlunoByNome(aluno.getNome());

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado com o nome: " + aluno.getNome());
        } else {
            System.out.println("Alunos encontrados com o nome '" + aluno.getNome() + "':");
            for (Aluno aluno1 : alunos) {
                System.out.println("Código: " + aluno1.getCodigo());
                System.out.println("Nome: " + aluno1.getNome());
                System.out.println("\n");
            }
        }
    }
}