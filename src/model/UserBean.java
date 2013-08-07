package model;

/**
 *
 * @author Guilherme
 */
public class UserBean implements java.io.Serializable {

    private int codigo;
    private String login;
    private String password;
    private int nivel;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean() {
    }

    public UserBean(int codigo, String login, String password, int nivel) {
        this.codigo = codigo;
        this.login = login;
        this.password = password;
        this.nivel = nivel;
    }
    
}