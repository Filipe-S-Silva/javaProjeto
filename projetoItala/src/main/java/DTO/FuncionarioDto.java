package DTO;

public class FuncionarioDto {

    private String nomeFuncionario, funcaoFuncionario, treinamentoFuncionario, statusFuncionario;
    private int matricula;

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public String getTreinamentoFuncionario() {
        return treinamentoFuncionario;
    }

    public String getStatusFuncionario() {
        return statusFuncionario;
    }

    public int getMatricula() {
        return matricula;
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    
    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    public void setTreinamentoFuncionario(String treinamentoFuncionario) {
        this.treinamentoFuncionario = treinamentoFuncionario;
    }

    public void setStatusFuncionario(String statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }  

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
}
