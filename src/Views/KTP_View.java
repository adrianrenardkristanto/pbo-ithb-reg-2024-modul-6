package Views;

import Controller.KTP_Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.*;

public class KTP_View extends JFrame {
    private KTP_Controller controller;
    public void setController(KTP_Controller controller) {
        this.controller = controller;
    }

    public KTP_Controller getController() {
        return controller;
    }

    private JTextField inputNIK = new JTextField();
    private JTextField inputNama = new JTextField();
    private JTextField inputTempatLahir = new JTextField();
    private JSpinner inputTanggalLahir = new JSpinner(new SpinnerDateModel());
    private ButtonGroup genderGroup = new ButtonGroup();
    private JRadioButton genderMale = new JRadioButton("Pria");
    private JRadioButton genderFemale = new JRadioButton("Wanita");
    private ButtonGroup bloodGroup = new ButtonGroup();
    private JRadioButton bloodA = new JRadioButton("A");
    private JRadioButton bloodB = new JRadioButton("B");
    private JRadioButton bloodAB = new JRadioButton("AB");
    private JRadioButton bloodO = new JRadioButton("O");
    private JTextField inputAlamat = new JTextField();
    private JTextField inputRT = new JTextField();
    private JTextField inputRW = new JTextField();
    private JTextField inputKelurahan = new JTextField();
    private JTextField inputDesa = new JTextField();
    private JTextField inputKecamatan = new JTextField();
    private JComboBox<String> comboAgama = new JComboBox<>(new String[]{"Islam", "Kristen", "Katolik", "Hindu", "Buddha", "Konghucu"});
    private JComboBox<String> comboPerkawinan = new JComboBox<>(new String[]{"Belum Menikah", "Menikah", "Janda/Duda"});
    private JCheckBox pekerjaanKaryawan = new JCheckBox("Karyawan Swasta");
    private JCheckBox pekerjaanPNS = new JCheckBox("PNS");
    private JCheckBox pekerjaanWiraswasta = new JCheckBox("Wiraswasta");
    private JCheckBox pekerjaanAkademisi = new JCheckBox("Akademisi");
    private JCheckBox pekerjaanPengangguran = new JCheckBox("Pengangguran");
    private ButtonGroup kewarganegaraanGroup = new ButtonGroup();
    private JRadioButton wni = new JRadioButton("WNI");
    private JRadioButton wna = new JRadioButton("WNA");
    private JTextField inputNegaraWNA = new JTextField();
    private JButton pilihFoto = new JButton("Pilih Foto");
    private JButton pilihTandaTangan = new JButton("Pilih Tanda Tangan");
    private JTextField inputBerlakuHingga = new JTextField();
    private JTextField inputKotaPembuatanKTP = new JTextField();
    private JSpinner inputTanggalPembuatan = new JSpinner(new SpinnerDateModel());
    private JDatePickerImpl datePicker;
    private JButton insertButton = new JButton("Insert Data");
    private String fotoPath = "";
    private String tandaTanganPath = "";


    public KTP_View() {
        setTitle("Form Pembuatan KTP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(24, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("NIK:"));
        mainPanel.add(inputNIK);

        mainPanel.add(new JLabel("Nama:"));
        mainPanel.add(inputNama);

        mainPanel.add(new JLabel("Tempat Lahir:"));
        mainPanel.add(inputTempatLahir);

        mainPanel.add(new JLabel("Tanggal Lahir:"));
        datePicker = createDatePicker();
        mainPanel.add(datePicker);

        mainPanel.add(new JLabel("Jenis Kelamin:"));
        JPanel genderPanel = new JPanel();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        genderPanel.add(genderMale);
        genderPanel.add(genderFemale);
        mainPanel.add(genderPanel);

        mainPanel.add(new JLabel("Golongan Darah:"));
        JPanel bloodPanel = new JPanel();
        bloodGroup.add(bloodA);
        bloodGroup.add(bloodB);
        bloodGroup.add(bloodAB);
        bloodGroup.add(bloodO);
        bloodPanel.add(bloodA);
        bloodPanel.add(bloodB);
        bloodPanel.add(bloodAB);
        bloodPanel.add(bloodO);
        mainPanel.add(bloodPanel);

        mainPanel.add(new JLabel("Alamat:"));
        mainPanel.add(inputAlamat);

        mainPanel.add(new JLabel("RT:"));
        mainPanel.add(inputRT);

        mainPanel.add(new JLabel("RW:"));
        mainPanel.add(inputRW);

        mainPanel.add(new JLabel("Kelurahan:"));
        mainPanel.add(inputKelurahan);

        mainPanel.add(new JLabel("Desa:"));
        mainPanel.add(inputDesa);

        mainPanel.add(new JLabel("Kecamatan:"));
        mainPanel.add(inputKecamatan);

        mainPanel.add(new JLabel("Agama:"));
        mainPanel.add(comboAgama);

        mainPanel.add(new JLabel("Status Perkawinan:"));
        mainPanel.add(comboPerkawinan);

        mainPanel.add(new JLabel("Pekerjaan:"));
        JPanel pekerjaanPanel = new JPanel();
        pekerjaanPanel.add(pekerjaanKaryawan);
        pekerjaanPanel.add(pekerjaanPNS);
        pekerjaanPanel.add(pekerjaanWiraswasta);
        pekerjaanPanel.add(pekerjaanAkademisi);
        pekerjaanPanel.add(pekerjaanPengangguran);
        mainPanel.add(pekerjaanPanel);
        pekerjaanPengangguran.addActionListener(e -> {
            boolean disabled = pekerjaanPengangguran.isSelected();
            pekerjaanKaryawan.setEnabled(!disabled);
            pekerjaanPNS.setEnabled(!disabled);
            pekerjaanWiraswasta.setEnabled(!disabled);
            pekerjaanAkademisi.setEnabled(!disabled);
        });

        mainPanel.add(new JLabel("Kewarganegaraan:"));
        JPanel kewarganegaraanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        kewarganegaraanGroup.add(wni);
        kewarganegaraanGroup.add(wna);
        kewarganegaraanPanel.add(wni);
        kewarganegaraanPanel.add(wna);
        inputNegaraWNA.setColumns(10); 
        inputNegaraWNA.setVisible(false); 
        kewarganegaraanPanel.add(inputNegaraWNA);
        mainPanel.add(kewarganegaraanPanel);
        wna.addActionListener(e -> {
            inputNegaraWNA.setVisible(true);  
            mainPanel.revalidate(); 
        });
        wni.addActionListener(e -> {
            inputNegaraWNA.setVisible(false); 
            mainPanel.revalidate(); 
        });

        mainPanel.add(new JLabel("Foto:"));
        mainPanel.add(pilihFoto);
        
        mainPanel.add(new JLabel("Tanda Tangan:"));
        mainPanel.add(pilihTandaTangan);
        
        pilihFoto.addActionListener(e -> pilihFile("Pilih Foto", "Foto"));
        pilihTandaTangan.addActionListener(e -> pilihFile("Pilih Tanda Tangan", "Tanda Tangan"));

        mainPanel.add(new JLabel("Berlaku Hingga:"));
        mainPanel.add(inputBerlakuHingga);

        mainPanel.add(new JLabel("Kota Pembuatan KTP:"));
        mainPanel.add(inputKotaPembuatanKTP);

        mainPanel.add(new JLabel("Tanggal Pembuatan:"));
        inputTanggalPembuatan.setEditor(new JSpinner.DateEditor(inputTanggalPembuatan, "yyyy-MM-dd"));
        mainPanel.add(inputTanggalPembuatan);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nik = inputNIK.getText();
                    String nama = inputNama.getText();
                    String tempatLahir = inputTempatLahir.getText();
                    Date tanggalLahirDate = (Date) inputTanggalLahir.getValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String tanggalLahir = sdf.format(tanggalLahirDate);
                    String gender = genderMale.isSelected()? "Pria" : "Wanita" ;

                    String golDarah = "";
                    if (bloodA.isSelected()) {
                        golDarah = "A";
                    }else if(bloodB.isSelected()){
                        golDarah = "B";
                    }else if(bloodO.isSelected()){
                        golDarah = "O";
                    }else if(bloodAB.isSelected()){
                        golDarah = "AB";
                    }

                    String alamat = inputAlamat.getText();
                    String rt = inputRT.getText();
                    String rw = inputRW.getText();
                    String kel = inputKelurahan.getText();
                    String desa = inputDesa.getText();
                    String kecamatan = inputKecamatan.getText();
                    String agama = (String) comboAgama.getSelectedItem();
                    String statusPerkawinan = (String) comboPerkawinan.getSelectedItem();

                    String pk = "";
                    if (pekerjaanKaryawan.isSelected()) pk += "Karyawan Swasta, ";
                    if (pekerjaanWiraswasta.isSelected()) pk += "Wiraswasta, ";
                    if (pekerjaanPNS.isSelected()) pk += "PNS, ";
                    if (pekerjaanAkademisi.isSelected()) pk += "Akademisi, ";
                    if (pk.length() > 0) {
                        pk = pk.substring(0, pk.length() - 2); 
                    } else if (pekerjaanPengangguran.isSelected()) {
                        pk += "Pengangguran";
                    }

                    String kewarganegaraan = wni.isSelected() ? "WNI" : "WNA";
                    String negaraWNA = kewarganegaraan.equals("WNA") ? wna.getText() : "-";
                    String berlakuHingga = inputBerlakuHingga.getText();
                    String kotaPembuatanKtp = inputKotaPembuatanKTP.getText();
                    Date tglPembuatanKtp = (Date) inputTanggalLahir.getValue();
                    String tanggalPembuatanKTP = sdf.format(tglPembuatanKtp);

              
                    KTPFrame_Result frame = new KTPFrame_Result(
                            nik, nama, tempatLahir, tanggalLahir, gender, golDarah, 
                            alamat, rt, rw, kel, desa, kecamatan, agama, statusPerkawinan, 
                            pk, kewarganegaraan, negaraWNA, berlakuHingga, fotoPath, 
                            tandaTanganPath, kotaPembuatanKtp, tanggalPembuatanKTP
                    );
                    frame.setVisible(true);
                    frame.setSize(600, 800); 
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JOptionPane.showMessageDialog(KTP_View.this, "Data berhasil dimasukkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(KTP_View.this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setVisible(true);
    }

    private JDatePickerImpl createDatePicker() {
        Properties properties = new Properties();
        properties.put("text.today", "Hari Ini");
        properties.put("text.month", "Bulan");
        properties.put("text.year", "Tahun");

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateComponentFormatter());
    }

    private void pilihFile(String title, String type) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (type.equals("Foto")) {
                fotoPath = selectedFile.getAbsolutePath();
            } else if (type.equals("Tanda Tangan")) {
                tandaTanganPath = selectedFile.getAbsolutePath();
            }
        }
    }

    private void validateAndSubmit() {
    //     String nik = view.getInputNIK();
    //     String nama = view.getInputNama();
    //     String tempatLahir = view.getInputTempatLahir();
    //     String tanggalLahir = view.getInputTanggalLahir();
    //     String gender = view.getInputGender();
    //     String golonganDarah = view.getInputGolonganDarah();
    //     String alamat = view.getInputAlamat();
    //     String agama = view.getInputAgama();
    //     String statusPerkawinan = view.getInputStatusPerkawinan();
    //     String pekerjaan = view.getInputPekerjaan();
    //     String kewarganegaraan = view.getInputKewarganegaraan();
    //     String negaraWNA = kewarganegaraan.equals("WNA") ? view.getInputNegaraWNA() : "";
    //     String fotoPath = view.getFotoPath();
    //     String tandaTanganPath = view.getTandaTanganPath();

    //     // Buat objek model dengan data yang diambil dari form
    //     model = new KTP_Model(nik, nama, tempatLahir, tanggalLahir, gender, golonganDarah, 
    //                           alamat, agama, statusPerkawinan, pekerjaan, kewarganegaraan, 
    //                           negaraWNA, fotoPath, tandaTanganPath);


    
    }

    public static void main(String[] args) {
        new KTP_View();
    }
}
