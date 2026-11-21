import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BatuGuntingKertas extends JFrame implements ActionListener {

    private String[] pilihan = {"Batu", "Gunting", "Kertas"};
    private Random acak = new Random();

    private JLabel lblJudul = new JLabel("Pilih salah satu!", SwingConstants.CENTER);
    private JLabel lblHasil = new JLabel("Ayo main", SwingConstants.CENTER);

    public BatuGuntingKertas() {
        setTitle("Batu Gunting Kertas");
        setSize(400, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());                       

        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblHasil.setFont(new Font("SansSerif", Font.BOLD, 16));

        JPanel panelTombol = new JPanel(new GridLayout(1, 3, 10, 10));   
        panelTombol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String nama : pilihan) {
            JButton btn = new JButton(nama);
            btn.addActionListener(this);             

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(Color.ORANGE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(null);
                }
            });
            panelTombol.add(btn);
        }

        add(lblJudul, BorderLayout.NORTH);
        add(lblHasil, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pemain = e.getActionCommand();          
        String komputer = pilihan[acak.nextInt(3)];    

        String hasil;
        if (pemain.equals(komputer)) {
            hasil = "SERI!";
        } else if (pemain.equals("Batu") && komputer.equals("Gunting")
                || pemain.equals("Gunting") && komputer.equals("Kertas")
                || pemain.equals("Kertas") && komputer.equals("Batu")) {
            hasil = "KAMU MENANG!";
        } else {
            hasil = "KAMU KALAH!";
        }

        lblHasil.setText("Kamu: " + pemain + " | Komputer: " + komputer + " -> " + hasil);
    }

    public static void main(String[] args) {
        new BatuGuntingKertas().setVisible(true);
    }
}