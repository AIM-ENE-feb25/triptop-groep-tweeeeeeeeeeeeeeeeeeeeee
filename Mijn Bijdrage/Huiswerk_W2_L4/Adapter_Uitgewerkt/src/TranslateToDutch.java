public class TranslateToDutch {

    public static void main(String[] args) {
        String word = "car";

        IDirectoryAdapter dictionary =  DirectoryAdapterFactory.getDirectoryAdapter("koenen");
        String translation = dictionary.translate(word);

        if (translation == null){
            dictionary = DirectoryAdapterFactory.getDirectoryAdapter("kramers");
            translation = dictionary.translate(word);
        }

        if (translation == null) {
            System.out.println("Word not found in dictionaries.");
        } else {
            System.out.println("Translation: " + translation + " (Source: " + dictionary.getName() + ")");
        }
    }
}
