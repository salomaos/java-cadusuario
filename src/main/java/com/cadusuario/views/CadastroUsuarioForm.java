package com.cadusuario.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import com.cadusuario.models.*;

public class CadastroUsuarioForm extends JFrame {
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;

    public CadastroUsuarioForm() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        panel.add(txtSenha);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this::cadastrarUsuario);
        panel.add(btnCadastrar);

        add(panel);
    }

    private void cadastrarUsuario(ActionEvent e) {
        try {
            Usuario usuario = new Usuario(
                    txtNome.getText(),
                    txtEmail.getText(),
                    new String(txtSenha.getPassword()));

            Database.salvarUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}