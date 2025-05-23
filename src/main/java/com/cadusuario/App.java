package com.cadusuario;

import javax.swing.*;
import java.sql.SQLException;
import com.cadusuario.models.Database;
import com.cadusuario.views.CadastroUsuarioForm;

public class App {
    public static void main(String[] args) {
        try {
            // Inicializa banco de dados
            Database.init();

            // Cria e exibe o formulário
            SwingUtilities.invokeLater(() -> {
                CadastroUsuarioForm form = new CadastroUsuarioForm();
                form.setVisible(true);
            });

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha ao iniciar aplicação: " + e.getMessage(),
                    "Erro crítico",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}