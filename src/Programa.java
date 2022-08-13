import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        String strPath = "C:\\temp\\Funcionarios.csv";        ;

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){

            String leitorLinhas = br.readLine();

            while(leitorLinhas != null){
                String[] linhas = leitorLinhas.split("\n");

                for (String linha : linhas) {
                    String[] linha2 = linha.split(",");
                    Funcionario func = new Funcionario((linha2[0]), Double.parseDouble(linha2[1]));
                    listaFuncionarios.add(func);
                }
                leitorLinhas = br.readLine();
            }
            Collections.sort(listaFuncionarios);
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario.toString());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}