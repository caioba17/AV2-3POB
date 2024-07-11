import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Processamento {
    public void inserirBanco() throws SQLException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        String nomeC, cpfC, enderecoC, cepC, emailC;
        System.out.println("---Inserção de cliente---");
        System.out.println("Nome: ");
        nomeC = sc.nextLine();
        System.out.println("CPF: ");
        cpfC = sc.nextLine();
        System.out.println("Email: ");
        emailC = sc.nextLine();
        System.out.println("CEP: ");
        cepC = sc.nextLine();
        System.out.println("Endereco: ");
        enderecoC = sc.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.criarConexao();

        String sql = String.format("INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES ('%s', '%s', '%s', '%s', '%s')", nomeC, cpfC, emailC, enderecoC, cepC);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
    }

    public void removerBanco() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.criarConexao();

        Scanner sc = new Scanner(System.in);
        int idC;
        System.out.println("---Remoção de cliente---");
        System.out.println("Digite o id do cliente a ser removido: ");
        idC = sc.nextInt();
        sc.nextLine();

        String sql1 = String.format("SELECT COUNT(*) FROM clientes WHERE id = '%d'", idC);
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        int cont = rs.getInt(1);

        if (cont == 0) {
            System.out.println("ID inválido.");
        }
        else {
            String sql = String.format("DELETE FROM clientes WHERE id = '%d'", idC);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        }
    }

    public void listarBanco() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.criarConexao();

        String sql = "SELECT * FROM clientes";
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet;
        resultSet = stmt.executeQuery(sql);

        int id;
        String nome, cpf, email, endereco,cep;

        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        while(resultSet.next()) {
            id = resultSet.getInt("id");
            nome = resultSet.getString("nome");
            cpf = resultSet.getString("cpf");
            email = resultSet.getString("email");
            endereco = resultSet.getString("endereco");
            cep = resultSet.getString("cep");
            Cliente cli = new Cliente(id, nome, cpf, email, endereco, cep);
            lista.add(cli);
        }
        System.out.println("---CLIENTES---");
        System.out.print("\n");
        for (Cliente c : lista) {
            System.out.println(c.imprimeCliente());
            System.out.print("\n");
        }
    }

    public void alterarBanco() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.criarConexao();

        Scanner sc = new Scanner(System.in);
        int idA;
        System.out.println("---Alteração de cliente---");
        System.out.println("Digite o id do cliente a ser alterado: ");
        idA = sc.nextInt();
        sc.nextLine();

        String sql1 = String.format("SELECT COUNT(*) FROM clientes WHERE id = '%d'", idA);
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        int cont = rs.getInt(1);

        if (cont == 0) {
            System.out.println("ID inválido.");
        }
        else {
            String nomeC, cpfC, enderecoC, cepC, emailC;

            System.out.println("Nome: ");
            nomeC = sc.nextLine();
            System.out.println("CPF: ");
            cpfC = sc.nextLine();
            System.out.println("Email: ");
            emailC = sc.nextLine();
            System.out.println("CEP: ");
            cepC = sc.nextLine();
            System.out.println("Endereco: ");
            enderecoC = sc.nextLine();

            String sql = String.format("UPDATE clientes SET nome = '%s', cpf = '%s', email = '%s', endereco = '%s', cep = '%s' WHERE id = '%d';", nomeC, cpfC, emailC, enderecoC, cepC, idA);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        }
    }

    public void inserirBancoArq(String nome, String cpf, String email, String endereco, String cep) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.criarConexao();

        String sql = String.format("INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES ('%s', '%s', '%s', '%s', '%s')", nome, cpf, email, endereco, cep);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
    }
}
