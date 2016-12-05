package com.llavador.mascotas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity implements View.OnClickListener{
    private EditText etNombre;
    private EditText etEmail;
    private EditText etComentario;
    private Button bEnviar;

    String para;
    String nombre;
    String comentario;

    Session sesion = null;
    ProgressDialog pdialog = null;
    Activity context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etComentario = (EditText) findViewById(R.id.etComentario);
        bEnviar = (Button) findViewById(R.id.bEnviar);

        bEnviar.setOnClickListener(this);
        context = this;
    }

    @Override
    public void onClick(View v) {
        para = etEmail.getText().toString();
        nombre = etNombre.getText().toString();
        comentario = etComentario.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        sesion = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return super.getPasswordAuthentication();
                return new PasswordAuthentication("sandroestefanomarquez@gmail.com", "AtunConTomate");
            }
        });

        pdialog = ProgressDialog.show(context, "", getResources().getString(R.string.contacto_enviando), true);
        intentandoEnviaEmail tarea = new intentandoEnviaEmail();
        tarea.execute();
    }

    class intentandoEnviaEmail extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try{
                Message correo = new MimeMessage(sesion);
                correo.setFrom(new InternetAddress("sandroestefanomarquez@gmail.com"));
                correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
                correo.setSubject(nombre);
                correo.setContent(comentario, "text/html; charset=utf-8");

                Transport.send(correo);
            }catch (MessagingException e){
                e.printStackTrace();

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result){
            pdialog.dismiss();
            etEmail.setText("");
            etComentario.setText("");
            etNombre.setText("");
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            context.finish();
        }
    }
}
