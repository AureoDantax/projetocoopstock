package servico;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ImplementaServico {

    public static int tamanhoEstoque = defineTamanhoEstoque();
    public static String[] produtos = new String[tamanhoEstoque];
    public static int[] qtdProduto = new int[tamanhoEstoque];

    public static int defineTamanhoEstoque() {
        Scanner input = new Scanner(System.in);
        System.out.println("Quantas vagas para cadastro haverá no estoque? Cada vaga receberá o produto e sua quantidade. ");
        int espacoEstoque = input.nextInt();
        System.out.println("Beleza! Seu estoque possuí " + espacoEstoque + " vaga(s)");
        return espacoEstoque;
    }

    public static void cadastraProduto() {

        int numCadastros = 0, i, qtd;

        Scanner input = new Scanner(System.in);

        System.out.println("Quantos produtos vão ser cadastrados?");
        numCadastros = input.nextInt();

        if (numCadastros > tamanhoEstoque) {
            System.out.println("Não há espaço no estoque para o numero de produtos informados, existe " + produtos.length +
                               " vagas para cadastro\n\n");
            cadastraProduto();
        } else {

            for (i = 0; i < numCadastros; i++) {
                System.out.println("Digite o nome do produto");
                /* o next line tem uma limitação que não pega dependendo da situação pega apenas o texto da proxima linha
               necessitando utilizar dois, nesse caso
                 */
                input.nextLine();
                String produto = input.nextLine();
                System.out.println();
                produtos[i] = produto;


                System.out.println("Digite quantidade");
                qtdProduto[i] = input.nextInt();
            }
            System.out.println("Produtos cadastrados com sucesso!");
        }
    }

    public static void listaProdutos() {
        System.out.println("Listando produtos... \n");
        for (int j = 0; j < produtos.length; j++) {
            if (produtos[j] != null) {
                /* para não apresentar a posição 0 para o usuario, foi feit
                 uma simples modificação no valor apresentado, para deixar mais visual */
                int formataVaga = j + 1;
                System.out.print("Vaga " + formataVaga + " - Produto: " + produtos[j] + " - " + "Qtd: "
                                 + qtdProduto[j] + " unidades\n");


            }
        }
    }

    public static void editaCadastro() {
        Scanner input = new Scanner(System.in);
        System.out.println("você deseja editar qual produto?\n");

        listaProdutos();

        /*por cont da melhoria para apresentação no metodo de listagem, foi necessario retirar
         o 1 somado na hora de editar o produto, para não pular posições */
        int vagaEstoque = input.nextInt() - 1;

        if (vagaEstoque <= produtos.length) {
            System.out.println("digite 1 para editar o nome, digite 2 para editar a quantidade ou 3 para ambos");

            int op = input.nextInt();
            switch (op) {
                case 1 -> {
                    editaNome(vagaEstoque);
                    //exibindo produtos depois de editado
                    listaProdutos();
                }

                case 2 -> {
                    editaQtd(vagaEstoque);
                    //exibindo produtos depois de editado
                    listaProdutos();
                }

                case 3 -> {
                    editaNome(vagaEstoque);
                    editaQtd(vagaEstoque);
                    //exibindo produtos depois de editado
                    listaProdutos();
                }

                default -> System.out.println("Opção inválida! Digte um número entre um e 3");
            }
        }
    }

    public static void editaNome(int vagaEstoque) {
        String novoNome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o novo nome:");
        novoNome = input.nextLine();
        produtos[vagaEstoque] = novoNome;
        System.out.println("Pronto, nome alterado com sucesso\n");
    }

    public static void editaQtd(int vagaEstoque) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a nova Quantidade");
        int novaQtd = input.nextInt();
        qtdProduto[vagaEstoque] = novaQtd;
        System.out.println("Pronto, quantidade atualizada com sucesso!\n");
    }
}







