package coopstock;

import produto.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        int op = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("CoopStock, solução inteligente em estoque" +
                    "\nBem vindo!\n O que deseja realizar hoje?");
            System.out.println("""
                    1- CADASTRAR PRODUTO
                    2- CONSULTAR PRODUTO
                    3- ENTRADA DE PRODUTO
                    4- SAIDA DE PRODUTO
                    5- RELATÓRIO
                    6- ENCERRAR""");
            op = input.nextInt();

            switch (op) {
                case 1: {
                    System.out.println("cadastrou o produto");
                    System.out.println("1");
                    break;
                }
                case 6:{
                    System.out.println("encerrando");
                    break;
                }
            }

        } while (op!=6);
    }
}
