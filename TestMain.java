public class TestMain {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Punto puntoRojo = new Punto();
        
        puntoRojo.setSistema(Sistema.PLANO);
        puntoRojo.setEtiqueta("ROJO");
        puntoRojo.setX(4);
        puntoRojo.setY(1.3);

        final Punto puntoVerde = new Punto();
        puntoVerde.setSistema(Sistema.PLANO);
        puntoVerde.setEtiqueta("VERDE");
        puntoVerde.setX(6);
        puntoVerde.setY(2.7);

        

        
        

        // codigo que debe de utilizar para probar la implementacion de sus metodos
        final double distanciaEntrePuntoVerde = puntoRojo.dameDistanciaEntreOtroPunto(puntoVerde);
        System.out.println("La distancia es= " +distanciaEntrePuntoVerde);

        final Punto puntoMedioEntrePuntoVerde = puntoRojo.damePuntoMedioEntreOtroPunto(puntoVerde);
        System.out.println("Punto Medio" + puntoMedioEntrePuntoVerde);

    }
}