package com.desarrollo.apptiempodevida;

import androidx.lifecycle.ViewModel;

public class IncrementalViewModel extends ViewModel {
    private Integer resultado;

    public Integer getResultado(){
        if (resultado==null){
            resultado = 0;
        }
        return this.resultado;
    }

    public void setResultado(int valor){
        this.resultado = valor;
    }
}
