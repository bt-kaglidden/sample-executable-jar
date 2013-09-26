/******************************************************************************
 ** This data and information is proprietary to, and a valuable trade secret
 ** of, Basis Technology Corp.  It is given in confidence by Basis Technology
 ** and may only be used as permitted under the license agreement under which
 ** it has been distributed, and in no other way.
 **
 ** Copyright (c) 2000-2010 Basis Technology Corporation All rights reserved.
 **
 ** The technical data and information provided herein are provided with
 ** `limited rights', and the computer software provided herein is provided
 ** with `restricted rights' as those terms are defined in DAR and ASPR
 ** 7-104.9(a).
 ******************************************************************************/

package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import com.basistech.rosette.bl.Lemmatizer;
import com.basistech.rosette.bl.LemmatizerFactory;
import com.basistech.rosette.bl.LemmatizerOption;
import com.basistech.rosette.breaks.Token;
import com.basistech.rosette.breaks.Tokenizer;
import com.basistech.rosette.breaks.TokenizerFactory;
import com.basistech.rosette.breaks.TokenizerOption;
import com.basistech.util.LanguageCode;

public class RSELemmatizerSample {

    TokenizerFactory tokenizerFactory;
    LemmatizerFactory lemmatizerFactory;

    public RSELemmatizerSample() {
        tokenizerFactory = new TokenizerFactory();
        lemmatizerFactory = new LemmatizerFactory();
    }
    
    private static void skipBOM(Reader in) throws IOException {
        in.mark(1);
        if (in.read() != '\uFEFF') {
            in.reset();
        }        
    }

    public void doIt(String[] args) throws Exception {
        if (args.length != 4) {
            System.err.println("Usage: must call with 4 args: "
                               + "rootDirectory ISO639_code inputFile outputFile");
            System.exit(1);
        }
        String rootDirectory = args[0];
        LanguageCode langCode = LanguageCode.lookupByISO639(args[1]);
        String inputFile = args[2];
        String outputFile = args[3];

        Reader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
        skipBOM(in);
        Writer out = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8");
        RSELemmatizerSample that = new RSELemmatizerSample();
        that.tokenizerFactory.setOption(TokenizerOption.rootDirectory, rootDirectory);
        that.lemmatizerFactory.setOption(LemmatizerOption.rootDirectory, rootDirectory);
        that.processText(langCode, in, out);
        in.close();
        out.close();
        System.out.println("See output in " + outputFile);
    }

    void processText(LanguageCode langCode, Reader in, Writer out) throws IOException {
        Tokenizer tokenizer = tokenizerFactory.create(in, langCode);
        Lemmatizer lemmatizer = lemmatizerFactory.create(langCode);
        Token t;
        String eol = System.getProperty("line.separator");
        while ((t = tokenizer.next()) != null) {
            int start = t.getStart();
            int length = t.getLength();
            String normToken = new String(t.getBuffer(), start, length);
            Iterable<Token> tokenIterable = lemmatizer.lemmatize(normToken);
            out.write("Token: " + normToken + eol);
            for (Token token : tokenIterable) {
                out.write(token.getType() + " " 
                          + new String(token.getBuffer(), token.getStart(), token.getLength()) + eol);

            }
        }
    }
}

