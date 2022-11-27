package com.mycompany.simercandetc.Controlador;

import com.mycompany.simercandetc.Dao.EnviarCorreoDao;
import com.mycompany.simercandetc.Modelo.Asesor;
import com.mycompany.simercandetc.Vista.VistaDesCorreo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class ControladorVistaDesCorreo {

    private VistaDesCorreo vdc;
    private EnviarCorreoDao enCoDao;
    private Asesor as;

    private String idU;
    private String idFila;

    public ControladorVistaDesCorreo() {
        this.vdc = new VistaDesCorreo();
        this.enCoDao = new EnviarCorreoDao();
        this.as = new Asesor();

    }

    public void mostrar(String idU, String idFila) {
        this.idU = idU;
        this.idFila = idFila;

        vdc.setLocationRelativeTo(null);
        vdc.setVisible(true);
        vdc.txtIdU.setText(idU);
        vdc.txtFila.setText(idFila);
        if (vdc.txtFila.getText().equals("todos")) {
            vdc.cmbPrograma.setVisible(true);
        } else {
            vdc.cmbPrograma.setVisible(false);

        }
        vdc.jtRuta.setVisible(false);
        vdc.btnRuta.setVisible(false);

    }

    public void enviarCorreo(String asunto, MimeMultipart mp, String correoEmisor, String correoReceptor, String contraseñaCorreo,String adj,String mensaje) {

        String idU = vdc.txtIdU.getText();
        String idF = vdc.txtFila.getText();

        Properties objetoPEC = new Properties();

        objetoPEC.put("mail.smtp.host", "smtp.gmail.com");
        objetoPEC.setProperty("mail.smtp.starttls.enable", "true");
        objetoPEC.put("mail.smtp.port", "587");
        objetoPEC.setProperty("mail.smtp.port", "587");
        objetoPEC.put("mail.smtp.user", correoEmisor);
        objetoPEC.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(objetoPEC);
        MimeMessage mail = new MimeMessage(sesion);

        try {
            mail.setFrom(new InternetAddress(correoEmisor));
            mail.addRecipients(Message.RecipientType.TO, correoReceptor);
            mail.setSubject(asunto);
            if(adj.equals("Si")){
                mail.setContent(mp);
            }else{
                mail.setText(mensaje, "ISO-8859-1", "html");
            }
            
            

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEmisor, contraseñaCorreo);
            transporte.sendMessage(mail, mail.getAllRecipients());
            transporte.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al enviar el correo " + ex);
            System.out.println(ex);
        }

    }
    
    public void correo(){
        
    }

    

}
