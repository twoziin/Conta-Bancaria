import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeCliente = "Jacqueline Oliveira";
        String tipoConta = "Corrente";
        double saldoInicial = 2500.00;

        Scanner scanner = new Scanner(System.in);

        String dadosCliente = String.format("""
                ***********************
                  
                Dados iniciais do cliente:

                Nome: %s
                Tipo conta: %s
                Saldo inicial: R$ %.2f

                ***********************
                """, nomeCliente, tipoConta, saldoInicial);

        System.out.println(dadosCliente);

        for (; ;) {
            String operacoes = """
                    
                    Operações
           
                    1 - Consultar saldos
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair
        
                    Digite a opção desejada:
                    """;
            System.out.println(operacoes);
            int escolha = scanner.nextInt();
            String saldoAtualizado;
            switch(escolha) {
                case 1:
                    System.out.println("O saldo atual é R$ " + saldoInicial);
                    break;
                case 2:
                    System.out.println("Informe o valor a receber: ");
                    double valorReceber = scanner.nextDouble();
                    if(valorReceber <= 0) {
                        System.err.println("Valor inválido");
                    } else {
                        saldoInicial += valorReceber;
                        saldoAtualizado = String.format("""
                                Saldo atualizado R$ %.2f
                                """, saldoInicial);

                    System.out.println(saldoAtualizado);
                        System.out.println(saldoAtualizado);
                    }
                    break;
                case 3:
                    System.out.print("Informe o valor de deseja transferir: ");
                    double valorTransferir = scanner.nextDouble();
                    if (saldoInicial < valorTransferir) {
                        System.out.println("Você não tem saldo suficiente!");
                        break;
                    } else {
                        saldoInicial -= valorTransferir;

                        saldoAtualizado = String.format("""
                                Saldo atualizado R$ %.2f
                                """, saldoInicial);

                        System.out.println(saldoAtualizado);
                        break;
                    }
                case 4:
                    System.out.println("Saindo...");
                    break;
            }
            if(escolha > 4 || escolha < 1) {
                System.out.println("Escolha inválida. Por favor, escolha uma opção valida.");
            } else if(escolha == 4) break;
        }
    }
}