public class Pessoa {
    private String nomeTitular;
    private String cpfTitular;
    private String telefoneTitular;

    public Pessoa(String nomeTitular, String cpfTitular, String telefoneTitular){
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.telefoneTitular = telefoneTitular;
    }

    @Override
    public String toString(){
        return nomeTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
    public String getCpfTitular() {
        return cpfTitular;
    }
    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }
    public String getTelefoneTitular() {
        return telefoneTitular;
    }
    public void setTelefoneTitular(String telefoneTitular) {
        this.telefoneTitular = telefoneTitular;
    }
}
