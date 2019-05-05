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
        ControladorAdm controlAdm = ControladorAdm.getInstance();
        ControladorUsuario controlUsuario = ControladorUsuario.getInstance();
        ControladorReservas controlReservas = ControladorReservas.getInstance();
        
        
        Scanner ler = new Scanner(System.in);
        
        
        System.out.println("Login");
        System.out.println("Login: ");
        String login = ler.nextLine();
        System.out.println("Senha: ");
        String senha = ler.nextLine();
        Usuario usuario = controlUsuario.efetuarLogin(login, senha);
        if(usuario == null){
            System.out.println("Usuario ou senha incorretos");
        }
        Funcionario f = null;
        Cliente c = null;
        if(usuario instanceof Cliente){
            System.out.println("Usuario é um cliente");
            c = (Cliente) usuario;
            
        }
        else if(usuario instanceof Funcionario){
            System.out.println("Usuario é um Funcionario");
            f = (Funcionario) usuario;
        }
        if(f != null){
            System.out.println("Cadastrar Quarto");
            String descricao = ler.nextLine();
            double diaria = ler.nextDouble();
            ler.nextLine();
            int num = ler.nextInt();
            ler.nextLine();
            Quarto novo = new Quarto(descricao, diaria, num);
            controlAdm.cadastrarQuarto(novo);
        }
        
        
        
        System.out.println("Cadastrar Cliente");
        System.out.println("Login: ");
        login = ler.nextLine();
        System.out.println("Senha: ");
        senha = ler.nextLine();
        System.out.println("Nome: ");
        String nome = ler.nextLine();
        System.out.println("Idade: ");
        int idade = ler.nextInt();
        ler.nextLine();
        System.out.println("Cpf: ");
        long cpf = ler.nextLong();
        ler.nextLine();
        Cliente novo = new Cliente(login, senha, nome, idade, cpf);
        if(!controlUsuario.cadastrarUsuario(novo)){
            System.out.println("Não foi possivel cadastrar-se");
        }
        
        System.out.println("Login");
        System.out.println("Login: ");
        login = ler.nextLine();
        System.out.println("Senha: ");
        senha = ler.nextLine();
        usuario = controlUsuario.efetuarLogin(login, senha);
        if(usuario == null){
            System.out.println("Usuario ou senha incorretos");
        }
        
        if(usuario instanceof Cliente){
            System.out.println("Usuario é um cliente");
            c = (Cliente) usuario;
        }
        System.out.println("Fazer reserva");
        ArrayList<Quarto> quartos = controlReservas.listarQuartos();
        Quarto quarto = quartos.get(0);
        Reserva reserva = new Reserva(quarto, c, LocalDate.now(), LocalDate.of(2019,6,10));
        controlReservas.Reservar(reserva);
        
    }
}
