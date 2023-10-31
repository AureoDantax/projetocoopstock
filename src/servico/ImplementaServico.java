package servico;

import java.util.Scanner;

public class ImplementaServico {
    public static String[] produtos = new String[10];

    public static void cadastraProduto() {

        int numCadastros = 0, i;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantos produtos vão ser cadastrados");
        numCadastros = entrada.nextInt();
        if (numCadastros > produtos.length) {
            System.out.println("não há espaço no estoque para o numero de produtos informados, existe " + produtos.length +
                    " espaços para cadastro\n\n");
            cadastraProduto();
        } else {
            System.out.println("digite o nome do produto");
            for (i = 0; i < numCadastros; i++) {
                produtos[i] = entrada.next();
            }
            System.out.println(numCadastros + " produtos cadastrados com sucesso! De volta ao menu\n1");
        }
    }

    public static void consultarProdutos() {
        System.out.println("Listando produtos... \n\n");
        for (int j = 0; j < produtos.length; j++) {
            if (produtos[j] != null) {
                System.out.println(produtos[j]);
            }
        }
    }
}





