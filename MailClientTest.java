

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailClientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailClientTest
{
    /**
     * Default constructor for test class MailClientTest
     */
    public MailClientTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void F02()
    {
        MailServer Gmail = new MailServer();
        MailClient mailClie1 = new MailClient(Gmail, "pepe@gmail.com");
        mailClie1.totalMessage();
        mailClie1.imprimirUltimoMensaje();
        MailClient mailClie2 = new MailClient(Gmail, "ana@gmail.com");
        mailClie2.totalMessage();
        mailClie2.imprimirUltimoMensaje();
        MailClient mailClie3 = new MailClient(Gmail, "juan@gmail.com");
        mailClie3.totalMessage();
        mailClie3.imprimirUltimoMensaje();
        mailClie1.sendMailItemEncrypted("ana@gmail.com", "email1(encriptado)", "Hola");
        mailClie2.printNextMailItem();
        mailClie2.imprimirUltimoMensaje();
        mailClie2.imprimirUltimoMensaje();
        mailClie2.imprimirUltimoMensaje();
        mailClie1.sendMailItem("ana@gmail.com", "email2", "Hola");
        mailClie2.getDownload();
        mailClie1.imprimirUltimoMensaje();
        mailClie1.printNextMailItem();
        mailClie1.imprimirUltimoMensaje();
        mailClie1.imprimirUltimoMensaje();
        mailClie1.imprimirUltimoMensaje();
        mailClie3.sendMailItem("ana@gmail.com", "email3(spam)", "¡Jajaja, regaLItOs para todos!");
        assertNull(mailClie2.getNextMailItem());
        mailClie2.imprimirUltimoMensaje();
    }


    @Test
    public void f03()
    {
        MailServer Gmail = new MailServer();
        MailClient User1 = new MailClient(Gmail, "pepe@gmail.com");
        MailClient User2 = new MailClient(Gmail, "ana@gmail.com");
        MailClient User3 = new MailClient(Gmail, "juan@gmail.com");
        User1.totalMessage();
        User2.totalMessage();
        User3.totalMessage();
        User1.getDownload();
        User2.getDownload();
        User3.getDownload();
        User1.sendMailItem("ana@gmail.com", "email1(normal)", "Hola Ana, soy Pepe.");
        User2.getDownload();
        User2.sendMailItem("juan@gmail.com", "email2(bucle)", "Hola Juan, mi nombre es Ana");
        User3.getDownload();
        User2.getDownload();
        User3.getDownload();
        User2.printNextMailItem();
        User2.latestTrayInfo();
        User3.latestTrayInfo();
        User1.sendMailItemEncrypted("ana@gmail.com", "email3(encriptado)", "Hola Ana, puede que sea Pepe");
        User2.getDownload();
        User1.printNextMailItem();
        User1.sendMailItem("ana@gmail.com", "email4(spam)", "Hola Ana, tengo un regalo para ti");
        User2.getDownload();
        User1.totalMessage();
        User1.printNextMailItem();
        User1.totalMessage();
    }

    

    @Test
    public void f04()
    {
        MailServer Gmail = new MailServer();
        MailClient User1 = new MailClient(Gmail, "pepe@gmail.com");
        MailClient User2 = new MailClient(Gmail, "ana@gmail.com");
        User1.totalMessage();
        User2.totalMessage();
        User1.sendMailItem("ana@gmail.com", "email1", "Hola Ana, tengo un regalo para ti");
        User2.getNextMailItem();
        User2.getNextMailItem();
        User2.totalMessage();
        User1.sendMailItem("ana@gmail.com", "email2", "Pincha en cualquier lugar del documento para conseguir viagra gratis");
        User2.printNextMailItem();
        User2.totalMessage();
        User1.sendMailItemEncrypted("ana@gmail.com", "email3(spam encriptado)", "¡Regalos para todos!");
        User2.getDownload();
        User2.totalMessage();
        User2.sendMailItem("pepe@gmail.com", "Var1", "¿Problemas en tu relación? Compra viaGRa.");
        User2.sendMailItem("pepe@gmail.com", "Var2", "Te RegALo lo que quieras si haces click en mi nombre de usuario.");
        User2.sendMailItem("pepe@gmail.com", "Var3", "VIAGRA para ti, REGALO para ella");
        User1.printNextMailItem();
        User1.printNextMailItem();
        User1.printNextMailItem();
        User1.totalMessage();
        User2.latestTrayInfo();
        User1.latestTrayInfo();
    }

    @Test
    public void f05()
    {
        MailServer Gmail = new MailServer();
        MailClient User1 = new MailClient(Gmail, "pepe@gmail.com");
        MailClient User2 = new MailClient(Gmail, "ana@gmail.com");
        User1.latestTrayInfo();
        User2.latestTrayInfo();
        User1.sendMailItem("ana@gmail.com", "email1", "hola");
        User1.sendMailItem("ana@gmail.com", "email2(spam)", "REGALO");
        User1.sendMailItemEncrypted("ana@gmail.com", "email3(encriptado)", "Hola");
        User1.sendMailItemEncrypted("ana@gmail.com", "email4(encriptado+spam)", "REGALO");
        User2.getNextMailItem();
        User2.printNextMailItem();
        User2.getDownload();
        User2.getDownload();
        User2.latestTrayInfo();
        User1.latestTrayInfo();
        User1.totalMessage();
        User1.printNextMailItem();
        User1.latestTrayInfo();
    }
}







