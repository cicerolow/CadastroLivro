// Exercício:
// Você deve montar um sistema de cadastro e listagem de livros para um sebo que só aceita livros com mais de 5  anos de lançamento.
// Seu PO fez uma reunião com o dono do sebo e fez uma modelagem para que você possa se basear e criar o  sistema.

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema Cadastro de Livros");

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodoLivro = new Livro();

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Digite uma opção: 1 - Cadastrar Livro / 2 - Listar Livro / 0 - Voltar");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    Livro novoLivro = new Livro();
                    System.out.println("Digite o título do livro: ");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.println("Digite o nome do autor: ");
                    novoLivro.nome = leitor.nextLine();

                    System.out.println("Digite o preço do livro: ");
                    novoLivro.preco = leitor.nextFloat();

                    System.out.println("Digite a data de lançamento: (dd/mm/aaaa)");
                    novoLivro.dataLanc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period Lanc = Period.between(novoLivro.dataLanc, LocalDate.now());

                    if (Lanc.getYears() > 5) {
                        metodoLivro.cadastroLivro(novoLivro);
                        System.out.println("Data Valida!");
                    } else {
                        System.out.println("Idade Invalida");
                    }
                    break;
                case "2":
                    if (metodoLivro.listaLivro().size() > 0) {

                        for (Livro cadaLivro : metodoLivro.listaLivro()) {
                            System.out.println("titulo: " + cadaLivro.titulo);
                            System.out.println("nome: " + cadaLivro.nome);
                            System.out.println("preco: " + cadaLivro.preco);
                            System.out.println("data de Lancamento: " + cadaLivro.dataLanc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Pressione Enter para continuar");
                            leitor.nextLine();
                        }

                    } else {
                        System.out.println("Lista vazia!");
                    }
                    break;
            }

        }while (!opcao.equals("0"));
    }
}