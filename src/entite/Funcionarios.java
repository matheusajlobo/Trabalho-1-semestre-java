package entite;

public class Funcionarios {
    private String nome;
    private Integer matricula;
    private String cargo;
    private Double remuneracao;
    private String setor;

    public Funcionarios(Integer matricula, String nome, String cargo, String setor, Double remuneracao) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
        this.remuneracao = remuneracao;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(Double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Matrícula: "
              + String.format("%d, ",getMatricula())
              + "Nome: "
              + getNome()
              + ", Cargo: "
              + getCargo()
              + ", Setor: "
              + getSetor()
              + ", Remuneração: "
              + String.format("%.2f", getRemuneracao())  ;
    }
}
