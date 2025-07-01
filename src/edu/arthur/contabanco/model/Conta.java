package edu.arthur.contabanco.model;

/**
 * Classe usada para armazenar e gerênciar os dados da conta bancaria que o utilizador quer acessar.
 *
 * @author Arthur Ribeiro
 * @version 1.0
 * @since 2025-06-25
 */
public class Conta {

    private int _numero;
    private String _agencia, _nomeCliente;
    private double _saldo;

    // region Getters&Setters

    // Pegar o valor do atríbuto privado Saldo
    public double getSaldo() {
        return this._saldo;
    }

    /**
     * Define o saldo em conta. O saldo não pode ser negativo.
     *
     * @param saldo O saldo da conta.
     * @throws IllegalArgumentException se o saldo fornecido for negativo.
     */
    public void setSaldo(double saldo) throws IllegalArgumentException{
        if (saldo < 0) {
            // O próprio Model se recusa a aceitar um estado inválido.
            throw new IllegalArgumentException("O saldo não pode ser um valor negativo.");
        }
        this._saldo = saldo;
    }


    // Pegar o valor do atríbuto privado NomeCliente
    public String getNomeCliente() {
        return this._nomeCliente;
    }

    /**
     * Define o nome do cliente.
     * @param nomeCliente O nome do cliente caso ele não seja nulo ou espaço em branco;
     */
    public void setNomeCliente(String nomeCliente) {
        if(!nomeCliente.isBlank()){
            // Caso não seja núlo armazenamos
            this._nomeCliente = nomeCliente.toUpperCase();
        } else {
            // Disparamos a exceção caso seja nulo
            throw new IllegalArgumentException("Nome é nulo ou espaço em branco");
        }
    }


    // Pegar o valor do atríbuto privado Agencia
    public String getAgencia() {
        return this._agencia;
    }

    /**
     * Define a agência da conta, incluindo o dígito verificador.
     * <p>
     *     O número da agência precisa possuir 4 dígitos,
     *     sendo o último, o dígito verificador.
     *     Exemplo: 067-8.
     * </p>
     *
     * @param agencia A agência da conta. Não pode ser nulo.
     */
    public void setAgencia(String agencia) {
        if(!agencia.isBlank()){
            // Caso não seja núlo armazenamos
            this._agencia = agencia;
        } else {
            // Disparamos a exceção caso seja nulo
            throw new IllegalArgumentException("Valor da agência é nulo ou espaço em branco");
        }

    }


    // Pegar o valor do atríbuto privado Numero
    public int getNumero() {
        return this._numero;
    }

    /**
     * Define o número da conta, incluindo seu dígito verificador.
     * <p>
     *     O número da conta deve ser informado como uma sequência contínua de dígitos,
     *     finalizando com o dígito verificador.
     *     Exemplo: Para a conta 1234567-8, o valor informado deve ser {@code 12345678}.
     * </p>
     *
     *  @param numero O número da conta. Não pode ser zero.
     *  @throws IllegalArgumentException se o número da conta fornecido for zero.
     */
    public void setNumero(int numero) {
        if(numero != 0){
            // Caso o param esteja correto, vamos atribuir ao atributo da classe
            this._numero = numero;
        } else {
            // Caso o valor esteja errado, lançamos a exceção.
            throw new IllegalArgumentException("Valor é nulo ou zero.");
        }
    }

    // endregion Getters&Setters



}
