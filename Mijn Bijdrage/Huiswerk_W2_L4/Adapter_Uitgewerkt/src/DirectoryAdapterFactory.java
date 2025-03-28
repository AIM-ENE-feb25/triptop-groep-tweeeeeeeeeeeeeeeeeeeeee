public class DirectoryAdapterFactory {
    public static IDirectoryAdapter getDirectoryAdapter(String directoryName) {
        if (directoryName.equalsIgnoreCase("koenen")) {
            return new KoenenAdapter();
        } else if (directoryName.equalsIgnoreCase("kramers")) {
            return new KramersAdapter();
        } else {
            throw new IllegalArgumentException("Invalid directory name: " + directoryName);
        }
    }
}
