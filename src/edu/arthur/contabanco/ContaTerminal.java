package edu.arthur.contabanco;

import edu.arthur.contabanco.controller.ContaController;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * <h1>ContaTerminal</h1>
 * <strong>Classe para representar o site administrativo de um banco em forma de terminal.</strong>
 * <h4>Não Usar Para Ambiente De Produção. Projeto como uso de treino</h4>
 * <p>Conexão com controllers e models para realizar cadastro e entrada de contas.</p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-06-26
 */
public class ContaTerminal {

    /**
     * <h1>main</h1>
     * <strong>Função de entrada no programa.</strong>
     * <p>
     *     Será utilizado como se fosse o front end
     *     e o arquivo principal do nosso programa (‘Interface’ e direcionamento para controller).
     * </p>
     *
     * @param args Não utilizado.
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final ContaController contaController = new ContaController();

        /*
         * Repetição infinita para executarmos o cadastro de conta varias vezes.
         * Assim, caso tenha algum dígito não válido,
         * não precisamos realizar o processo novamente.
         */
        while (true) {
            try {
                System.out.print("""
                        [1] Cadastrar
                        [2] Entrar
                        [3] Sair
                        ->
                        """);

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpando buffer


                /*
                 * Na versão 1.0 do programa não realizaremos a entrada de contas.
                 * Focaremos no desafio proposto e seguiremos na versão 1.0 apenas com o cadastro
                 *
                 * TODO: Futuras versões incluir o método de entrada e armazenamento de contas
                 */
                switch (escolha){
                    case 1 -> cadastrarConta(contaController, scanner);
                    case 2 -> entrarConta();
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Valor inválido.\nDigite apenas o número da opção desejada.");
                }
            }

            /*
             * Lançando exceção para quando ocorrer algum problema de incompatibilidade na entrada do utilizador.
             * Ex: Tipo diferente de int, valor nulo, espaço em branco, etc.
             */
            catch (InputMismatchException e){
                System.out.println("Valor inválido.\nDigite apenas o número da opção desejada.\nException: " + e);

            }

            // Manter controle de processos pelo terminal.
            finally {
                System.out.println("Processo de entrada finalizado.");
            }
        }
    }

    /**
     * <h1>CadastrarConta</h1>
     * <strong>Função utilizada para realizar entrada das informações para cadastro de nova conta.</strong>
     * <p>
     *     A função envia a entrada do utilizador para o controller e tem a responsabilidade
     *     de validar se as informações passadas ao controller foram aceitas.
     *     Possúi uma repetição infinita para executar cada parte do cadastro individualmente e caso
     *     possua algum erro, retornar sem precisar digitar todas as informações novamente.
     * </p>
     *
     * @param contaController Reutilizando Classe instanciada no código principal.
     * @param scanner Reutilizando o leitor de entrada para não sobrecarregar a execução
     *
     * @throws InputMismatchException utilizada para qualquer incompatibilidade ao digitar uma entrada pelo teclado
     * @throws IllegalArgumentException utilizado na entrada da agência e do nome. Como se trata de ‘String’, estamos a deixar mais aberto
     */
    public static void cadastrarConta(ContaController contaController, Scanner scanner) throws InputMismatchException, IllegalArgumentException {
        int numeroConta;
        String agencia, nomeCliente;
        double saldo;

        // Número da conta
        while (true) {
            try {
                System.out.print("Digite o número da conta: ");
                numeroConta = scanner.nextInt();
                scanner.nextLine(); // Limpando Buffer

                // Passando o valor para o controller que irá validar e retornar se deu certo
                contaController.validarNumeroConta(numeroConta);
                break; // Caso não haja nenhuma excessão saímos da repetição

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                scanner.nextLine(); // Limpa buffer para evitar loop infinito
            }
        }

        // Agência
        while (true) {
            try {
                System.out.print("Digite a agência: ");
                agencia = scanner.nextLine().trim(); // Retirando espaços em branco com o .trim()

                contaController.validarAgencia(agencia);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        // Nome do Cliente
        while (true) {
            try {
                System.out.print("Digite o nome do cliente: ");
                nomeCliente = scanner.nextLine().trim();

                contaController.validarNomeCliente(nomeCliente);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        // Saldo Inicial
        while (true) {
            try {
                System.out.print("Digite o saldo inicial: R$ ");
                saldo = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer

                contaController.validarSaldo(saldo);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico com ponto ou vírgula.");
                scanner.nextLine(); // Limpa buffer
            }
        }

        /*
         * Tentativa de cadastrar conta.
         * Caso consiga, irá utilizar getters remediados do controller com o model.
         * Assim conseguimos manter a integridade do nosso modelo apenas no controlador.
         */
        if (contaController.criarConta(numeroConta, agencia, nomeCliente, saldo)) {
            System.out.printf("""
                    
                    -----------------------------------------
                    CONTA CADASTRADA COM SUCESSO!
                    -----------------------------------------
                    Olá, %s!
                    Obrigado por criar uma conta em nosso banco.
                    
                    Detalhes da sua conta:
                    Agência:     %s
                    Conta:       %d
                    Saldo:       R$ %.2f
                    
                    Seu saldo já está disponível para saque.
                    -----------------------------------------
                    
                    Pressione [enter] para voltar ao menu.
                    """, contaController.getNomeCliente(), contaController.getAgencia(), contaController.getNumero(), contaController.getSaldo());
            scanner.nextLine();
        } else {
            System.out.println("ERRO INESPERADO: Não foi possível registrar a conta. Por favor, tente novamente.");
        }
    }


    /**
     * <h1>entrarConta</h1>
     * <strong>Realiza o processo de entrada na conta</strong>
     * <h4>Funcionalidade ainda não utilizável na versão 1.0</h4>
     * <p>
     *     Em futuras versões, essa função deverá puxar o controller
     *     responsável por acionar o db para verificar se as informações passadas
     *     pelo utilizador estão na nossa base de dados.
     *     Caso esteja, irá instanciar a classe conta por meio de um construtor com os dados obtidos do db.
     *     Caso não esteja, irá retornar uma mensagem informando "credenciais inválidas".
     * </p>
     */
    public static void entrarConta(){
    }
}
