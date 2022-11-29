package application;

import entite.Funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Funcionarios> funcionarios = new ArrayList<>(); // declaração da lista da classe Funcionarios
        int userChoice;

        // Implementação de dados para teste
        funcionarios.add(new Funcionarios(127222, "Amanda Cerqueira", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127223, "Diego Silva", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127224, "Mateus Catureba", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127225, "Matheus Lobo", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127226, "Rafael Bastos", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127227, "Gerferson Bittencourt", "Professor", "TI", 6734.00));
        funcionarios.add(new Funcionarios(127228, "David Santiago", "Professor", "TI", 4580.00));
        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n", "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - SAIR");

        do {//loop para repetição do menu

            System.out.println();
            userChoice = input.nextInt();

            switch (userChoice) { //estrutura condicional para naveação do menu

                case 1://recebe dados e cadastra o item na lista
                    System.out.print("\nDigite o numero da matricula: ");
                    int matricula = input.nextInt();
                    input.nextLine();
                    System.out.print("\nDigite o nome: ");
                    String nome = input.nextLine();
                    System.out.print("\nDigite o cargo: ");
                    String cargo = input.nextLine();
                    System.out.print("\nDigite o setor: ");
                    String setor = input.nextLine();
                    System.out.print("\nDigite a remuneração: ");
                    double remuneracao = input.nextDouble();
                    funcionarios.add(new Funcionarios(matricula, nome, cargo, setor, remuneracao));
                    break;

                case 2:/* imprime elementos da lista em formato tabelado */
                    if (!funcionarios.isEmpty()) {//condicional para saber se a lista contém itens cadastrados.
                        System.out.format("%n%-15s%-25s%-20s%n", "MATRICULA", "NOME", "CARGO");
                        for (Funcionarios list : funcionarios) {//foreach para percorera lista
                            System.out.format("%-15s%-25s%-20s%n", list.getMatricula(), list.getNome(), list.getCargo());
                        }
                    }else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 3:/*realiza uma busca na lista atravez de uma expressão lambda*/
                    System.out.println("Digite o numero da matricula: ");
                    int matBusca = input.nextInt();
                    if(!funcionarios.isEmpty()){
                            /* converte a list pra stream, realiza uma operação lambda e retorna para list*/
                            List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).toList();
                            if (!resultado.isEmpty()){//condicional para saber se o resultado da busca é valido!
                                System.out.printf("%n%s%n",resultado);
                        }else {
                                System.out.println("Item não encontrado!");
                        }
                    }else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 4:/* realiza uma busca atravez de uma expressão lambda e exclui o item correspondente*/
                    System.out.println("Digite o numero da matricula: ");
                    matBusca = input.nextInt();
                    if (!funcionarios.isEmpty()) {
                        //busca o numero do item digitado, ultilizado para verificar a existencia do item.
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).toList();
                        if (!resultado.isEmpty()){//
                            System.out.println("Deseja realmente excluir esse item?...(s/n)");
                            char userChoice1 = input.next().charAt(0);
                            if (userChoice1 == 's') {
                                //expressão responsavel pela exclusão do item
                                funcionarios.removeIf(x -> x.getMatricula() == matBusca);
                                System.out.println("Item retirado com sucesso!");
                            }else {
                                System.out.println("Item não retirado!");
                            }
                        }else {
                            System.out.println("Item não encontrado!");
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 5:
                    System.out.println("Obrigado!");
                    break;

               /* case : modificar itens da lista (em andamento)

                    matricula = input.nextInt();
                    for (Funcionarios list: funcionarios) {
                        if (list.getMatricula().equals(matricula))
                    }*/

                default:
                    System.out.println("Digite um comando valido!");
                    break;

            }
            if (userChoice!=5) {
                System.out.format("%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n", "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - SAIR");
            }
        } while (userChoice != 5);
        System.out.println("Sistema encerrado pelo Usuario");

        input.close();
    }
}