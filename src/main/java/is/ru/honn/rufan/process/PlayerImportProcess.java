package is.ru.honn.rufan.process;

import is.ru.honn.rufan.reader.ReadHandler;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.TeamService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.logging.Logger;

public class PlayerImportProcess extends RuAbstractProcess implements ReadHandler {
    Logger log = Logger.getLogger(this.getClass().getName());
    protected PlayerService playerService;
    protected TeamService teamService;
    ReadHandler readHandler;
    MessageSource msg;

    @Override
    public void beforeProcess() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:reader.xml");

    }

    @Override
    public void startProcess() {

    }

    @Override
    public void afterProcess() {
        super.afterProcess();
    }

    public void read(int count, Object object) {

    }
}
