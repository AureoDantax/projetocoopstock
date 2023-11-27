package servico;

import java.util.Scanner;

import static coopstock.Main.menu;

public class ImplementaServico {

    public static int tamanhoEstoque = defineTamanhoEstoque();
    public static String[] produtos = new String[tamanhoEstoque];
    public static int[] qtdProduto = new int[tamanhoEstoque];

    public static int defineTamanhoEstoque() {

        System.out.println("Você ainda não criou seu Estoque de produtos, vamos cria-lo agora?\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Quantas vagas para cadastro haverá no estoque? Cada vaga receberá o produto e sua quantidade. ");
        int espacoEstoque = input.nextInt();
        System.out.println("Beleza! Seu estoque possuí " + espacoEstoque + " vaga(s)\n");
        return espacoEstoque;
    }

    public static void cadastraProduto() {

        Scanner input = new Scanner(System.in);
        int numCadastros = 0, i, qtd;

        for (int pos = 0; pos < tamanhoEstoque; pos++) {
            if (produtos[pos] != null) {
                System.out.println("Seu estoque já está cheio, é necessário remover um produto");
                removeProduto();
            }
        }
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
                qtd = input.nextInt();
                qtdProduto[i] = qtd;
            }
            System.out.println("Produto(s) cadastrado(s) com sucesso!");
        }
    }

    public static void listaProdutos() {

        System.out.println("Lista de produtos... \n");
        for (int j = 0; j < produtos.length; j++) {

            if (produtos[j] != null) {
                /* para não apresentar a posição 0 para o usuario, foi feit
                 uma simples modificação no valor apresentado, para deixar mais visual */
                int formataVaga = j + 1;
                System.out.print("Vaga " + formataVaga + " - Produto: " + produtos[j] + " - " + "Qtd: "
                                 + qtdProduto[j] + " unidade(s)\n");

            }

        }

    }

    public static void editaCadastro() {

        Scanner input = new Scanner(System.in);
        int vagaEstoque;

        listaProdutos();
        System.out.println("Você deseja editar qual produto?\n");


        vagaEstoque = input.nextInt();

        if (vagaEstoque > 0 && vagaEstoque <= tamanhoEstoque) {
            System.out.println("Digite 1 para editar o nome, digite 2 para editar a quantidade ou 3 para ambos");

            /*por conta da melhoria para apresentação no metodo de listagem, foi necessario retirar
         o 1 somado na hora de editar o produto, para não pular posições */
            vagaEstoque--;
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

                default -> System.out.println("Opção inválida! Voltando ao menu");
            }
        } else {
            System.out.println("Essa vaga não existe, por favor escolha outra vaga");
            editaCadastro();
        }
    }

    public static void editaNome(int vagaEstoque) {

        Scanner input = new Scanner(System.in);
        String novoNome;

        System.out.println("Digite o novo nome:");
        novoNome = input.nextLine();
        produtos[vagaEstoque] = novoNome;
        System.out.println("Pronto, nome alterado com sucesso\n");
    }

    public static void editaQtd(int vagaEstoque) {

        Scanner input = new Scanner(System.in);
        int novaQtd;

        System.out.println("Digite a nova quantidade em forma numeral");
        novaQtd = input.nextInt();

        qtdProduto[vagaEstoque] = novaQtd;
        System.out.println("Pronto, quantidade atualizada com sucesso!\n");
        
    }

    public static void removeProduto() {

        Scanner input = new Scanner(System.in);
        int pos;

        listaProdutos();
        System.out.println("Digite o número da vaga do produto que você deseja remover");

        /*por conta da melhoria para apresentação no metodo de listagem, foi necessario retirar
         o 1 somado na hora de editar o produto, para não pular posições */
        pos = input.nextInt() - 1;

        if (pos > tamanhoEstoque || pos < 1) {
            System.out.println("Essa vaga não existe, por favor escolha outra vaga");
            removeProduto();
        }
        if (produtos[pos] != null) {
            produtos[pos] = null;
            qtdProduto[pos] = 0;
            System.out.println("Produto Removido com sucesso");
        } else {
            System.out.println("Não é possível remover um produto nessa vaga, por favor escolha outra vaga");
            removeProduto();
        }
    }

    public static void verificaVetorVazio() {

        int posicaoNula = 0;
        for (int i = 0; i < tamanhoEstoque; i++) {
            if (produtos[i] == null)
                posicaoNula++;


        }
        if (posicaoNula == tamanhoEstoque) {
            System.out.println("Você ainda não cadastrou nenhum produto, deseja cadastrar agora?\nDigite Sim para cadastrar ou Não para voltar ao menu");
            Scanner input = new Scanner(System.in);
            String op = input.next();
            if (op.equals("Sim") || op.equals("sim")) {
                cadastraProduto();
            } else if (op.equals("Não") || op.equals("não") || op.equals("nao") || op.equals("Nao")) {
                System.out.println("Ok, vamos ao Menu");
                menu();
            } else {
                System.out.println("Não entendi, vou te levar ao menu...");
                menu();
            }
        }
    }

}








