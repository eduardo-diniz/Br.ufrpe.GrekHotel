/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel;
import br.ufrpe.GrekHotel.Negocio.*;
import br.ufrpe.GrekHotel.beans.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fight
 */
public class Principal {
    
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Scanner ler = new Scanner(System.in);
        boolean status = true;
        boolean entrou = false;
        Cliente c = null;
        Funcionario f = null;
        while(status == true){
            while(entrou == false){
                System.out.println("GrekHotel");
                System.out.println("1 - Cadastrar-se");
                System.out.println("2 - Entrar");
                System.out.println("3 - Encerrar Sistema");
                int opcao = ler.nextInt();
                ler.nextLine();
                if(opcao == 1){
                    System.out.println("Login: ");
                    String login = ler.nextLine();
                    System.out.println("Senha: ");
                    String senha = ler.nextLine();
                    System.out.println("Nome: ");
                    String nome = ler.nextLine();
                    System.out.println("Idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Cpf: ");
                    long cpf = ler.nextLong();
                    ler.nextLine();
                    c = new Cliente(login, senha, nome, idade, cpf);
                    sistema.cadastrarUsuario(c);
                    entrou = true;
                }
                else if(opcao == 2){
                    System.out.println("Login: ");
                    String login = ler.nextLine();
                    System.out.println("Senha: ");
                    String senha = ler.nextLine();
                    Usuario u = sistema.efetuarLogin(login, senha);
                    if(u != null){
                        if(u instanceof Cliente){
                        c = (Cliente) u;
                        }
                        else if(u instanceof Funcionario){
                            f = (Funcionario) u;
                        }
                        entrou = true;
                    }
                }
                else if(opcao == 3){
                    entrou = true;
                    status = false;
                }
                else{
                    System.out.println("Opcao invalida");
                }
            }
            while(c != null){
                if(sistema.procurarReserva(c) == null){
                    System.out.println("1 - Fazer Reserva");
                    System.out.println("2 - Sair");
                    int opcao = ler.nextInt();
                    ler.nextLine();
                    if(opcao == 1){
                        System.out.println(sistema.listarQuartos());
                        System.out.println("Numero do Quarto: ");
                        int numero = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Data Prevista para Check-In");
                        System.out.println("Ano: ");
                        int ano = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Mes: ");
                        int mes = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Dia: ");
                        int dia = ler.nextInt();
                        ler.nextLine();
                        LocalDate checkInP = LocalDate.of(ano, mes, dia);
                        System.out.println("Data Prevista para Check-Out");
                        System.out.println("Ano: ");
                        ano = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Mes: ");
                        mes = ler.nextInt();
                        ler.nextLine();
                        System.out.println("Dia: ");
                        dia = ler.nextInt();
                        ler.nextLine();
                        LocalDate checkOutP = LocalDate.of(ano, mes, dia);
                        Reserva reserva = new Reserva(sistema.procurarQuarto(numero), c, checkInP, checkOutP);
                        sistema.Reservar(reserva);
                    }
                    else if(opcao == 2){
                        c = null;
                        entrou = false;
                    }
                }
                else if(sistema.procurarReserva(c).getVisita() == null){
                    System.out.println("1 - Cancelar Reserva");
                    System.out.println("2 - Realizar Check-In");
                    System.out.println("3 - Sair");
                    int opcao = ler.nextInt();
                    ler.nextLine();
                    if(opcao == 1){
                        sistema.cancelarReserva(sistema.procurarReserva(c));
                    }
                    else if(opcao == 2){
                        sistema.checkIn(sistema.procurarReserva(c));
                    }
                    else if(opcao == 3){
                        c = null;
                        entrou = false;
                    }
                }
                else if(sistema.procurarReserva(c).getVisita() != null){
                    System.out.println("1 - Realizar Check-Out");
                    System.out.println("2 - Sair");
                    int opcao = ler.nextInt();
                    ler.nextLine();
                    if(opcao == 1){
                        sistema.checkOut(sistema.procurarReserva(c));
                    }
                    else if(opcao == 2){
                        c = null;
                        entrou = false;
                    }
                }


            }
            while(f != null){
                System.out.println("1 - Cadastrar Quarto");
                System.out.println("2 - Sair");
                int opcao = ler.nextInt();
                ler.nextLine();

                if(opcao == 1){
                    System.out.println("Descricao: ");
                    String descricao = ler.nextLine();
                    System.out.println("Diaria: ");
                    double diaria = ler.nextDouble();
                    ler.nextLine();
                    System.out.println("Numero do Quarto: ");
                    int numero = ler.nextInt();
                    ler.nextLine();
                    Quarto quarto = new Quarto(descricao, diaria, numero);
                    sistema.cadastrarQuarto(quarto);
                }
                else if(opcao == 2){
                    f= null;
                    entrou = false;
                }


            }
        }
    }
}
