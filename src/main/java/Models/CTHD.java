package Models;

public class CTHD {
    private  int idhd;
    private  int idsp;
    private  int sl;

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public CTHD() {
    }

    public CTHD(int idhd, int idsp, int sl) {
        this.idhd = idhd;
        this.idsp = idsp;
        this.sl = sl;
    }
}
