package main;

import com.sgp.modelos.Carro;
import com.sgp.util.Validacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Carro> carros = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Carros!");

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    removerCarro();
                    break;
                case 3:
                    listarCarros();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

 /*menu */

    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastrar carro");
        System.out.println("2 - Remover carro");
        System.out.println("3 - Listar carros");
        System.out.println("0 - Sair");
    }
/*cadastrar */

    private static void cadastrarCarro() {
        System.out.println("\n--- CADASTRO ---");

        String modelo;
        do {
            System.out.print("Modelo: ");
            modelo = scanner.nextLine();
            System.out.println(Validacoes.mensagemErroModelo(modelo));
        } while (!Validacoes.modeloValido(modelo));

        int ano;
        do {
            ano = lerInteiro("Ano: ");
            System.out.println(Validacoes.mensagemErroAno(ano));
        } while (!Validacoes.anoValido(ano));

        double velocidade;
        do {
            velocidade = lerDouble("Velocidade (km/h): ");
            System.out.println(Validacoes.mensagemErroVelocidade(velocidade));
        } while (!Validacoes.velocidadeValida(velocidade));

        Carro carro = new Carro(modelo, ano, velocidade);
        carros.add(carro);

        System.out.println("Carro cadastrado com sucesso!");
    }

  /*remover */

    private static void removerCarro() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        listarCarros();

        int indice = lerInteiro("Escolha o número para remover: ") - 1;

        if (indice >= 0 && indice < carros.size()) {
            Carro removido = carros.remove(indice);
            System.out.println("Removido: " + removido.getModelo());
        } else {
            System.out.println("Índice inválido!");
        }
    }

    /*listar */

    private static void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA ---");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println((i + 1) + " - " + carros.get(i));
        }
    }

    

    private static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}