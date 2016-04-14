package com.example.affonso.agrofinancas;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Affonso on 12/04/2016.
 */
public class AgroFinancasApplication extends Application {

    private List<String> gastos;
    private List<String> ganhos;

    @Override
    public void onCreate() {
        super.onCreate();
        gastos = new ArrayList<>();
        ganhos = new ArrayList<>();
    }

    public void addGanho(String ganho){
        this.ganhos.add(ganho);
    }

    public void addGasto(String gasto){
        this.gastos.add(gasto);
    }

    public List<String> getGanhos(){
        return ganhos;
    }

    public List<String> getGastos(){
        return gastos;
    }

    public double calcularTotal(){
        double ganhoTotal = 0;
        double gastosTotais= 0;
        for (String s : ganhos){
            ganhoTotal += (Double.parseDouble(s));
        }
        for (String s : gastos){
            gastosTotais += (Double.parseDouble(s));
        }

        return ganhoTotal - gastosTotais;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
