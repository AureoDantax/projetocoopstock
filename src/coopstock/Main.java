package coopstock;


import java.util.Scanner;

import static servico.ImplementaServico.*;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        String op;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("""


                    CoopStock, solução inteligente em estoque


                    Bem vindo!

                    O que deseja realizar hoje?
                                
                    1- CADASTRAR PRODUTO
                    2- LISTAR PRODUTOS
                    3- EDITAR DADOS DO PRODUTO
                    4- REMOVER PRODUTO
                    5- ENCERRAR""");

            op = input.next();

            if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5")) {
                System.out.println("Opção inválida, digite uma opção do menu e em forma numeral!");

            }

            switch (op) {

                case "1" -> cadastraProduto();

                case "2" -> {
                    verificaVetorVazio();
                    listaProdutos();
                }

                case "3" -> {
                    verificaVetorVazio();
                    editaCadastro();
                }

                case "4" -> {
                    verificaVetorVazio();
                    removeProduto();
                }

                case "5" -> System.out.println("Até mais!");

            }

        } while (!op.equals("5"));
    }
}
