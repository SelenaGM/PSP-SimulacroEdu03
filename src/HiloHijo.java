import java.util.concurrent.Semaphore;

public class HiloHijo extends Thread{

    public static int contador;
    public static int contadorTotal = 0;
    private Semaphore semaphore;


    public HiloHijo(String name ,Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            contador = 0;
            for (String color : Main.colores) {
                if(color.equalsIgnoreCase(this.getName())){
                    contador++;
                    contadorTotal ++;
                }
            }
            System.out.println("Soy "+this.getName()+" tengo "+contador+" colores");
            semaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
