import is.ru.honn.rufan.reader.PlayerReader;
import is.ru.honn.rufan.reader.ReaderFactory;
import is.ru.honn.rufan.reader.TeamReader;
import is.ru.honn.rufan.service.TeamService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-reader.xml")
public class TestReader extends TestCase {
    Logger log = Logger.getLogger(TestTeamService.class.getName());

    @Autowired
    private PlayerReader playerReader;
    private TeamReader teamReader;

    @Test
    public void TestReader()
    {
        

    }
}