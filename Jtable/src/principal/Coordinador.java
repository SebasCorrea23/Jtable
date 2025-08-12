package principal;

import dao.TrabajadorDao;
import vo.TrabajadorVo;
import java.util.List;

public class Coordinador {

    private TrabajadorDao trabajadorDao;

    public Coordinador() {
        trabajadorDao = new TrabajadorDao();
    }

    public void registrarTrabajador(TrabajadorVo trabajador) {
        trabajadorDao.registrarTrabajador(trabajador);
    }

    public List<TrabajadorVo> listarTrabajadores() {
        return trabajadorDao.listarTrabajadores();
    }

    public void eliminarTrabajador(String documento) {
        trabajadorDao.eliminarTrabajador(documento);
    }
}
