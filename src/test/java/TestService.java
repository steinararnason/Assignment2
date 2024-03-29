import is.ru.honn.rufan.domain.Player;
import is.ru.honn.rufan.domain.Team;
import is.ru.honn.rufan.observer.PlayerObserver;
import is.ru.honn.rufan.observer.Subject;
import is.ru.honn.rufan.reader.ReaderFactory;
import is.ru.honn.rufan.service.PlayerService;
import is.ru.honn.rufan.service.TeamService;
import is.ru.honn.rufan.service.exception.ServiceException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-test-stub.xml")
//@ContextConfiguration("file:src/main/resources/service.xml")
public class TestService extends TestCase {

    Logger log = Logger.getLogger(TestService.class.getName());
    private Subject subject = new Subject();



    @Autowired
    private PlayerService servicePlayer;

    @Test
    public void testPlayer() {
        Player player1 = new Player(0, "Memphis", "Depay",1);
        Player player2 = new Player(1, "Theo", "Walcott", 2);

        /**Testing addPlayer*/
        try {
            servicePlayer.addPlayer(player1);
            servicePlayer.addPlayer(player2);
        } catch (ServiceException e) {
            String msg = "Adding players failed";
            log.info(msg);
            assertTrue(false);
        }

        /**Testing addPlayer failure*/
        try {
            servicePlayer.addPlayer(player1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        /**Testing getPlayer existing*/
        Player player3 = servicePlayer.getPlayer(0);
        assertSame(player1, player3);

        /**Testing getPlayer non-existing*/
        Player player4 = servicePlayer.getPlayer(2);
        assertNull(player4);
    }

    @Autowired
    private TeamService serviceTeam;

    @Test
    public void testTeam(){
        Team team1 = new Team(123, "kj","KJAY");
        Team team2 = new Team(321, "sa", "STONY");
        Team fail = new Team(1123, "", "WorstTeamEver");
        int myLeuage = 1337;

        /**Testing addTeam*/
        try {
            serviceTeam.addTeam(myLeuage, team1);
            serviceTeam.addTeam(myLeuage, team2);
            assertEquals(2, serviceTeam.getTeams(myLeuage).size());
        } catch (ServiceException e) {
            log.info(e.getMessage());
            assertTrue(false);
        }

        /**Testing addTeam failure*/
        try {
            serviceTeam.addTeam(myLeuage, team1);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

        try {
            serviceTeam.addTeam(myLeuage, fail);
        } catch (ServiceException e) {
            assertSame(ServiceException.class, e.getClass());
        }

    }

    @Test
    public void testObserver() {
        new PlayerObserver(subject);
        Player newPlayer = new Player(22, "Kristinn", "Juliusson", 39);

        try {
            servicePlayer.addPlayer(newPlayer);
        } catch (ServiceException e) {
            log.info(e.getMessage());
        }
        subject.setState(newPlayer);
        assertSame(subject.getState(), newPlayer);
    }

}
