package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/** @author Beatriz Cardoso e Ladiane P. S.**/

@Entity
public class Aluno {
    @Id
    private int idAluno;
    private String nome;
    @OneToMany
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Aluno() { }

    public Aluno(int idAluno, String nome) {
        this.idAluno = idAluno;
        this.nome = nome;
    }
    // getters e setters
    public int getIdAluno() {
        return idAluno;
    }

    public void setIDAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    
}
