public class DeutscheBahnAdapter implements ITreinAdapter{
    private DeutscheBahn deutscheBahn;

    public DeutscheBahnAdapter(DeutscheBahn deutscheBahn) {
        this.deutscheBahn = new DeutscheBahn();

    }
    @Override
    public void boekReis() {
     deutscheBahn.vindReis();
    }
}
