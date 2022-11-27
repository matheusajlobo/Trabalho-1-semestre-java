package application;

import entite.Funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Funcionarios> funcionarios = new ArrayList<>(); // declaração da lista da classe Funcionarios
        int userChoice;
        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n", "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - SAIR");
        do {//loop para repetição do menu
            System.out.println();
            userChoice = input.nextInt();
            switch (userChoice) { //estrutura condicional para naveação do menu
                case 1:
                    System.out.printf("%nDigite o numero da matricula: ");
                    int matricula = input.nextInt();
                    input.nextLine();
                    System.out.printf("Digite o nome: ");
                    String nome = input.nextLine();
                    System.out.printf("Digite o cargo: ");
                    String cargo = input.nextLine();
                    System.out.printf("Digite o setor: ");
                    String setor = input.nextLine();
                    System.out.printf("Digite a remuneração: ");
                    double remuneracao = input.nextDouble();
                    funcionarios.add(new Funcionarios(matricula, nome, cargo, setor, remuneracao));
                    break;
                case 2:/* imprime elementos da lista em formato tabelado */
                    if (funcionarios != null) {
                        System.out.format("%n%-20s%-20s%-20s%n","MATRICULA", "NOME", "CARGO");
                        for (Funcionarios list : funcionarios) {
                            System.out.format("%-20s%-20s%-20s%n", list.getMatricula(), list.getNome(), list.getCargo());
                        }
                    } else {
                        System.out.println("NENHUM FUNCIONARIO CADASTRADO!!");
                    }
                    break;
                case 3:/*realiza uma busca na lista atravez de uma expressão lambda*/
                    if (funcionarios != null) {
                        System.out.println("Digite o numero da matricula: ");
                        int matBusca = input.nextInt();
                        /* converte a list pra stream, realiza uma operação lambda e retorna para list*/
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).collect(Collectors.toList());
                        System.out.printf("%s",resultado);
                    } else
                        System.out.println("NENHUM FUNCIONARIO CADASTRADO!!");
                    break;
                case 4:/* realiza uma busca atravez de uma expressão lambda e exclui o item correspondente*/
                    if (funcionarios != null) {
                        System.out.println("Digite o numero da matricula: ");
                        int matBusca = input.nextInt();
                        funcionarios.removeIf(x -> x.getMatricula() == matBusca);
                    } else
                        System.out.println("NENHUM FUNCIONARIO CADASTRADO!!");

                default:
                    System.out.println("Digite um comando valido!");
                    break;

            }
            System.out.format("%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n%-10s%n", "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - SAIR");
        } while (userChoice != 5);
        System.out.println("Sistema encerrado pelo Usuario");

        input.close();
    }
}