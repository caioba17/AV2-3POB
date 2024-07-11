import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
public class ArquivoProcessamento {
    public void lerArquivo(String nomeArquivo) throws FileNotFoundException {
        try {
            File arq = new File(nomeArquivo);
            Scanner lt = new Scanner(arq);
            System.out.println("Vou ler o arquivo: " + nomeArquivo);
            lt.nextLine();
            while (lt.hasNextLine())
            {
                String linha = lt.nextLine();
                processarLinha(linha);
            }
            lt.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro na leitura do arquivo.");
            throw new RuntimeException(e);
        }
    }
    public void processarLinha(String lin) {
        String[] infos = lin.split(";");

        String nome = infos[0];
        String cpf = infos[1];
        String email = infos[2];
        String endereco = infos[3];
        String cep = infos[4];

        Processamento proc = new Processamento();
        try {
            proc.inserirBancoArq(nome, cpf, email, endereco, cep);
        } catch (SQLException e) {
            System.out.println("ERRO DE BANCO!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO DE ARQUIVO!");
            throw new RuntimeException(e);
        }
    }
}