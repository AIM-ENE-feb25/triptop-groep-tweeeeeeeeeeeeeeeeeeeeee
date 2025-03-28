public class KramersAdapter implements IDirectoryAdapter{
    private KramersDirectory kramers;

    public KramersAdapter(){
        this.kramers = new KramersDirectory();
    }
    @Override
    public String translate(String word) {
        return kramers.find(word);
    }

    @Override
    public String getName() {
        return "Kramers";
    }
}
