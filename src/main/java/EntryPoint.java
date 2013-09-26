import sample.RSELemmatizerSample;
import sample.RSETokenizerSample;

import java.io.IOException;
import java.util.Arrays;

/**
 * User: luke
 * Date: 7/05/13
 * Time: 6:50 AM
 */
public class EntryPoint {
    public static void main(String[] args) throws IOException {
        RSELemmatizerSample lemmatizerSample = new RSELemmatizerSample();
        try {
            lemmatizerSample.doIt(new String[] {"/opt/rse-1.11.0", "eng", "/Users/ken/work/sample-executable-jar/src/main/resources/input_eng.txt", "/Users/ken/tmp/out-lemma-eng.txt"});
            lemmatizerSample.doIt(new String[] {"/opt/rse-1.11.0", "swe", "/Users/ken/work/sample-executable-jar/src/main/resources/input_swe.txt", "/Users/ken/tmp/out-lemma-swe.txt"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        RSETokenizerSample tokenizerSample = new RSETokenizerSample();
        try {
            tokenizerSample.doIt(new String[] {"/opt/rse-1.11.0", "eng", "/Users/ken/work/sample-executable-jar/src/main/resources/input_eng.txt", "/Users/ken/tmp/out-token-eng.txt"});
            tokenizerSample.doIt(new String[] {"/opt/rse-1.11.0", "swe", "/Users/ken/work/sample-executable-jar/src/main/resources/input_swe.txt", "/Users/ken/tmp/out-token-swe.txt"});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
