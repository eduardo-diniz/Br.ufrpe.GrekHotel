package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RepServicos {

    private ArrayList<Servico> servicos;
    private static RepServicos instance;

    private File f;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private RepServicos() {
        f = new File("Servicos Database");
        if (!f.exists()) {
            try {
                f.createNewFile();
                servicos = new ArrayList();
                salvar();
            } catch (IOException e) {

            }
        } else {
            carregar();
        }
    }

    public static RepServicos getInstance() {
        if (instance == null) {
            instance = new RepServicos();

        }
        return instance;
    }

    public ArrayList lista() {
        return servicos;
    }

    public void cadastrar(Servico servico) throws CSException {
        if (!this.servicos.contains(servico)) {
            servicos.add(servico);
            salvar();

        } else {
            CSException ase = new CSException("serviço já cadastrado");
            throw ase;
        }
    }

    public Servico procurar(String descricao) {
        Servico resultado = null;
        for (Servico i : servicos) {
            if (i.getDescricao().equals(descricao)) {

                resultado = i;
            }

        }
        return resultado;
    }

    public void remove(Servico servico) throws RSException {

        if (this.servicos.contains(servico)) {
            servicos.remove(servico);
            salvar();
        } else {
            RSException rse = new RSException("serviço não cadastrado");
            throw rse;
        }

    }

    public void atualizar(Servico desatualizado, Servico atualizado) throws ASException {
        if (!servicos.contains(atualizado) && servicos.contains(desatualizado)) {
            servicos.set(servicos.indexOf(desatualizado), atualizado);
            salvar();
        } else if (servicos.contains(atualizado)) {
            ASException ase = new ASException("serviço novo já existe");
            throw ase;
        } else {
            ASException ase = new ASException("serviço antigo não existe");
            throw ase;
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
            oos.writeObject(servicos);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }
    }

    private void carregar() {
        try {
            servicos = new ArrayList();
            f = new File("Servicos Database");
            InicializeInStreams();
            servicos.addAll((ArrayList<Servico>) ois.readObject());
            ois.close();
            fis.close();

        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
