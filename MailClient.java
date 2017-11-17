/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // 
    private MailItem ultimoEmail;


    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;     
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
       return server.getNextMailItem(user);
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            ultimoEmail = item;
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to,String subject, String message)
    {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
    }
    
    public void sendMailItemEncrypted(String to, String subject, String message){
        String cadena = message;
        cadena = cadena.replace('a', '$');
        cadena = cadena.replace('á', ')');
        cadena = cadena.replace('e', '&');
        cadena = cadena.replace('é', '_');
        cadena = cadena.replace('i', '#');
        cadena = cadena.replace('í', '@');
        cadena = cadena.replace('o', '+');
        cadena = cadena.replace('ó', '%');
        cadena = cadena.replace('u', '*');
        cadena = cadena.replace('ú', '!');
        cadena = "?=? " + cadena;

        MailItem item = new MailItem(user, to, subject, cadena);
        server.post(item);
    }

    /**
     * Funcionalidad 1
     */
    public void totalMessage()
    {
        System.out.println("Tiene estos mensajes: " + server.howManyMailItems(user));
    }
    
    /**
     * Método añadido que permite imprimir por pantalla el último mensaje
     * tantas veces como se desee (parte 02- Aitor Martínez)
     */
    public void imprimirUltimoMensaje()
    {
        ultimoEmail.print();
    }
 

}
