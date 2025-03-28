public class NsAdapter implements  ITreinAdapter {
    private Ns ns;
    public NsAdapter(Ns ns) {
        this.ns = new Ns();

    }
    @Override
    public void boekReis() {
      ns.maakReis();
    }
}
