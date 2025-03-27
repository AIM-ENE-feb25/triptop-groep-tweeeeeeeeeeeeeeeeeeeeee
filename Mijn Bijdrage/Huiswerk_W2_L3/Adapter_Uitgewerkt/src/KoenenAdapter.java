public class KoenenAdapter implements IDirectoryAdapter{
    private KoenenDirectory koenen;

    public KoenenAdapter() {
        this.koenen = new KoenenDirectory();
        this.koenen.openEnglishDutch();
    }

    @Override
    public String translate(String word) {
        return koenen.lookUp(word);
    }

    @Override
    public String getName() {
        return "Koenen";
    }
}
