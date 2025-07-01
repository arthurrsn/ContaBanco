package edu.arthur.contabanco.controller;

import edu.arthur.contabanco.model.Conta;

/**
 * <h1>ContaController</h1>
 * <strong>Classe usada para controlar e acionar o modelo Conta.</strong>
 *<p>Tratamento inicial dos dados enviados ao Model e acionamento de funções</p>
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-06-27
 */
public class ContaController {
    private final Conta _conta = new Conta();

    /**
     * <h1>validarNumeroConta</h1>
     * <strong>Utilizado para validar o número de conta passado.</strong>
     * <p>
     *     O número de conta passado precisa ser de 5 dígitos para simular um banco real.
     *     Caso número não atenda o requisito irá lançar excessão.
     * </p>
     * @param numeroConta valor digitado para informar o numero da conta para cadastrar
     * @throws IllegalArgumentException lançada para quando o valor não possui 5 dígitos
     */
    public void validarNumeroConta(int numeroConta) throws IllegalArgumentException {
        if (numeroConta < 10000 || numeroConta > 99999) {
            // Se o número não possuir 5 dígitos é lançada uma exceção
            throw new IllegalArgumentException("O número da conta deve conter 5 dígitos.");
        }
    }

    /**
     * <h1>validarAgencia</h1>
     * <strong>Utilizado para validar a agência passada</strong>
     * <p>
     *     Não é permitido que a agência passada seja branca ou nula.
     *     Caso número não atenda o requisito irá lançar excessão.
     * </p>
     *
     * @param agencia valor digitado para informar a agência da conta para cadastrar
     * @throws IllegalArgumentException lançada para quando o valor é branco não encontrado
     */
    public void validarAgencia(String agencia) throws IllegalArgumentException {
        if (agencia.isBlank()) {
            // Caso o valor seja blank ou empty lança a excessão
            throw new IllegalArgumentException("Entrada inválida. Por favor, dígite o número da agência.");
        }
    }

    /**
     * <h1>validarNomeCliente</h1>
     * <strong>Utilizado para validar o nome do cliente passado.</strong>
     * <p>
     *    O nome do cliente não pode ser vazio ou conter apenas espaços.
     *    Além disso, o nome precisa que tenha pelo menos um espaço,
     *    para garantir nome e sobrenome.
     * </p>
     *
     * @param nomeCliente valor digitado para informar o nome do titular da conta.
     * @throws IllegalArgumentException lançada quando o nome é vazio ou não contém um espaço.
     */
    public void validarNomeCliente(String nomeCliente) throws IllegalArgumentException {
        if (nomeCliente == null || nomeCliente.isBlank()) {
            // Caso o valor seja nulo, em branco ou apenas espaços
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }

        // O .trim() remove espaços no início e no fim para validar o conteúdo real.
        // Verificamos se existe pelo menos um espaço entre as palavras.
        if (!nomeCliente.trim().contains(" ")) {
            throw new IllegalArgumentException("Por favor, digite o nome completo (pelo menos nome e sobrenome).");
        }
    }

    /**
     * <h1>validarSaldo</h1>
     * <strong>Utilizado para validar o saldo inicial informado.</strong>
     * <p>
     * A regra de negócio não permite a criação de uma conta com saldo inicial negativo.
     * O valor pode ser zero, mas não menor que isso.
     * </p>
     *
     * @param saldo valor digitado para o saldo inicial da conta.
     * @throws IllegalArgumentException lançada quando o saldo é um número negativo.
     */
    public void validarSaldo(double saldo) throws IllegalArgumentException {
        // A única regra para o saldo inicial é que ele não pode ser negativo.
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser um valor negativo.");
        }
    }

    /**
     * <h1>criarConta</h1>
     * <strong>Responsável por efetivar a criação da conta no modelo.</strong>
     * <p>
     * Este metodo recebe todos os dados já coletados e pré-validados da interface
     * e os utiliza para preencher o objeto 'Conta' interno. Ele serve como a etapa final
     * e definitiva do processo de cadastro, chamando os ‘setters’ do modelo que contêm
     * as regras de negócio finais.
     * </p>
     *
     * @param numeroConta O número final da conta a ser criado.
     * @param agencia A agência final da conta.
     * @param nomeCliente O nome completo final do titular da conta.
     * @param saldo O saldo inicial a ser depositado na conta.
     * @return {@code true} se todos os dados foram válidos e a conta foi criada com sucesso,
     * {@code false} se algum dado foi rejeitado pelos validadores internos do modelo ('setters').
     */
    public boolean criarConta(int numeroConta, String agencia, String nomeCliente, double saldo) {
        try {
            _conta.setNumero(numeroConta);
            _conta.setAgencia(agencia);
            _conta.setNomeCliente(nomeCliente);
            _conta.setSaldo(saldo);

            // Se chegou até aqui, todos os dados eram válidos
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    // Getter para o número da conta
    public int getNumero() {
        return this._conta.getNumero(); // Pede o número para o model interno
    }

    // Getter para a agência
    public String getAgencia() {
        return this._conta.getAgencia();
    }

    // Getter para o nome do cliente
    public String getNomeCliente() {
        return this._conta.getNomeCliente();
    }

    // Getter para o saldo
    public double getSaldo() {
        return this._conta.getSaldo();
    }
}
