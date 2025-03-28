public class BouwsteenController {
    public static void main(String[] args) {
        TreinAdapterFactory factory = new TreinAdapterFactory();
        BouwsteenService service = new BouwsteenService(factory);

        service.boekReis("NS");
        service.boekReis("DeutscheBahn");
    }
}