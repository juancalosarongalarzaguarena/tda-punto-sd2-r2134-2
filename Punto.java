public class Punto implements IPunto {

    private double x;
    private double y;
    private double z;
    private Sistema sistema;
    private String etiqueta;

    // Métodos constructores
    public Punto() {
        this.x = this.y = this.z = 0;
        this.sistema = Sistema.PLANO;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0; // Valor por defecto para z
        this.sistema = Sistema.PLANO;
    }

    public Punto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sistema = Sistema.ESPACIO;
    }

    public Punto(Sistema sistema, double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0; // Valor por defecto para z
        this.sistema = sistema;
    }

    public Punto(Sistema sistema, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sistema = sistema;
    }

    public Punto(Sistema sistema, String etiqueta, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sistema = sistema;
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "Punto [x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", sistema=" + this.sistema + "]";
    }

    // Métodos get y set
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public double dameDistanciaEntreOtroPunto(Punto otroPunto) {
        double distancia;
        double x1 = this.x;
        double y1 = this.y;
        double z1 = this.z;
        double x2 = otroPunto.getX();
        double y2 = otroPunto.getY();
        double z2 = otroPunto.getZ();

        if (this.sistema == Sistema.PLANO) {
            // Calcular distancia 
            distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        } else if (this.sistema == Sistema.ESPACIO) {
            // Calcular distancia 
            distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        } else {
            System.out.println("Debe proporcionar un sistema, no se puede realizar la operación.");
            distancia = -1; // Valor de error
        }
        return distancia;
    }

    @Override
    public Punto damePuntoMedioEntreOtroPunto(Punto otroPunto) {
        double xMedio;
        double yMedio;
        double zMedio = 0; // Valor por defecto para z

        if (this.sistema == Sistema.PLANO) {
            // Calcular el punto medio 
            xMedio = (this.x + otroPunto.getX()) / 2;
            yMedio = (this.y + otroPunto.getY()) / 2;
            return new Punto(Sistema.PLANO, xMedio, yMedio);
        } else if (this.sistema == Sistema.ESPACIO) {
            // Calcular el punto medio 
            xMedio = (this.x + otroPunto.getX()) / 2;
            yMedio = (this.y + otroPunto.getY()) / 2;
            zMedio = (this.z + otroPunto.getZ()) / 2;
            return new Punto(Sistema.ESPACIO, xMedio, yMedio, zMedio);
        } else {
            System.out.println("Debe proporcionar un sistema, no se puede realizar la operación.");
            return null;
        }
    }

    // Método para calcular la distancia entre el punto medio y otro punto
    public double dameDistanciaEntrePuntoMedioYPunto(Punto otroPunto) {
        Punto puntoMedio = damePuntoMedioEntreOtroPunto(otroPunto);
        if (puntoMedio != null) {
            return dameDistanciaEntreOtroPunto(puntoMedio);
        } else {
            return -1; // Valor de error si el punto medio es nulo
        }
    }
}

