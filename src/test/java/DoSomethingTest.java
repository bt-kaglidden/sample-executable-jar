import com.basistech.rbl.disambig.DisambiguationDecodeLogger;
import com.basistech.rosette.bl.Analysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ken on 11/02/2017.
 */
public class DoSomethingTest {
    private static final Logger LOG = LoggerFactory.getLogger(DisambiguationDecodeLogger.class.getName());

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void simple() throws Exception {
        Analysis a = new Analysis();
        LOG.info(a.toString());
        assertNotNull(a);
    }

}