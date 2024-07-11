import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continua = true;
        int opc;
        Processamento proc = new Processamento();

        while (continua)
        {
            System.out.println("---MENU---");
            System.out.println("1 - INCLUIR CLIENTE");
            System.out.println("2 - ALTERAR CLIENTE");
            System.out.println("3 - LISTAR CLIENTES");
            System.out.println("4 - REMOVER CLIENTE");
            System.out.println("5 - SAIR");
            System.out.println("6 - INCLUIR CLIENTE VIA ARQUIVO");
            System.out.println("Digite sua opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc)
            {
                case 1:
                    try {
                        proc.inserirBanco();
                    }
                    catch(SQLException e) {
                        System.out.println("ERRO DE BANCO!");
                        throw new RuntimeException(e);
                    }
                    catch (ClassNotFoundException e) {
                        System.out.println("ERRO DE ARQUIVO!");
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        proc.alterarBanco();
                    }
                    catch (SQLException e) {
                        System.out.println("ERRO DE BANCO!");
                        throw new RuntimeException(e);
                    }
                    catch (ClassNotFoundException e) {
                        System.out.println("ERRO DE ARQUIVO!");
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        proc.listarBanco();
                    }
                    catch (SQLException e) {
                        System.out.println("ERRO DE BANCO!");
                        throw new RuntimeException(e);
                    }
                    catch (ClassNotFoundException e) {
                        System.out.println("ERRO DE ARQUIVO!");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try {
                        proc.removerBanco();
                    }
                    catch (SQLException e) {
                        System.out.println("ERRO DE BANCO!");
                        throw new RuntimeException(e);
                    }
                    catch (ClassNotFoundException e) {
                        System.out.println("ERRO DE ARQUIVO!");
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    continua = false;
                    break;
                case 6:
                    try {
                        ArquivoProcessamento arq = new ArquivoProcessamento();
                        arq.lerArquivo("textav2.txt");
                    } catch (FileNotFoundException e) {
                        System.out.println("ERRO DE ARQUIVO!");
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        }

    }
}