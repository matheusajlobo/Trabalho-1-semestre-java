package entite;

public class Dependentes extends Funcionarios{ //extendendo da classe Funcionarios
    private final Integer id;
    private String nomeDep;
    private String parentesco;
    private Integer idade;

    // criando um construtor para tornar obrigatorio a inserção de alguns dados ao instanciar a classe
    public Dependentes(Integer matricula, String nome, String cargo, String setor, Double remuneracao, Integer id, String nomeDep, String parentesco, Integer idade) {
        super(matricula, nome, cargo, setor, remuneracao);
        this.id = id;
        this.nomeDep = nomeDep;
        this.parentesco = parentesco;
        this.idade = idade;
    }

    // criando getter e setter

    public Integer getId() {

        return id;
    }

    public String getNomeDep() {

        return nomeDep;
    }

    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
    }

    public String getParentesco() {

        return parentesco;
    }

    public void setParentesco(String parentesco) {

        this.parentesco = parentesco;
    }

    public Integer getIdade() {

        return idade;
    }

    public void setIdade(Integer idade) {

        this.idade = idade;
    }

    // realizando a sobrescrição do toString
    @Override
    public String toString() {
        return super.toString()
                +"Dependentes: \n"
                + "Id: "
                +id
                + ", Nome : "
                +nomeDep
                + ", Parentesco: "
                + parentesco
                + ", Idade: "
                + idade + ".";
    }
}
