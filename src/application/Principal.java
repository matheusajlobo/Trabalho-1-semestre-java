package application;

import entite.Dependentes;
import entite.Funcionarios;

import java.util.*;

public class Principal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // instanciando o Scanner

        List<Funcionarios> funcionarios = new ArrayList<>(); // declaração da lista da classe Funcionarios

        int userChoice; // variable para armazenar o input do usuário

        // Implementação de dados para teste
        funcionarios.add(new Funcionarios(127222, "Amanda Cerqueira", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127223, "Diego Silva", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127224, "Mateus Catureba", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127225, "Matheus Lobo", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127226, "Rafael Bastos", "Estudante", "TI", 0.00));
        funcionarios.add(new Funcionarios(127227, "Gerferson Bittencourt", "Professor", "TI", 6734.00));
        funcionarios.add(new Funcionarios(127228, "David Santiago", "Professor", "TI", 4580.00));
        System.out.format("%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n",
                "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - ATUALIZAR ", "6 - ORDENAR","7 - SAIR");
        do {//loop para repetição do menu

            System.out.println();
            userChoice = input.nextInt();

            switch (userChoice) { // estrutura condicional para naveação do menu

                case 1:// recebe dados e cadastra o item na lista
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
                    System.out.println("O funcionario possui dependentes?...(y/n)");
                    char userChoice_1 = input.next().charAt(0);
                    if(userChoice_1 =='y'|| userChoice_1=='Y'){ // estrutura condicional com tratamento de dados para verificar se o usuário possui dependentes
                        System.out.print("\nDigite o id do dependente: ");
                        int idDep = input.nextInt();
                        input.nextLine();
                        System.out.print("\nDigite o nome do dependente: ");
                        String nomeDep = input.nextLine();
                        System.out.print("\nDigite a idade do dependente: ");
                        int idadeDep = input.nextInt();
                        input.nextLine();
                        System.out.print("\nDigite o grau de parentesco do dependente: ");
                        String parentesco = input.nextLine();
                        funcionarios.add(new Dependentes(matricula,nome,cargo,setor,remuneracao,idDep,nomeDep,parentesco,idadeDep));

                    } else if (userChoice_1=='n'||userChoice_1=='N') {
                        funcionarios.add(new Funcionarios(matricula, nome, cargo, setor, remuneracao));
                    }
                    break;


                case 2:/* imprime elementos da lista em formato tabelado */
                    if (!funcionarios.isEmpty()) {//condicional para saber se a lista contém itens cadastrados.
                        System.out.format("%n%-15s%-25s%-20s%n", "MATRICULA", "NOME", "CARGO");
                        for (Funcionarios list : funcionarios) {//foreach para percorera lista
                            System.out.format("%-15s%-25s%-20s%n", list.getMatricula(), list.getNome(), list.getCargo());
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 3:/*realiza uma busca na lista através de uma expressão lambda*/
                    System.out.print("\nDigite o numero da matricula: ");
                    int matBusca = input.nextInt();
                    if (!funcionarios.isEmpty()) {
                        /* converte a list pra stream, realiza uma operação lambda e retorna para list*/
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).toList();
                        if (!resultado.isEmpty()) {//condicional para saber se o resultado da busca é valido!
                            System.out.printf("%n%s%n", resultado);
                        } else {
                            System.out.println("Item não encontrado!");
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 4:/* realiza uma busca atravez de uma expressão lambda e exclui o item correspondente*/
                    System.out.println("Digite o numero da matricula: ");
                    matBusca = input.nextInt();
                    if (!funcionarios.isEmpty()) {
                        //busca o número do item digitado, ultilizado para verificar a existencia do item.
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).toList();
                        if (!resultado.isEmpty()) {//
                            System.out.println("Deseja realmente excluir esse item?...(s/n)");
                            char userChoice1 = input.next().charAt(0);
                            if (userChoice1 == 's') {
                                //expressão responsavel pela exclusão do item
                                funcionarios.removeIf(x -> x.getMatricula() == matBusca);
                                System.out.println("Item retirado com sucesso!");
                            } else {
                                System.out.println("Item não retirado!");
                            }
                        } else {
                            System.out.println("Item não encontrado!");
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 5: //Modificar itens da Lista
                    System.out.println("Digite o numero de maticula");
                    matricula = input.nextInt();
                    /*Condicionais para verificar se a lista está vazia,e se existe o item a ser modificado*/
                    if (!funcionarios.isEmpty()) {
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matricula).toList();
                        if (!resultado.isEmpty()) {
                            for (Funcionarios list : funcionarios) {
                                if (list.getMatricula().equals(matricula)) {
                                    int userChoice_2;
                                    System.out.printf("Aterações na matricula: %d%n", list.getMatricula());
                                    System.out.println("O que deseja atualizar: ");
                                    System.out.printf("%n%s  %s  %s  %s %s%n", "1 - NOME", "2 - CARGO", "3 - SETOR", "4 - REMUNERAÇÃO", "5 - SAIR");

                                    do {// Loop para menu de escolha de itens a ser modificado.
                                        System.out.println();
                                        userChoice_2 = input.nextInt();
                                        input.nextLine();
                                        switch(userChoice_2) {
                                            case 1 -> {
                                                System.out.print("\nDigite o novo nome: ");
                                                String newName = input.nextLine();
                                                list.setNome(newName);
                                                System.out.printf("%nO novo nome é: %s%n", list.getNome());
                                            }
                                            case 2-> {
                                                System.out.print("\nDigite o novo cargo: ");
                                                String newCargo = input.nextLine();
                                                list.setCargo(newCargo);
                                                System.out.printf("%nO novo cargo é: %s%n", list.getCargo());
                                            }
                                            case 3 -> {
                                                System.out.print("\nDigite o novo setor: ");
                                                String newSetor = input.nextLine();
                                                list.setSetor(newSetor);
                                                System.out.printf("%nO novo setor é: %s%n", list.getSetor());
                                            }
                                            case 4 -> {
                                                System.out.print("\nDigite o novo salario: ");
                                                double newRemuneracao = input.nextDouble();
                                                list.setRemuneracao(newRemuneracao);
                                                System.out.printf("%nO novo salario é: %s%n", list.getRemuneracao());
                                            }
                                            case 5 ->
                                                System.out.printf("%nAtualização na Matricula %d finalizada!%n", list.getMatricula());


                                            default ->
                                                System.out.println("Digite um comando valido!");

                                        }
                                        if (userChoice_2 != 5) {
                                            System.out.printf("Auterações na matricula: %d%n", list.getMatricula());
                                            System.out.printf("%n%s  %s  %s  %s %s  %n", "1 - NOME", "2 - CARGO", "3 - SETOR", "4 - REMUNERAÇÃO", "5- SAIR");
                                        }
                                    }while (userChoice_2!=5);
                                }
                            }
                        } else {
                            System.out.println("Item não encontrado!");
                        }
                    }else{
                    System.out.println("Sem itens cadastrados!");
                }
                break;
                case 6:// Organizar e exibir a lista por ordem numerica ou alfabetica
                    if (!funcionarios.isEmpty()) {//condicional para saber se a lista contém itens cadastrados.
                        System.out.println("Como deseja ordenar: Nome ou Matricula?...(n/m)");
                        char userChoice1 = input.next().charAt(0);
                        if (userChoice1 == 'n'|| userChoice1 == 'N') {
                            Collections.sort(funcionarios);//metodo Collections.sort() recebe uma lista do objeto Funcionarios
                        } else if (userChoice1 == 'm'|| userChoice1 == 'M') {
                            funcionarios.sort(Comparator.comparing(Funcionarios::getMatricula));
                        }
                        System.out.format("%n%-15s%-25s%-20s%n", "MATRICULA", "NOME", "CARGO");
                        for (Funcionarios list : funcionarios) {//foreach para percorera lista
                            System.out.format("%-15s%-25s%-20s%n", list.getMatricula(), list.getNome(), list.getCargo());
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 7:
                    System.out.println("Obrigado!");
                    break;

                default:
                    System.out.println("Digite um comando valido!"); // tratando erro de input do usuário
                    break;
            }
            if (userChoice != 7) {
                System.out.format("%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n",
                        "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - ATUALIZAR ","6 - ORDENAR", "7 - SAIR");
            }
        } while (userChoice != 7);
        System.out.println("Sistema encerrado pelo Usuario"); // informando o termino do programa

        input.close();
    }
}