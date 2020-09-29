package com.cursoandroid.atmconsultoria.ui.Sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cursoandroid.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String descricao = "A ATM consultoria tem por objetivo apoiar organizações "
                + "que desejam alcançar o sucesso através da excelencia em gestão "
                +"da busca pela qualidade ";
        Element versao = new Element();
        versao.setTitle("Versão     1.0");
        return new AboutPage(getActivity()).setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br","Envie um email")
                .addGroup("Redes sociais")
                .addWebsite("https://google.com/","Acesse o site")
                .addFacebook("daniel.vmlinuz","Facebook")
                .addInstagram("dan.vmlinuz","Instagram")
                .addTwitter("jamiltondamasceno","Twitter")
                .addYoutube("jamiltondamasceno","Youtube")
                .addGitHub("jamiltondamasceno","Github")
                .addPlayStore("com.facebook.katana","Download App")
                .addItem(versao)
                .create();

       // return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
