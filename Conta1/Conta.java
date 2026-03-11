public class Conta {
    private Pessoa titular;
    private String agencia;
    private String banco;
    private String nroConta;
    private double saldo;

    public Conta(Pessoa titular, String agencia, String banco, String nroConta){
        this.titular = titular;
        this.agencia = agencia;
        this.banco = banco;
        this.nroConta = nroConta;
        this.saldo = 0;
    }

    public Conta(Pessoa titular,  String banco, String nroConta){
        this.titular = titular;
        this.agencia = "0001";
        this.banco = banco;
        this.nroConta = nroConta;
        this.saldo = 0;
    }

    public Conta(Pessoa titular,  String nroConta){
        this.titular = titular;
        this.agencia = "0001";
        this.nroConta = nroConta;
        this.saldo = 0;
    }

    public Conta(Pessoa titular,  String banco, String nroConta, double saldo){
        this.titular = titular;
        this.agencia = "0001";
        this.banco = banco;
        this.nroConta = nroConta;
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "Titular: " + titular +
                "\nAgencia: " + agencia +
                "\nBanco: " + banco +
                "\nnroConta: " + nroConta;
    }

    public Pessoa getTitular(){
        return titular;
    }

    public void setTitular(Pessoa novoTitular){
        titular = novoTitular;
    }
    

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNroConta() {
        return nroConta;
    }

    public void setNroConta(String nroConta) {
        this.nroConta = nroConta;
    }

    public double getSaldo() {
        return saldo;
    }


    public String extrato(){
        return "R$ "+saldo;
    }


    public boolean sacar(double valor){
        if(valor > 0 && valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino){
        if(sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;

    }

    //C / C++



}