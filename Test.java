
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {

    }

    /**
     * Test de la Funcionalidad 01.
     */
    public void testFuncionalidad1()
    {
        MailServer Gmail = new MailServer();
        System.out.println("Crea un servidor de nombre Gmail");
        MailClient User1 = new MailClient(Gmail, "pepe@gmail.com");
        System.out.println("Crea un cliente de correo User1(Gmail, \"pepe@gmail.com\")");
        System.out.print("Se espera que tenga 0 mensajes.  -->  ");
        if(Gmail.howManyMailItems("pepe@gmail.com") != 0){
            System.out.print("¡¡¡Error!!! Existen mensajes en el servidor");
        }
        else{
            User1.totalMessage();
            System.out.println("¡¡¡Funciona correctamente!!!");
        }
        MailClient User2 = new MailClient(Gmail, "ana@gmail.com");
        System.out.println("Crea un cliente de correo User2(Gmail, \"ana@gmail.com\")");
        System.out.print("Se espera que tenga 0 mensajes.  -->  ");
        if(Gmail.howManyMailItems("ana@gmail.com") != 0){
            System.out.print("¡¡¡Error!!! Existen mensajes en el servidor");
        }
        else{
            User2.totalMessage();
            System.out.println("¡¡¡Funciona correctamente!!!");
        }
        System.out.println("User1 envía un mensaje a User2");
        User1.sendMailItem("ana@gmail.com", "email1", "Texto");
        System.out.print("Se espera que tenga 1 mensaje.  -->  ");
        if(Gmail.howManyMailItems("ana@gmail.com") > 1){
            System.out.print("¡¡¡Error!!!  -->  El servidor muestra más mensajes de los esperados.");
        }
        else if(Gmail.howManyMailItems("ana@gmail.com") < 1){
            System.out.print("¡¡¡Error!!!  -->  El mensaje no se ha enviado.");
        }
        else{
            User2.totalMessage();
            System.out.println("¡¡¡Funciona correctamente!!!");
        }
        System.out.println("User2 envía 3 mensajes (normal, spam y encriptado) a User1");
        User2.sendMailItem("pepe@gmail.com", "email2", "texto");
        User2.sendMailItem("pepe@gmail.com", "email3", "viaGra");
        User2.sendMailItemEncrypted("pepe@gmail.com", "email4", "regalO");
        System.out.print("Se espera que tenga 3 mensajes.  -->  ");
        if(Gmail.howManyMailItems("pepe@gmail.com") != 3){
            System.out.print("¡¡¡Error!!!  -->  El servidor muestra un número inesperado de mensajes.");
        }
        else{
            User1.totalMessage();
            System.out.println("¡¡¡Funciona correctamente!!!");
        }
    }

    /**
     * Test de la Funcionalidad 02.
     */
    public void testFuncionalidad2()
    {

    }

    /**
     * Test de la Funcionalidad 03.
     */
    public void testFuncionalidad3()
    {

    }

    /**
     * Test de la Funcionalidad 04.
     */
    public void testFuncionalidad4()
    {

    }

    /**
     * Test de la Funcionalidad 05.
     */
    public void testFuncionalidad5()
    {

    }

    /**
     * Test de la Funcionalidad 06.
     */
    public void testFuncionalidad6()
    {

    }
}
