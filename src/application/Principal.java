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
        funcionarios.add(new Funcionarios(127227, "Geferson Bittencurt", "Professor", "TI", 6734.00));

        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n", "MENU#", "1 - CADASTRAR", "2 - LISTAR", "3 - BUSCAR", "4 - EXCLUIR", "5 - SAIR");

        do {//loop para repetição do menu

            System.out.println();
            userChoice = input.nextInt();

            switch (userChoice) { //estrutura condicional para naveação do menu

                case 1://recebe dados e cadastra o item na lista
                    System.out.printf("%nDigite o numero da matricula: ");
                    int matricula = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o nome: ");
                    String nome = input.nextLine();
                    System.out.println("Digite o cargo: ");
                    String cargo = input.nextLine();
                    System.out.println("Digite o setor: ");
                    String setor = input.nextLine();
                    System.out.println("Digite a remuneração: ");
                    double remuneracao = input.nextDouble();
                    funcionarios.add(new Funcionarios(matricula, nome, cargo, setor, remuneracao));
                    break;

                case 2:/* imprime elementos da lista em formato tabelado */
                    if (!funcionarios.isEmpty()) {
                        System.out.format("%n%-15s%-25s%-20s%n", "MATRICULA", "NOME", "CARGO");
                        for (Funcionarios list : funcionarios) {
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
                            if (!resultado.isEmpty()){
                                System.out.printf("%n%s%n",resultado);
                        }else {
                                System.out.println("Item não caadastrado");
                        }
                    }else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 4:/* realiza uma busca atravez de uma expressão lambda e exclui o item correspondente*/
                    System.out.println("Digite o numero da matricula: ");
                    matBusca = input.nextInt();
                    if (!funcionarios.isEmpty()) {
                        List<Funcionarios> resultado = funcionarios.stream().filter(x -> x.getMatricula() == matBusca).toList();
                        if (!resultado.isEmpty()){
                            funcionarios.removeIf(x -> x.getMatricula() == matBusca);
                            System.out.println("Item retirado com sucesso!");
                        }else {
                            System.out.println("Item não cadastrado!");
                        }
                    } else
                        System.out.println("Sem itens cadastrados!");
                    break;

                case 5:
                    System.out.println("Obrigado!");
                    break;

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