package principal;

import dao.TrabajadorDao;
import vo.TrabajadorVo;

public class Relaciones {

    private Coordinador coordinador;
    private TrabajadorDao trabajadorDao;
    private TrabajadorVo trabajadorVo;

    public Relaciones() {
        inicializar();
    }

    public void inicializar() {
        coordinador = new Coordinador();
        trabajadorDao = new TrabajadorDao();
        trabajadorVo = new TrabajadorVo();
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public TrabajadorDao getTrabajadorDao() {
        return trabajadorDao;
    }

    public TrabajadorVo getTrabajadorVo() {
        return trabajadorVo;
    }
}

