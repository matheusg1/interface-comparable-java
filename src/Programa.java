import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {
    public static void main(String[] args) throws Exception {
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        String strPath = "C:\\temp\\Funcionarios.csv";        ;

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){

            separaCsvAddFuncionario(br, listaFuncionarios);

            Collections.sort(listaFuncionarios);
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario.toString());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void separaCsvAddFuncionario(BufferedReader br, List<Funcionario> lista) throws Exception{
        String leitorLinhas = br.readLine();

        while(leitorLinhas != null){
            String[] linhas = leitorLinhas.split("\n");

            for (String linha : linhas) {
                String[] linha2 = linha.split(",");
                addFuncionario(linha2[0], Double.parseDouble(linha2[1]), lista);

            }
            leitorLinhas = br.readLine();
        }
    }

    public static void addFuncionario(String nome, Double valor, List<Funcionario> lista){
        Funcionario func = new Funcionario(nome, valor);
        lista.add(func);
    }
}