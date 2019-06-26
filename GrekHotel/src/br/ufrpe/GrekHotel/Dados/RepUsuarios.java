/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Funcionario;
import br.ufrpe.GrekHotel.Negocio.beans.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author fight
 */
public class RepUsuarios {

    private ArrayList<Usuario> usuarios;
    private static RepUsuarios instance;

    private File f;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private RepUsuarios() {
        f = new File("Usuarios Database");
        if (!f.exists()) {
            try {
                f.createNewFile();
                usuarios = new ArrayList();
                usuarios.add(new Funcionario("adm", "adm", "Administrador", 0, 0));
                salvar();
            } catch (IOException e) {

            }
        } else {
            carregar();
        }
    }

    public static RepUsuarios getInstance() {
        if (instance == null) {
            instance = new RepUsuarios();
        }
        return instance;
    }

    public void cadastrar(Usuario u) throws CUException {
        if (!usuarios.contains(u)) {
            usuarios.add(u);
            salvar();
        } else {
            CUException aue = new CUException("login já está sendo utilizado");
            throw aue;
        }
    }

    public Usuario procurar(String login, String senha) {
        Usuario encontrado = null;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                encontrado = u;
            }
        }
        return encontrado;
    }
    
    public List listarFunc(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        for(Usuario u : usuarios){
            if(u instanceof Funcionario){
                funcionarios.add((Funcionario) u);
            }
        }
        return Collections.unmodifiableList(funcionarios);
    }

    public void remover(Usuario u) throws RUException {
        if (usuarios.contains(u)) {
            usuarios.remove(u);
            salvar();
        } else {
            RUException rue = new RUException("usuario não existe");
            throw rue;
        }
    }

    public void atualizar(Usuario desatualizado, Usuario atualizado) throws AUException {
        if (!usuarios.contains(atualizado) && usuarios.contains(desatualizado)) {
            usuarios.set(usuarios.indexOf(desatualizado), atualizado);
            salvar();
        } else if (usuarios.contains(atualizado)) {
            AUException aue = new AUException("usuario já existe");
            throw aue;
        } else {
            AUException aue = new AUException("usuario antigo não existe");
            throw aue;
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
            oos.writeObject(usuarios);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {

        }
    }

    private void carregar() {
        try {
            usuarios = new ArrayList();
            f = new File("Usuarios Database");
            InicializeInStreams();
            usuarios.addAll((ArrayList<Usuario>) ois.readObject());
            ois.close();
            fis.close();

        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
