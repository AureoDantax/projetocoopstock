package coopstock;


import java.util.Objects;
import java.util.Scanner;

import static servico.ImplementaServico.cadastraProduto;
import static servico.ImplementaServico.consultarProdutos;

public class Main {
    public static void main(String[] args) {



        menu();
    }

    public static void menu() {
        String op = "";
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n\nCoopStock, solução inteligente em estoque" +
                    "\n\n\nBem vindo!\n\nO que deseja realizar hoje?");
            System.out.println("""
                    1- CADASTRAR PRODUTO
                    2- CONSULTAR PRODUTO
                    3- ENCERRAR""");
            op = input.next();
            if(!op.equals("1") && !op.equals("2") && op.equals("3")){
                System.out.println("Opção inválida, digite uma opção do menu em forma numeral!");

            }

            switch (op) {
                case "1": {
                cadastraProduto();
                    break;
                }
                case "2": {
                consultarProdutos();
                break;
                }
                case "3": {
                    System.out.println("Até mais!");
                    break;
                }
            }

        } while (!op.equals("3"));
    }
}
