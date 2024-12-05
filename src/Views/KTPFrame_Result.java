package Views;

import Controller.KTP_Controller;
import Model.Class.KTP_Model;
import Model.Enum.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KTPFrame_Result extends JFrame {
    public KTPFrame_Result(String nik, String nama, String tempatLahir, String tanggalLahir,
        String gender, String golonganDarah, String alamat, String rt, String rw,
        String kel, String desa, String kecamatan, String agama, String statusPerkawinan,
        String pekerjaan, String kewarganegaraan, String negaraWNA,
        String berlakuHingga, String fotoPath, String tandaTanganPath, String kotaPembuatanKtp, String tglPembuatanKTP) {

        // Set up JFrame
        setTitle("Kartu Tanda Penduduk (KTP)");
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Bagian Judul (Title)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(new Color(173, 216, 230)); // Warna biru muda

        JLabel title = new JLabel("Republik Harapan Bangsa");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);

        // Bagian Data KTP
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid untuk data
        dataPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dataPanel.add(new JLabel("NIK:"));
        dataPanel.add(new JLabel(nik));
        dataPanel.add(new JLabel("Nama:"));
        dataPanel.add(new JLabel(nama));
        dataPanel.add(new JLabel("Tempat/Tgl Lahir:"));
        dataPanel.add(new JLabel(tempatLahir + ", " + tanggalLahir));
        dataPanel.add(new JLabel("Jenis Kelamin:"));
        dataPanel.add(new JLabel(gender + "  Gol. Darah: " + golonganDarah));
        dataPanel.add(new JLabel("Alamat:"));
        dataPanel.add(new JLabel(alamat));
        dataPanel.add(new JLabel("RT/RW:"));
        dataPanel.add(new JLabel(rt + "/" + rw));
        dataPanel.add(new JLabel("Kel/Desa:"));
        dataPanel.add(new JLabel(kel));
        dataPanel.add(new JLabel("Desa:"));
        dataPanel.add(new JLabel(desa));
        dataPanel.add(new JLabel("Kecamatan:"));
        dataPanel.add(new JLabel(kecamatan));
        dataPanel.add(new JLabel("Agama:"));
        dataPanel.add(new JLabel(agama));
        dataPanel.add(new JLabel("Status Perkawinan:"));
        dataPanel.add(new JLabel(statusPerkawinan));
        dataPanel.add(new JLabel("Pekerjaan:"));
        dataPanel.add(new JLabel(pekerjaan));
        dataPanel.add(new JLabel("Kewarganegaraan:"));
        dataPanel.add(new JLabel(kewarganegaraan));
        if (kewarganegaraan.equals("WNA")) {
            dataPanel.add(new JLabel("Negara:"));
            dataPanel.add(new JLabel(negaraWNA));
        }
        dataPanel.add(new JLabel("Berlaku Hingga:"));
        dataPanel.add(new JLabel(berlakuHingga));

        // Bagian Foto dan Tanda Tangan
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2, 10, 10));
        if (fotoPath != null && !fotoPath.isEmpty()) {
            JLabel fotoLabel = new JLabel(new ImageIcon(fotoPath));
            imagePanel.add(fotoLabel);
        } else {
            imagePanel.add(new JLabel("Foto tidak tersedia"));
        }
        if (tandaTanganPath != null && !tandaTanganPath.isEmpty()) {
            JLabel tandaTanganLabel = new JLabel(new ImageIcon(tandaTanganPath));
            imagePanel.add(tandaTanganLabel);
        } else {
            imagePanel.add(new JLabel("Tanda tangan tidak tersedia"));
        }

        // Tambahkan ke Main Panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(dataPanel, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.EAST);

        // Tambahkan Main Panel ke Frame
        add(mainPanel);

        // Set ukuran frame dan tampilkan
        setSize(700, 400); // Sesuaikan ukuran agar semua elemen pas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
