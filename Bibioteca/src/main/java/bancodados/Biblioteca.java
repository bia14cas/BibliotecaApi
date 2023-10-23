package bancodados;

/** @author Beatriz Cardoso e Ladiane P. S.**/
        
import dao.*;
import entidades.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
        
        
public class Biblioteca {
    
    public static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        
        while (true) {
            System.out.print(" --- Biblioteca ---\n\n" +
                    "1) Realizar empréstimo\n" +
                    "2) Consultar empréstimo\n" +
                    "3) Remover empréstimo\n" +
                    "4) Adicionar aluno\n" +
                    "5) Adicionar publicação\n" +
                    "6) Sair\n\n" +
                    "Escolha uma opção: (1 -6)");
        
            String opcao = s.nextLine();
        
            switch (opcao) {
                case "1": realizarEmprestimo();     break;
                case "2": consultarEmprestimo(); break;
                case "3": removerEmprestimo();   break;
                case "4": adicionarAluno();      break;
                case "5": adicionarPublicacao(); break;
                case "6": System.exit(0);
                default:  System.out.println("Opção inválida.\n");
            }
            
            System.out.print("Enter para prosseguir...");
            s.nextLine();
        }
    }

    public static void realizarEmprestimo() {
        System.out.print(" --- Realizar empréstimo ---\n\n" +
                "Matrícula do aluno: ");
        int matricula = Integer.parseInt(s.nextLine());
        AlunoDAO aDao = new AlunoDAO();
        Aluno a = aDao.findById(matricula);
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.println("Nome do aluno: " + a.getNome());
        System.out.print("Data do empréstimo: (dd/mm/aaa) ");
        Date dataEmp = lerData();
        System.out.print("Data da devolução: (dd/mm/aaa) ");
        Date dataDev = lerData();
        Emprestimo e = new Emprestimo(dataEmp, dataDev);
        e.setAluno(a);
        EmprestimoDAO eDao = new EmprestimoDAO();
        eDao.insert(e);
        System.out.println("Realizado com sucesso.");
    }

    public static void consultarEmprestimo() {
        EmprestimoDAO dao = new EmprestimoDAO();
        List<Emprestimo> lista = dao.findAll();
        
        System.out.print(" --- Consultar empréstimo ---\n\n" +
                "CODIGO          DATA EMPRESTIMO DATA DEVOLUCAO  ALUNO");
        
        for (Emprestimo e : lista) {
            System.out.println(String.format("%15d %15s %15s %s", e.getId(), e.getDataEmprestimo().toString(), e.getDataDevolucao().toString(), e.getAluno().getNome() ));
        }
        
        System.out.println();
    }

    public static void removerEmprestimo() {
        System.out.print(" --- Remover empréstimo ---\n\n" +
                "Código do empréstimo: ");
        int id = Integer.parseInt(s.nextLine());
        EmprestimoDAO dao = new EmprestimoDAO();
        Emprestimo e = dao.findById(id);
        if (e == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("\n Confirmar dados\n");
        System.out.println("Nome do aluno: " + e.getAluno().getNome());
        System.out.println("Data do empréstimo: " + e.getDataEmprestimo());
        System.out.println("Data da devolução: " + e.getDataDevolucao());
        System.out.print("Remover este empréstimo? (s/n) ");
        dao.delete(e);
        System.out.println("Removido com sucesso.");
    }

    public static void adicionarAluno() {
        System.out.print(" --- Adicionar aluno ---\n\n" +
                "Matrícula: ");
        int matricula = Integer.parseInt(s.nextLine());
        System.out.print("Nome: ");
        String nome = s.nextLine();
        AlunoDAO dao = new AlunoDAO();
        Aluno a = new Aluno(matricula, nome);
        dao.insert(a);
        System.out.println("Adicionado com sucesso.");
    }

    public static void adicionarPublicacao() {
        System.out.print(" --- Adicionar empréstimo ---\n\n" +
                "Código: ");
        int codigo = Integer.parseInt(s.nextLine());
        System.out.print("Título: ");
        String titulo = s.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(s.nextLine());
        System.out.print("Autor: ");
        String autor = s.nextLine();
        System.out.print("Tipo: ");
        String tipo = s.nextLine();
        Publicacao p = new Publicacao(codigo, titulo, ano, autor, tipo);
        PublicacaoDAO dao = new PublicacaoDAO();
        dao.insert(p);
        System.out.println("Adicionado com sucesso.");
    }

    public static Date lerData() {
        String[] dataString = s.nextLine().split("/");
        int dia = Integer.parseInt(dataString[0]);
        int mes = Integer.parseInt(dataString[1]);
        int ano = Integer.parseInt(dataString[2]);
        Date data = new Date(ano, mes, dia);
        return data;
    }

}