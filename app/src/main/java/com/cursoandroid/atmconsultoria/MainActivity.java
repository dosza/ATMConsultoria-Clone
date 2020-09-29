package com.cursoandroid.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void  enviarEmail(){
       String celular ="tel:967871859";
       String endereco="https://www.google.com/maps/place/Pal%C3%A1cio+de+Buckingham/@51.501364,-0.14189,15z/data=!4m5!3m4!1s0x0:0xa26abf514d902a7!8m2!3d51.501364!4d-0.14189https://www.google.com/maps/place/Pal%C3%A1cio+de+Buckingham/@51.501364,-0.14189,15z/data=!4m5!3m4!1s0x0:0xa26abf514d902a7!8m2!3d51.501364!4d-0.14189";
       String imagem="https://www.escolalinux.com.br/images/easyblog_articles/151/kernel.png";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(imagem));

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String [] {"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");
        intent.setType("message/rfc822"); //tipo envio de email
        //intent.setType("text/plain");
        //intent.setType("image/*");
      //  intent.setType("application/pdf");
        startActivity(Intent.createChooser(intent,"Escolha um App de e-mail"));
    }
}
