package cine.controlador;

public class ClsUsuarios {
    private int idUsuario;
    private String Usuario;
    private String Password;
    private int estado;
    public ClsUsuarios() {
    }

    public ClsUsuarios(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public ClsUsuarios(String Usuario, String Password, int estado) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.estado = estado;
    }
    
    public ClsUsuarios(int idUsuario, String Usuario, String Password, int estado) {
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.Password = Password;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getestado() {
        return estado;
    }

    public void setestado(int estado) {
        this.estado = estado;
    }

}