/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Aplicacion {
    int id_app;
    String nombreApp;
    String estadoApp;

    public Aplicacion() {
    }

    public Aplicacion(int id_app) {
        this.id_app= id_app;
    }

    public Aplicacion(String nombreApp, String estadoApp) {
        this.nombreApp = nombreApp;
        this.estadoApp= estadoApp;
    }

    public int getId_app() {
        return id_app;
    }

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public String getEstadoApp() {
        return estadoApp;
    }

    public void setEstadoApp(String estadoApp) {
        this.estadoApp = estadoApp;
    }

    @Override
    public String toString() {
        return "App{" + "id_vendedor=" + id_app + ", nombreVendedor=" + nombreApp+ ", direVendedor=" + estadoApp + '}';
    }
    
}
