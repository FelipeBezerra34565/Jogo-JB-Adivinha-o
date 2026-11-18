
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Acerte o Número");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setBackground(Color.decode("#111118"));
       painel.setLayout(new GridBagLayout());
frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
frame.setVisible(true); 
        JLabel titulo = new JLabel("Adivinhe o número de 1 a 10!");
        titulo.setForeground(Color.WHITE);

        JTextField input = new JTextField(30);

        JButton button = new JButton("Verificar o Número");

        JLabel mensagem = new JLabel("Você tem 3 vidas 💓!");
        mensagem.setForeground(Color.WHITE);

        Random random = new Random();
        int numero = random.nextInt(10) + 1;

        int[] vida = {3};

        button.addActionListener(e -> {
            try {
                int palpite = Integer.parseInt(input.getText());

                if (palpite < 1 || palpite > 10) {
                    mensagem.setText("Digite um número de 1 a 10!");
                } else if (palpite == numero) {
                    mensagem.setText("Você acertou! 🎉");
                    button.setEnabled(false);
                } else {
                    vida[0]--;

                    if (vida[0] == 0) {
                        mensagem.setText("Você perdeu! Era " + numero);
                        button.setEnabled(false);
                    } else {
                        mensagem.setText("Errou! Vidas restantes: " + vida[0]);
                    }
                }

            } catch (NumberFormatException ex) {
                mensagem.setText("Digite um número válido!");
            }
        });

        painel.add(titulo);
        painel.add(input);
        painel.add(button);
        painel.add(mensagem);

        frame.add(painel);
        frame.setVisible(true);
    }
}
