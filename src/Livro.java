// Exercício:
// Você deve montar um sistema de cadastro e listagem de livros para um sebo que só aceita livros com mais de 5  anos de lançamento.
// Seu PO fez uma reunião com o dono do sebo e fez uma modelagem para que você possa se basear e criar o  sistema.

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Autor{
    public String titulo;
    public float preco;
    public LocalDate dataLanc;

    private ArrayList<Livro> listaLivro = new ArrayList<>();

    public void cadastroLivro(Livro livro){

        listaLivro.add(livro);

        System.out.println("Cadastro realizado com sucesso!!!");
    }
    public ArrayList<Livro> listaLivro(){
        return listaLivro;
    }
    public int verificarTempLanc(Date dataLanc){
        return 0;
    }

}