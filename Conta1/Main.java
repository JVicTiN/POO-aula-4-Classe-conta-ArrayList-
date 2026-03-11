import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Conta buscarConta(ArrayList<Conta> vetor, String numero){

        Conta contaEncontrada = null;
        for(int i = 0; i < vetor.size(); i++){
                
            Conta c = vetor.get(i);

            if(c.getNroConta().equals(numero)){
                contaEncontrada = c;
                break;
            }
        }
        return contaEncontrada;
    }

    public static void main(String[] args) {
        
        ArrayList<Conta> vetor = new ArrayList<>();
        ArrayList<Pessoa> titulares = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcao = 0;
        while(opcao != 7){
            System.out.println("\n========== MENU ==========");
            System.out.println("(1) Cadastrar titular");
            System.out.println("(2) Criar uma nova Conta");
            System.out.println("(3) Exibir Saldo");
            System.out.println("(4) Sacar");
            System.out.println("(5) Depositar");
            System.out.println("(6) Transferir");
            System.out.println("(7) Encerrar Programa");
            System.out.println("==========================\n");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(opcao){
                case 1:
                    System.out.print("Digite o nome do titular: ");
                    String nomeTitular = sc.nextLine();

                    System.out.print("Digite o CPF do titular: ");
                    String cpfTitular = sc.nextLine();

                    System.out.print("Digite o numero de telefone: ");
                    String telefoneTitular = sc.nextLine();

                    Pessoa novoTitular = new Pessoa(nomeTitular, cpfTitular, telefoneTitular);
                    titulares.add(novoTitular);
                    break;

                case 2:
                    System.out.print("Digite o CPF do Titular: ");
                    String cpf = sc.nextLine();
                    Pessoa titularEncontrado = null;
                    for(int i = 0; i < titulares.size(); i++){

                        Pessoa p = titulares.get(i);

                        if(p.getCpfTitular().equals(cpf)){
                            titularEncontrado = p;
                            break;
                        }
                    }
                    if(titularEncontrado != null){
                        System.out.println("\nCPF encontrado!");
                        System.out.println("===========================");
                        System.out.println("Prossiga com o formulário\n");
                        Pessoa titular = titularEncontrado;

                        System.out.print("Numero da agência: ");
                        String agencia = sc.nextLine();

                        System.out.print("Qual banco: ");
                        String banco = sc.nextLine();

                        System.out.print("Numero da conta: ");
                        String nroConta = sc.nextLine();

                        Conta novaConta = new Conta(titular, agencia, banco, nroConta);
                        vetor.add(novaConta);
                    }
                    else{
                        System.out.println("\nTitular não encontrado!");
                    }

                    break;

                case 3:
                    System.out.print("Digite o numero da conta: ");
                    String numero = sc.nextLine();

                    Conta encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.println("\n=====================");
                        System.out.println("Saldo: R$" + encontrada.getSaldo());
                        System.out.println("=====================");
                        System.out.println(encontrada);
                    } 
                    else{
                        System.out.println("Conta não encontrada!");
                    }

                    break;

                case 4:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a sacar: R$");
                        double valor = sc.nextDouble();

                        if(encontrada.sacar(valor)){
                            System.out.println("Saque realizado com sucesso!");
                        }
                        else{
                            System.out.println("Saldo insuficiente / Valor inválido");
                        }
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a depositar: R$");
                        double valor = sc.nextDouble();

                        if(encontrada.depositar(valor)){
                            System.out.println("Valor depositado com sucesso!");
                        }
                        else{
                            System.out.println("Saldo insuficiente / Valor inválido");
                        }
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a transferir: R$");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Conta a receber a transferencia: ");
                        numero = sc.nextLine();
                        Conta destino = buscarConta(vetor, numero);
                        if(destino != null){
                            if(encontrada.transferir(valor, destino)){
                                System.out.println("Transferencia realizada com sucesso!");
                            }
                            else{
                                System.out.println("Saldo insuficiente / Valor inválido");
                            }
                        }
                        else{
                            System.out.println("Conta não encontrada!");
                        } 
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando Programa...\n");
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
        sc.close();
    }
}
