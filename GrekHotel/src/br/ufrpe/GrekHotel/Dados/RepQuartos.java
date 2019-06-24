/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author fight
 */
public class RepQuartos {

    private ArrayList<Quarto> quartos;

    private static RepQuartos instance;

    private File f;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private RepQuartos() {
        f = new File("Quartos Database");
        if (!f.exists()) {
            try {
                f.createNewFile();
                quartos = new ArrayList();
                salvar();
            } catch (IOException e) {

            }
        } else {
            carregar();
        }
    }

    public static RepQuartos getInstance() {
        if (instance == null) {
            RepQuartos.instance = new RepQuartos();
        }

        return instance;
    }

    public void cadastrar(Quarto quar) throws CQException {
        if (!this.quartos.contains(quar)) {

            quartos.add(quar);
            salvar();
        } else {
            CQException aqe = new CQException("quarto já cadastrado");
            throw aqe;
        }
    }

    public Quarto procurar(int numero) {
        Quarto q = null;
        for (Quarto qua : quartos) {
            if (qua.getNumero() == (numero)) {

                q = qua;

            }
        }
        return q;
    }

    public ArrayList lista() {
        return quartos;
    }

    public void atualizar(Quarto desatualizado, Quarto atualizado) throws AQException {
        if (!quartos.contains(atualizado) && quartos.contains(desatualizado)) {
            quartos.set(quartos.indexOf(desatualizado), atualizado);
            salvar();
        } else if (quartos.contains(atualizado)) {
            AQException aqe = new AQException("o quarto novo já existe");
            throw aqe;
        } else {
            AQException aqe = new AQException("o quarto antigo não existe");
            throw aqe;
        }

    }

    public void remover(Quarto quartoRem) throws RQException {

        if (this.quartos.contains(quartoRem)) {

            quartos.remove(quartoRem);
            salvar();
        } else {
            RQException rqe = new RQException("quarto não cadastrado");
            throw rqe;
        }

    }

    private void InicializeOutStreams() {
        try {
            fos = new FileOutputStream(f, false);
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {

        }
    }

    private void InicializeInStreams() {
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {

        }
    }

    public void salvar() {
        try {
            InicializeOutStreams();
            oos.writeObject(quartos);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }
    }

    private void carregar() {
        try {
            quartos = new ArrayList();
            f = new File("Quartos Database");
            InicializeInStreams();
            quartos.addAll((ArrayList<Quarto>) ois.readObject());
            ois.close();
            fis.close();

        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }
    }

}
