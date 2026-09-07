package model;

/**
 *
 * @author cadu
 */
public class Fornecedor {

    private int id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;

    // ================= CONSTRUTOR =================

    public Fornecedor(int id, String nome, String cnpj, String telefone, String email) {

        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
    }

    // ================= GETTERS E SETTERS =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ================= EXIBIR FORNECEDOR =================

    public void exibirFornecedor() {

        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
    }
}