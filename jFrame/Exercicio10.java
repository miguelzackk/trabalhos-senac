package jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

<<<<<<< HEAD
public class Exercicio10 extends JFrame {

    public Exercicio10() {
        setTitle("Sistema de Cadastro");
=======
public class Exercicio10 extends JFrame 
{

    public Exercicio10() 
    {
        setTitle("Gerenciador de Usuários");
>>>>>>> b70ad58 (Task04 finalizada.)
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

<<<<<<< HEAD
        // Botão para abrir a janela de cadastro
        JButton botaoCadastro = new JButton("Novo Cadastro");
        botaoCadastro.addActionListener(e -> new JanelaCadastro().setVisible(true));

        add(botaoCadastro);
    }

    // Método para exibir a mensagem de sucesso
    public void mostrarSucesso(String nome) {
        JOptionPane.showMessageDialog(this, "Cadastro de " + nome + " realizado com sucesso!");
    }

    // Janela para cadastro de dados do usuário
    private class JanelaCadastro extends JFrame {
        private JTextField campoNome;
        private JTextField campoIdade;
        private JRadioButton generoMasculino, generoFeminino, generoOutro;

        public JanelaCadastro() {
            setTitle("Cadastro");
=======
        // Botão para abrir o formulário de cadastro
        JButton botaoNovoCadastro = new JButton("Cadastrar Novo Usuário");
        botaoNovoCadastro.addActionListener(e -> new FormularioCadastroUsuario().setVisible(true));

        add(botaoNovoCadastro);
    }

    // Método auxiliar para exibir mensagem de confirmação
    public void exibirMensagemCadastro(String nome) 
    {
        JOptionPane.showMessageDialog(this, "Usuário " + nome + " cadastrado com sucesso!");
    }

    // Janela interna para realizar o cadastro
    private class FormularioCadastroUsuario extends JFrame 
    {
        private JTextField campoNome;
        private JTextField campoIdade;
        private JRadioButton opcaoMasculino, opcaoFeminino, opcaoOutro;

        public FormularioCadastroUsuario() 
        {
            setTitle("Formulário de Cadastro");
>>>>>>> b70ad58 (Task04 finalizada.)
            setSize(300, 300);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(8, 1));

<<<<<<< HEAD
            // Campos de entrada
            campoNome = new JTextField();
            campoIdade = new JTextField();

            // Opções de gênero
            generoMasculino = new JRadioButton("Masculino");
            generoFeminino = new JRadioButton("Feminino");
            generoOutro = new JRadioButton("Outro");

            // Grupo de botões de gênero
            ButtonGroup grupoGenero = new ButtonGroup();
            grupoGenero.add(generoMasculino);
            grupoGenero.add(generoFeminino);
            grupoGenero.add(generoOutro);

            // Botão de salvar
            JButton botaoSalvar = new JButton("Salvar");
            botaoSalvar.addActionListener(e -> {
                String nome = campoNome.getText();
                String idade = campoIdade.getText();

                // Validação de campos
                if (nome.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                } else {
                    mostrarSucesso(nome);
                    dispose(); // Fecha a janela de cadastro
                }
            });

            // Adiciona componentes na janela de cadastro
=======
            campoNome = new JTextField();
            campoIdade = new JTextField();

            opcaoMasculino = new JRadioButton("Masculino");
            opcaoFeminino = new JRadioButton("Feminino");
            opcaoOutro = new JRadioButton("Outro");

            ButtonGroup grupoSexo = new ButtonGroup();
            grupoSexo.add(opcaoMasculino);
            grupoSexo.add(opcaoFeminino);
            grupoSexo.add(opcaoOutro);

            JButton botaoConfirmarCadastro = new JButton("Confirmar");
            botaoConfirmarCadastro.addActionListener(e -> 
            {
                String nomeDigitado = campoNome.getText();
                String idadeDigitada = campoIdade.getText();

                if (nomeDigitado.isEmpty() || idadeDigitada.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
                } 
                else 
                {
                    exibirMensagemCadastro(nomeDigitado);
                    dispose(); // Fecha o formulário
                }
            });

>>>>>>> b70ad58 (Task04 finalizada.)
            add(new JLabel("Nome:"));
            add(campoNome);
            add(new JLabel("Idade:"));
            add(campoIdade);
<<<<<<< HEAD
            add(generoMasculino);
            add(generoFeminino);
            add(generoOutro);
            add(botaoSalvar);
        }
    }

    public static void main(String[] args) {
=======
            add(opcaoMasculino);
            add(opcaoFeminino);
            add(opcaoOutro);
            add(botaoConfirmarCadastro);
        }
    }

    public static void main(String[] args) 
    {
>>>>>>> b70ad58 (Task04 finalizada.)
        SwingUtilities.invokeLater(() -> new Exercicio10().setVisible(true));
    }
}
