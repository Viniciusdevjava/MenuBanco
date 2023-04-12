import java.util.Scanner;

public class SistemaBancario {
    static Scanner scanner = new Scanner(System.in);
    static String nomeCliente;
    static double saldoCliente = 1000.0;

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 5);
    }

    public static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Dados");
        System.out.println("3 - Depositar");
        System.out.println("4 - Saque");
        System.out.println("5 - Sair");
    }

    public static int lerOpcao() {
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    public static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                listarDados();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    public static void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        scanner.nextLine();
        nomeCliente = scanner.nextLine();
        saldoCliente = 1000.0;
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void listarDados() {
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Saldo da conta corrente: R$" + saldoCliente);
    }

    public static void depositar() {
        System.out.print("Digite o valor do depósito: R$");
        double valorDeposito = scanner.nextDouble();
        if (valorDeposito < 0) {
            System.out.println("Erro: valor de depósito inválido! Tente novamente.");
            return;
        }
        saldoCliente += valorDeposito;
        System.out.println("Depósito efetuado com sucesso! Novo saldo: R$" + saldoCliente);
    }

    public static void sacar() {
        System.out.print("Digite o valor do saque: R$");
        double valorSaque = scanner.nextDouble();
        if (valorSaque < 0 || valorSaque > saldoCliente) {
            System.out.println("Erro: valor de saque inválido! Tente novamente.");
            return;
        }
        saldoCliente -= valorSaque;
        System.out.println("Saque efetuado com sucesso! Novo saldo: R$" + saldoCliente);
    }
}
