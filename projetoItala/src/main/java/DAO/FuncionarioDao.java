package DAO;

import DTO.FuncionarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDto> lista = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDto funcionarioDto) {

        String sql = "insert into funcionario(nome, funcao, treinamento, statusTreinamento) value (?,?,?,?)";
        conn = new ConexaoClasse().conectaBd();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDto.getNomeFuncionario());
            pstm.setString(2, funcionarioDto.getFuncaoFuncionario());
            pstm.setString(3, funcionarioDto.getTreinamentoFuncionario());
            pstm.setString(4, funcionarioDto.getStatusFuncionario());
            pstm.execute();
            pstm.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Funcionario");

        }

    }

    public ArrayList<FuncionarioDto> PesquisarFuncionario() {

        String sql = "select * from funcionario";
        conn = new ConexaoClasse().conectaBd();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                FuncionarioDto funcionarioDto = new FuncionarioDto();
                funcionarioDto.setMatricula(rs.getInt("matricula"));
                funcionarioDto.setNomeFuncionario(rs.getString("nome"));
                funcionarioDto.setFuncaoFuncionario(rs.getString("funcao"));
                funcionarioDto.setTreinamentoFuncionario(rs.getString("treinamento"));
                funcionarioDto.setStatusFuncionario(rs.getString("statusTreinamento"));
          
                lista.add(funcionarioDto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro pesquisar");
        }

        return lista;
    }

    public void alterarFuncionario(FuncionarioDto funcionarioDto) {

        String sql = "update funcionario set nome = ?, funcao = ?, treinamento = ?, statusTreinamento = ? where matricula = ?";
        conn = new ConexaoClasse().conectaBd();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDto.getNomeFuncionario());
            pstm.setString(2, funcionarioDto.getFuncaoFuncionario());
            pstm.setString(3, funcionarioDto.getTreinamentoFuncionario());
            pstm.setString(4, funcionarioDto.getStatusFuncionario());
            pstm.setInt(5, funcionarioDto.getMatricula());
            pstm.execute();
            pstm.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Funcionario");

        }

    }

    public void excluirFuncinario(FuncionarioDto funcionarioDto) {
        
        String sql = "delete from funcionario where matricula = ?";
        
         conn = new ConexaoClasse().conectaBd();
        
        try {

            pstm = conn.prepareStatement(sql);
         
            pstm.setInt(1, funcionarioDto.getMatricula());
            
            pstm.execute();
            pstm.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e + "Funcionario");

        }
    }    
    
    public ArrayList<FuncionarioDto> buscarFuncionario(int matricula) {

        String sql = "select * from funcionario where matricula = ?";
        conn = new ConexaoClasse().conectaBd();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            
            
            while (rs.next()) {
                FuncionarioDto funcionarioDto = new FuncionarioDto();
                funcionarioDto.setNomeFuncionario(rs.getString("nome"));
                funcionarioDto.setFuncaoFuncionario(rs.getString("funcao"));
                funcionarioDto.setTreinamentoFuncionario(rs.getString("treinamento"));
                funcionarioDto.setStatusFuncionario(rs.getString("statusTreinamento"));
          
                lista.add(funcionarioDto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro pesquisar");
        }

        return lista;
    }
    
    public int matriculaVisu() {
    String sql = "select matricula from funcionario";     
    conn = new ConexaoClasse().conectaBd();
    ResultSet rs = null;
    int maxMatricula = 0; 

    try {
        pstm = conn.prepareStatement(sql);
        rs = pstm.executeQuery();

        
        while (rs.next()) {
            int matricula = rs.getInt(1); 
            if (matricula > maxMatricula) {
                maxMatricula = matricula;
            }
        }

        pstm.close();
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e + "Funcionario");
    }

    
    return maxMatricula + 1;
}
}


    