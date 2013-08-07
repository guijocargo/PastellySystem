package model;

/**
 *
 * @author Felipe
 */
public class ReservaBean {

    private int CodReserva;
    private int CodCli;
    private int CodUsuario;
    private String DtReserva;
    private String HoraInicio;
    private String HoraFim;

    public int getCodCli() {
        return CodCli;
    }

    public void setCodCli(int CodCli) {
        this.CodCli = CodCli;
    }

    public int getCodReserva() {
        return CodReserva;
    }

    public void setCodReserva(int CodReserva) {
        this.CodReserva = CodReserva;
    }

    public int getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getDtReserva() {
        return DtReserva;
    }

    public void setDtReserva(String DtReserva) {
        this.DtReserva = DtReserva;
    }


    public String getHoraFim() {
        return HoraFim;
    }

    public void setHoraFim(String HoraFim) {
        this.HoraFim = HoraFim;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public ReservaBean() {
    }

    public ReservaBean(int CodReserva, int CodCli, int CodUsuario, String DtReserva, String HoraInicio, String HoraFim) {
        this.CodReserva = CodReserva;
        this.CodCli = CodCli;
        this.CodUsuario = CodUsuario;
        this.DtReserva = DtReserva;
        this.HoraInicio = HoraInicio;
        this.HoraFim = HoraFim;
    }
    
}