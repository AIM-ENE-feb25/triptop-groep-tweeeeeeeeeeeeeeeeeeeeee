public class TreinAdapterFactory {

    public ITreinAdapter getTreinAdapter(String treinNaam) {
        if ("NS".equalsIgnoreCase(treinNaam)) {
            return new NsAdapter(new Ns());
        } else if ("DeutscheBahn".equalsIgnoreCase(treinNaam)) {
            return new DeutscheBahnAdapter(new DeutscheBahn());
        }
        throw new IllegalArgumentException("Onbekende treinmaatschappij: " + treinNaam);
    }
}

