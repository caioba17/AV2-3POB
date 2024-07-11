public class Cliente {
    int id;
    String nome;
    String cpf;
    String email;
    String endereco;
    String cep;

    public Cliente(int id, String nome, String cpf, String email, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String imprimeCliente () {
        return String.format("ID: %d ; Nome: %s ; CPF: %s ; Email: %s ; Endereco: %s ; CEP: %s ;", getId(), getNome(), getCpf(), getEmail(), getEndereco(), getCep());
    }
}
