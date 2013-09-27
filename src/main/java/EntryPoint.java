import sample.RSETokenizerSample;
import tagger.Tagger;
import java.io.IOException;


public class EntryPoint {
    public static void main(String[] args) throws IOException {
        System.out.println("Testing RSE 1.11...");
        RSETokenizerSample tokenizerSample = new RSETokenizerSample();
        try {
            tokenizerSample.doIt(new String[] {"/opt/rse-1.11.0", "eng", "/Users/ken/work/sample-executable-jar/src/main/resources/input_eng.txt", "/Users/ken/tmp/out-rse1-11-token-eng.txt"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Testing RSE 2.0...");
        Tagger.main(new String[] {"/Users/ken/tmp/rse-2.0-jarjar", "eng", "/Users/ken/work/sample-executable-jar/src/main/resources/input_eng.txt", "/Users/ken/tmp/out-rse2-0-tagger-eng.txt"});
    }
}
