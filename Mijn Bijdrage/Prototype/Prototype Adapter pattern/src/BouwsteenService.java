public class BouwsteenService {
    private TreinAdapterFactory treinAdapterFactory;

    public BouwsteenService(TreinAdapterFactory treinAdapterFactory) {
        this.treinAdapterFactory = treinAdapterFactory;
    }

    public void boekReis(String treinNaam) {
        ITreinAdapter adapter = treinAdapterFactory.getTreinAdapter(treinNaam);
        adapter.boekReis();
    }
}
