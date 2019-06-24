/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

;

public class RepReservas {

    private ArrayList<Reserva> reservas;
    private static RepReservas instance;

    private File f;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private RepReservas() {

        //reservas = new ArrayList();
        f = new File("Reservas Database");
        if (!f.exists()) {
            try {
                f.createNewFile();
                reservas = new ArrayList();
                salvar();
            } catch (IOException e) {

            }
        }else {
            carregar();
        }
    }

    public static RepReservas getInstance() {
        if (instance == null) {
            instance = new RepReservas();

        }
        return instance;
    }

    public void cadastrar(Reserva reserv) throws CRException {
        if (reserv.getQuarto().getSituacao() == 1) {
            if (!this.reservas.contains(reserv)) {
                reserv.getQuarto().setSituacao(2);
                reservas.add(reserv);
            } else {
                CRException are = new CRException("reserva já existe");
                throw are;
            }
        } else {
            CRException are = new CRException("quarto ocupado");
            throw are;
        }
    }

    public Reserva procurar(Quarto quarto) {
        Reserva encontrado = null;
        for (Reserva i : reservas) {
            if (i.getQuarto().equals(quarto)) {

                encontrado = i;
            }
        }
        return encontrado;
    }

    public Reserva procurar(Cliente hospede) {
        Reserva encontrado = null;
        for (Reserva j : reservas) {
            if (j.getCliente().equals(hospede)) {

                encontrado = j;
            }

        }
        return encontrado;
    }

    public void atualizar(Reserva desatualizado, Reserva atualizado) throws ARException {
        if (reservas.contains(desatualizado) && !reservas.contains(atualizado)) {
            reservas.set(reservas.indexOf(desatualizado), atualizado);
        } else if (reservas.contains(atualizado)) {
            ARException are = new ARException("quarto já reservado");
            throw are;

        } else {
            ARException are = new ARException("reserva antiga não existe");
            throw are;
        }
    }

    public boolean remove(Reserva reserva) throws RRException {
        boolean resultado = false;

        if (this.reservas.contains(reserva)) {

            resultado = true;
            reservas.remove(reserva);
            reserva.getQuarto().setSituacao(1);
        } else {
            RRException rre = new RRException("reserva não existe");
            throw rre;
        }
        return resultado;

    }
    
    private void InicializeOutStreams() {
        try {
            fos = new FileOutputStream(f,false);
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {

        }
    }
    private void InicializeInStreams(){
        try{
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
        }catch(IOException e){
            
        }
    }
    public void salvar(){
        try{
            InicializeOutStreams();
            oos.writeObject(reservas);
            oos.flush();
            oos.close();    
            fos.flush();
            fos.close();
        }catch(IOException e){
            
        }
    }

    private void carregar(){
        try {
            reservas = new ArrayList();
            f = new File("Reservas Database");
            InicializeInStreams();
            reservas.addAll((ArrayList<Reserva>) ois.readObject());
            ois.close();
            fis.close();
            
        } catch (ClassNotFoundException e) {

        }catch(IOException e){

        }
    }
}
